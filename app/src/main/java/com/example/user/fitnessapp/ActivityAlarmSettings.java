/****************************************************************************
 * Copyright 2010 kraigs.android@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ****************************************************************************/

package com.example.user.fitnessapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

/**
 * This activity is used for editing alarm settings.  Settings are broken
 * into two pieces: alarm information and actual settings.  Every alarm will
 * have alarm information.  Alarms will only have alarm settings if the user
 * has overridden the default settings for a given alarm.  This dialog is used
 * to edit both the application default settings and individual alarm settings.
 * When editing the application default settings, no AlarmInfo object will
 * be present.  When editing an alarm which hasn't yet had specific settings
 * set, AlarmSettings will contain the default settings.  There is one required
 * EXTRA that must be supplied when starting this activity: EXTRAS_ALARM_ID,
 * which should contain a long representing the alarmId of the settings
 * being edited.  AlarmSettings.DEFAULT_SETTINGS_ID can be used to edit the
 * default settings.
 */
public final class ActivityAlarmSettings extends AppCompatActivity implements
        TimePickerDialog.OnTimeChangedListener,
        TimePickerDialog.OnTimeSetListener {

  public static final String EXTRAS_ALARM_ID = "alarm_id";
  private static final int MISSING_EXTRAS = -69;
    private static final int READ_EXTERNAL_STORAGE_PERMISSION_REQUEST = 0;
    private static final String SETTINGS_VIBRATE_KEY = "SETTINGS_VIBRATE_KEY";
    private static final String SETTINGS_SNOOZE_KEY = "SETTINGS_SNOOZE_KEY";
    private static final String SETTINGS_TIME_HOUR_OF_DAY_KEY = "SETTINGS_TIME_HOUR_OF_DAY_KEY";
    private static final String SETTINGS_TIME_MINUTE_KEY = "SETTINGS_TIME_MINUTE_KEY";
    private static final String SETTINGS_TIME_SECOND_KEY = "SETTINGS_TIME_SECOND_KEY";
    private static final String SETTINGS_NAME_KEY = "SETTINGS_NAME_KEY";
    private static final String SETTINGS_VOLUME_START_PERCENT_KEY = "SETTINGS_VOLUME_START_PERCENT_KEY";
    private static final String SETTINGS_VOLUME_END_PERCENT_KEY = "SETTINGS_VOLUME_END_PERCENT_KEY";
    private static final String SETTINGS_VOLUME_CHANGE_TIME_SEC_KEY = "SETTINGS_VOLUME_CHANGE_TIME_SEC_KEY";
    private static final String SETTINGS_TONE_NAME_KEY = "SETTINGS_TONE_NAME_KEY";
    private static final String SETTINGS_TONE_URI_KEY = "SETTINGS_TONE_URI_KEY";
    private static final String SETTINGS_DAYS_OF_WEEK_KEY = "SETTINGS_DAYS_OF_WEEK_KEY";

  private enum SettingType {
    TIME,
    NAME,
    DAYS_OF_WEEK,
    TONE, SNOOZE,
    VIBRATE,
    VOLUME_FADE
  }

    public static final int NAME_PICKER = 1;
    public static final int DOW_PICKER = 2;
    public static final int TONE_PICKER = 3;
    public static final int SNOOZE_PICKER = 4;
    public static final int VOLUME_FADE_PICKER = 5;
    public static final int DELETE_CONFIRM = 6;
    public static final int EXPLAIN_READ_EXTERNAL_STORAGE = 7;
    public static final int PERMISSION_NOT_GRANTED = 8;

    private TimePickerDialog picker;

  private static long alarmId;
  private static AlarmClockServiceBinder service;
  private DbAccessor db;
  private AlarmInfo originalInfo;
  private static AlarmInfo info;
  private static AlarmSettings originalSettings;
  private static AlarmSettings settings;
  static SettingsAdapter settingsAdapter;
    private static ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      AppSettings.setTheme(getBaseContext(), ActivityAlarmSettings.this);

    super.onCreate(savedInstanceState);

    setContentView(R.layout.settings);

      setTitle(getString(R.string.settings));

      ActionBar actionBar = getSupportActionBar();

      if (actionBar != null) {
          actionBar.setDisplayHomeAsUpEnabled(true);
      }

    // An alarm id is required in the extras bundle.
    alarmId = getIntent().getExtras().getLong(EXTRAS_ALARM_ID, MISSING_EXTRAS);
    if (alarmId == MISSING_EXTRAS) {
      throw new IllegalStateException("EXTRAS_ALARM_ID not supplied in intent.");
    }

    // Access to in-memory and persistent data structures.
    service = new AlarmClockServiceBinder(getApplicationContext());
    db = new DbAccessor(getApplicationContext());

    // Read the current settings from the database.  Keep a copy of the
    // original values so that we can write new values only if they differ
    // from the originals.
    originalInfo = db.readAlarmInfo(alarmId);
    // Info will not be available for the default settings.
    if (originalInfo != null) {
      info = new AlarmInfo(originalInfo);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(SETTINGS_TIME_HOUR_OF_DAY_KEY)
                    && savedInstanceState.containsKey(SETTINGS_TIME_MINUTE_KEY)
                    && savedInstanceState.containsKey(SETTINGS_TIME_SECOND_KEY)) {
                final AlarmTime time = info.getTime();

                info.setTime(new AlarmTime(
                                savedInstanceState.getInt(SETTINGS_TIME_HOUR_OF_DAY_KEY),
                                savedInstanceState.getInt(SETTINGS_TIME_MINUTE_KEY),
                                savedInstanceState.getInt(SETTINGS_TIME_SECOND_KEY),
                                time.getDaysOfWeek()
                        ));
            }

            if (savedInstanceState.containsKey(SETTINGS_NAME_KEY)) {
                info.setName(savedInstanceState.getString(SETTINGS_NAME_KEY));
            }

            if (savedInstanceState.containsKey(SETTINGS_DAYS_OF_WEEK_KEY)) {
                info.setDaysOfWeek(new Week(savedInstanceState.getBooleanArray(
                        SETTINGS_DAYS_OF_WEEK_KEY)));
            }
        }
    }
    originalSettings = db.readAlarmSettings(alarmId);
    settings = new AlarmSettings(originalSettings);

      if (savedInstanceState != null) {
          if (savedInstanceState.containsKey(SETTINGS_SNOOZE_KEY)) {
              settings.setSnoozeMinutes(savedInstanceState.getInt(
                      SETTINGS_SNOOZE_KEY));
          }

          if (savedInstanceState.containsKey(SETTINGS_VIBRATE_KEY)) {
              settings.setVibrate(savedInstanceState.getBoolean(
                      SETTINGS_VIBRATE_KEY));
          }

          if (savedInstanceState.containsKey(SETTINGS_VOLUME_START_PERCENT_KEY)
                  && savedInstanceState.containsKey(SETTINGS_VOLUME_END_PERCENT_KEY)
                  && savedInstanceState.containsKey(SETTINGS_VOLUME_CHANGE_TIME_SEC_KEY)) {
              settings.setVolumeStartPercent(savedInstanceState.getInt(
                      SETTINGS_VOLUME_START_PERCENT_KEY));

              settings.setVolumeEndPercent(savedInstanceState.getInt(
                      SETTINGS_VOLUME_END_PERCENT_KEY));

              settings.setVolumeChangeTimeSec(savedInstanceState.getInt(
                      SETTINGS_VOLUME_CHANGE_TIME_SEC_KEY));
          }

          if (savedInstanceState.containsKey(SETTINGS_TONE_URI_KEY)
                  && savedInstanceState.containsKey(SETTINGS_TONE_NAME_KEY)) {
              settings.setTone((Uri) savedInstanceState.getParcelable(SETTINGS_TONE_URI_KEY),
                      savedInstanceState.getString(SETTINGS_TONE_NAME_KEY));
          }
      }

    // Setup the list of settings.  Each setting is represented by a Setting
    // object.  Create one here for each setting type.
    final ArrayList<Setting> settingsObjects =
      new ArrayList<>(SettingType.values().length);
    // Only display AlarmInfo if the user is editing an actual alarm (as
    // opposed to the default application settings).
    if (alarmId != AlarmSettings.DEFAULT_SETTINGS_ID) {
      // The alarm time.
      settingsObjects.add(new Setting() {
        @Override
        public String name() { return getString(R.string.time); }
        @Override
        public String value() { return info.getTime().localizedString(getApplicationContext()); }
        @Override
        public SettingType type() { return SettingType.TIME; }
      });
      // A human-readable label for the alarm.
      settingsObjects.add(new Setting() {
        @Override
        public String name() { return getString(R.string.label); }
        @Override
        public String value() { return info.getName().equals("") ?
            getString(R.string.none) : info.getName(); }
        @Override
        public SettingType type() { return SettingType.NAME; }
      });
      // Days of the week this alarm should repeat.
      settingsObjects.add(new Setting() {
        @Override
        public String name() { return getString(R.string.repeat); }
        @Override
        public String value() { return info.getTime().getDaysOfWeek().toString(getApplicationContext()); }
        @Override
        public SettingType type() { return SettingType.DAYS_OF_WEEK; }
      });
    }
    // The notification tone used for this alarm.
    settingsObjects.add(new Setting() {
      @Override
      public String name() { return getString(R.string.tone); }
      @Override
      public String value() {
        String value = settings.getToneName();
        if (AppSettings.isDebugMode(getApplicationContext())) {
          value += " " + settings.getTone().toString();
        }
        return value;
      }
      @Override
      public SettingType type() { return SettingType.TONE; }
    });
    // The snooze duration for this alarm.
    settingsObjects.add(new Setting() {
      @Override
      public String name() { return getString(R.string.snooze_minutes); }
      @Override
      public String value() { return "" + settings.getSnoozeMinutes(); }
      @Override
      public SettingType type() { return SettingType.SNOOZE; }
    });
    // The vibrator setting for this alarm.
    settingsObjects.add(new Setting() {
      @Override
      public String name() { return getString(R.string.vibrate); }
      @Override
      public String value() { return settings.getVibrate() ?
          getString(R.string.enabled) : getString(R.string.disabled); }
      @Override
      public SettingType type() { return SettingType.VIBRATE; }
    });
    // How the volume should be controlled while this alarm is triggering.
    settingsObjects.add(new Setting() {
      @Override
      public String name() { return getString(R.string.alarm_fade); }
      @Override
      public String value() { return getString(R.string.fade_description,
          settings.getVolumeStartPercent(), settings.getVolumeEndPercent(),
          settings.getVolumeChangeTimeSec()); }
      @Override
      public SettingType type() { return SettingType.VOLUME_FADE; }
    });

    final ListView settingsList = (ListView) findViewById(R.id.settings_list);
    settingsAdapter = new SettingsAdapter(getApplicationContext(),
            settingsObjects);
    settingsList.setAdapter(settingsAdapter);
    settingsList.setOnItemClickListener(new SettingsListClickListener());
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (alarmId == AlarmSettings.DEFAULT_SETTINGS_ID) {
            return super.onCreateOptionsMenu(menu);
        } else {
            MenuInflater inflater = getMenuInflater();

            inflater.inflate(R.menu.alarm_settings_menu, menu);

            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_alarm:
                showDialogFragment(DELETE_CONFIRM);
                return true;
            case android.R.id.home:
                saveAlarmSettings();

                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        saveAlarmSettings();
    }

    @Override
  protected void onResume() {
    super.onResume();
    service.bind();

      TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().
              findFragmentByTag("TimePickerDialog");

      if (tpd != null) {
          picker = tpd;

          tpd.setOnTimeSetListener(this);

          tpd.setOnTimeChangedListener(this);
      }
  }

  @Override
  protected void onPause() {
    super.onPause();
    service.unbind();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    db.closeConnections();

      if (progressDialog != null) {
          progressDialog.dismiss();
      }

      progressDialog = null;

      picker = null;

      settingsAdapter = null;
  }

    @Override
    public void onRequestPermissionsResult(int requestCode,
            @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == READ_EXTERNAL_STORAGE_PERMISSION_REQUEST) {
            if (permissions.length == 1 &&
                    permissions[0].equals(
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showProgressDialog();

                showDialogFragment(TONE_PICKER);
            } else {
                showDialogFragment(PERMISSION_NOT_GRANTED);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(SETTINGS_VIBRATE_KEY, settings.getVibrate());

        outState.putInt(SETTINGS_SNOOZE_KEY, settings.getSnoozeMinutes());

        if (originalInfo != null && info != null) {
            final AlarmTime infoTime = info.getTime();

            outState.putInt(SETTINGS_TIME_HOUR_OF_DAY_KEY,
                    infoTime.calendar().get(Calendar.HOUR_OF_DAY));

            outState.putInt(SETTINGS_TIME_MINUTE_KEY,
                    infoTime.calendar().get(Calendar.MINUTE));

            outState.putInt(SETTINGS_TIME_SECOND_KEY,
                    infoTime.calendar().get(Calendar.SECOND));

            outState.putString(SETTINGS_NAME_KEY, info.getName());

            outState.putBooleanArray(SETTINGS_DAYS_OF_WEEK_KEY,
                    info.getTime().getDaysOfWeek().bitmask());
        }

        outState.putParcelable(SETTINGS_TONE_URI_KEY, settings.getTone());

        outState.putString(SETTINGS_TONE_NAME_KEY, settings.getToneName());

        outState.putInt(SETTINGS_VOLUME_START_PERCENT_KEY,
                settings.getVolumeStartPercent());

        outState.putInt(SETTINGS_VOLUME_END_PERCENT_KEY,
                settings.getVolumeEndPercent());

        outState.putInt(SETTINGS_VOLUME_CHANGE_TIME_SEC_KEY,
                settings.getVolumeChangeTimeSec());
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        final AlarmTime time = info.getTime();

        info.setTime(new AlarmTime(hourOfDay, minute, second, time.getDaysOfWeek()));

        settingsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTimeChanged(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        final AlarmTime infoTime = info.getTime();

        final AlarmTime time = new AlarmTime(hourOfDay, minute, second,
                infoTime.getDaysOfWeek());

        picker.setTitle(time.timeUntilString(this));
    }

    private void saveAlarmSettings() {
        // Write AlarmInfo if it changed.
        if (originalInfo != null && !originalInfo.equals(info)) {
            db.writeAlarmInfo(alarmId, info);

            // Explicitly enable the alarm if the user changed the time.
            // This will reschedule the alarm if it was already enabled.
            // It's also probably the right thing to do if the alarm wasn't
            // enabled.
            if (!originalInfo.getTime().equals(info.getTime())) {
                service.scheduleAlarm(alarmId);
            } else if (originalInfo.enabled()
                    && !originalInfo.getName().equals(info.getName())) {
                service.scheduleAlarm(alarmId);
            }
        }

        // Write AlarmSettings if they have changed.
        if (!originalSettings.equals(settings)) {
            db.writeAlarmSettings(alarmId, settings);
        }
    }

    public static void _requestReadExternalStoragePermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityCompat.requestPermissions(activity,
                    new String[] {
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    }, READ_EXTERNAL_STORAGE_PERMISSION_REQUEST);
        }
    }

    public void requestReadExternalStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            showDialogFragment(EXPLAIN_READ_EXTERNAL_STORAGE);
        } else {
            _requestReadExternalStoragePermission(this);
        }
    }

  /**
   * This is a helper class for mapping SettingType to action.  Each Setting
   * in the list view returns a unique SettingType.  Trigger a dialog
   * based off of that SettingType.
   */
  private final class SettingsListClickListener implements OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      final SettingsAdapter adapter = (SettingsAdapter) parent.getAdapter();
      SettingType type = adapter.getItem(position).type();
      switch (type) {
        case TIME:
            final AlarmTime time = info.getTime();

            Calendar c = time.calendar();

            picker = TimePickerDialog.newInstance(
                    ActivityAlarmSettings.this,
                    ActivityAlarmSettings.this,
                    c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    DateFormat.is24HourFormat(ActivityAlarmSettings.this)
            );

            if (AppSettings.isThemeDark(ActivityAlarmSettings.this)) {
                picker.setThemeDark(true);
            }

            picker.setAccentColor(AppSettings.getTimePickerColor(
                    ActivityAlarmSettings.this));

            picker.vibrate(true);

            if (AppSettings.isDebugMode(ActivityAlarmSettings.this)) {
                picker.enableSeconds(true);
            } else {
                picker.enableSeconds(false);
            }

            picker.setTitle(time.timeUntilString(ActivityAlarmSettings.this));

            picker.show(getFragmentManager(), "TimePickerDialog");
          break;
        case NAME:
          showDialogFragment(NAME_PICKER);
          break;

        case DAYS_OF_WEEK:
          showDialogFragment(DOW_PICKER);
          break;

        case TONE:
            if (ContextCompat.checkSelfPermission(ActivityAlarmSettings.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                showProgressDialog();

                showDialogFragment(TONE_PICKER);
            } else {
                requestReadExternalStoragePermission();
            }
          break;

        case SNOOZE:
          showDialogFragment(SNOOZE_PICKER);
          break;

        case VOLUME_FADE:
          showDialogFragment(VOLUME_FADE_PICKER);
          break;
      }
    }
  }

    private void showProgressDialog() {
        progressDialog = ProgressDialog.show(ActivityAlarmSettings.this,
                getString(R.string.loading),
                getString(R.string.please_wait), true, true);
    }

  /**
   * A helper interface to encapsulate the data displayed in the list view of
   * this activity.  Consists of a setting name, a setting value, and a type.
   * The type is used to trigger the appropriate action from the onClick
   * handler.
   */
  private abstract class Setting {
    public abstract String name();
    public abstract String value();
    public abstract SettingType type();
  }

    /**
     * This adapter populates the settings_items view with the data encapsulated
     * in the individual Setting objects.
     */
    private final class SettingsAdapter extends ArrayAdapter<Setting> {

        List<Setting> settingsObjects;

        public SettingsAdapter(Context context, List<Setting> settingsObjects) {
            super(context, 0, settingsObjects);

            this.settingsObjects = settingsObjects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;

            LayoutInflater inflater = getLayoutInflater();

            if (settingsObjects.get(position).name().
                    equalsIgnoreCase(getString(R.string.vibrate))) {
                convertView = inflater.inflate(R.layout.vibrate_settings_item, parent,
                        false);
            } else {
                convertView = inflater.inflate(R.layout.settings_item, parent,
                        false);
            }

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);

			holder.populateFrom(settingsObjects.get(position));

			return(convertView);
        }

    }

	private class ViewHolder {

        private View row;

		ViewHolder(View row) {
            this.row = row;
		}

		void populateFrom(Setting setting) {
            ((TextView) row.findViewById(R.id.setting_name)).
                    setText(setting.name());

            if (setting.name().equalsIgnoreCase(getString(R.string.vibrate))) {
                SwitchCompat vibrateSwitch = (SwitchCompat) row.findViewById(
                        R.id.setting_vibrate_sc);

                if (settings.getVibrate()) {
                    vibrateSwitch.setChecked(true);
                } else {
                    vibrateSwitch.setChecked(false);
                }

                vibrateSwitch.setOnCheckedChangeListener(
                        new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            settings.setVibrate(true);
                        } else {
                            settings.setVibrate(false);
                        }
                    }
                });
            } else {
                ((TextView) row.findViewById(R.id.setting_value)).
                        setText(setting.value());
            }
		}

	}

    private void showDialogFragment(int id) {
        DialogFragment dialog = new ActivityDialogFragment().newInstance(
                id);
        dialog.show(getFragmentManager(), "ActivityDialogFragment");
    }

  public static class ActivityDialogFragment extends DialogFragment {

    public ActivityDialogFragment newInstance(int id) {
      ActivityDialogFragment fragment = new ActivityDialogFragment();
      Bundle args = new Bundle();
      args.putInt("id", id);
      fragment.setArguments(args);
      return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
      switch (getArguments().getInt("id")) {
          case NAME_PICKER:
              final View nameView = View.inflate(getActivity(),
                      R.layout.name_settings_dialog, null);
              final TextView label = (TextView) nameView.findViewById(R.id.name_label);
              label.setText(info.getName());
              final AlertDialog.Builder nameBuilder = new AlertDialog.Builder(getActivity());
              nameBuilder.setTitle(R.string.alarm_label);
              nameBuilder.setView(nameView);
              nameBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      info.setName(label.getEditableText().toString());
                      settingsAdapter.notifyDataSetChanged();
                      dismiss();
                  }
              });
              nameBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dismiss();
                  }
              });
              return nameBuilder.create();

          case DOW_PICKER:
              final AlertDialog.Builder dowBuilder = new AlertDialog.Builder(getActivity());
              dowBuilder.setTitle(R.string.scheduled_days);
              dowBuilder.setMultiChoiceItems(
                      info.getTime().getDaysOfWeek().names(getActivity()),
                      info.getTime().getDaysOfWeek().bitmask(),
                      new OnMultiChoiceClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                              if (isChecked) {
                                  info.getTime().getDaysOfWeek().addDay(Week.Day.values()[which]);
                              } else {
                                  info.getTime().getDaysOfWeek().removeDay(Week.Day.values()[which]);
                              }
                              settingsAdapter.notifyDataSetChanged();
                          }
                      });
              dowBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dismiss();
                  }
              });
              return dowBuilder.create();

          case TONE_PICKER:
              MediaPickerDialog mediaPicker = new MediaPickerDialog(getActivity());
              mediaPicker.setOnShowListener(new DialogInterface.OnShowListener() {
                  @Override
                  public void onShow(DialogInterface dialog) {
                      if (progressDialog != null) {
                          progressDialog.dismiss();

                          progressDialog = null;
                      }
                  }
              });
              mediaPicker.setPickListener(new MediaPickerDialog.OnMediaPickListener() {
                  @Override
                  public void onMediaPick(String name, Uri media) {
                      if (name.length() == 0) {
                          name = getString(R.string.unknown_name);
                      }
                      settings.setTone(media, name);
                      settingsAdapter.notifyDataSetChanged();
                  }
              });
              return mediaPicker;

          case SNOOZE_PICKER:
              // This currently imposes snooze times between 1 and 60 minutes,
              // which isn't really necessary, but I think the picker is easier
              // to use than a free-text field that you have to type numbers into.
              final CharSequence[] items = new CharSequence[60];
              // Note the array index is one-off from the value (the value of 1 is
              // at index 0).
              for (int i = 1; i <= 60; ++i) {
                  items[i-1] = Integer.toString(i);
              }
              final AlertDialog.Builder snoozeBuilder = new AlertDialog.Builder(getActivity());
              snoozeBuilder.setTitle(R.string.snooze_minutes);
              snoozeBuilder.setSingleChoiceItems(items, settings.getSnoozeMinutes() - 1,
                      new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int item) {
                              settings.setSnoozeMinutes(item + 1);
                              settingsAdapter.notifyDataSetChanged();
                              dismiss();
                          }
                      });
              return snoozeBuilder.create();

          case VOLUME_FADE_PICKER:
              final View fadeView = View.inflate(getActivity(), R.layout.fade_settings_dialog, null);

              final SeekBar seekBar = (SeekBar) fadeView.findViewById(R.id.volume_start_sb);

              seekBar.setMax(100);

              seekBar.setProgress(settings.getVolumeStartPercent());

              final TextView textView = (TextView) fadeView.findViewById(
                      R.id.volume_start_tv);

              textView.setText(getString(R.string.volume_start_label,
                      settings.getVolumeStartPercent()));

              seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                  @Override
                  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                      textView.setText(getString(R.string.volume_start_label,
                              progress));
                  }

                  @Override
                  public void onStartTrackingTouch(SeekBar seekBar) {

                  }

                  @Override
                  public void onStopTrackingTouch(SeekBar seekBar) {

                  }
              });

              final SeekBar endSeekBar = (SeekBar) fadeView.findViewById(R.id.volume_end_sb);

              endSeekBar.setMax(100);

              endSeekBar.setProgress(settings.getVolumeEndPercent());

              final TextView endTextView = (TextView) fadeView.findViewById(
                      R.id.volume_end_tv);

              endTextView.setText(getString(R.string.volume_end_label,
                      settings.getVolumeEndPercent()));

              endSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                  @Override
                  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                      endTextView.setText(getString(R.string.volume_end_label,
                              progress));
                  }

                  @Override
                  public void onStartTrackingTouch(SeekBar seekBar) {

                  }

                  @Override
                  public void onStopTrackingTouch(SeekBar seekBar) {

                  }
              });

              final SeekBar durationSeekBar = (SeekBar) fadeView.findViewById(
                      R.id.volume_duration_sb);

              durationSeekBar.setMax(300);

              durationSeekBar.setProgress(settings.getVolumeChangeTimeSec());

              final TextView durationTextView = (TextView) fadeView.findViewById(
                      R.id.volume_duration_tv);

              durationTextView.setText(getString(R.string.volume_duration_label,
                              settings.getVolumeChangeTimeSec()));

              durationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                  @Override
                  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                      durationTextView.setText(getString(R.string.volume_duration_label,
                                      progress));
                  }

                  @Override
                  public void onStartTrackingTouch(SeekBar seekBar) {

                  }

                  @Override
                  public void onStopTrackingTouch(SeekBar seekBar) {

                  }
              });

              final AlertDialog.Builder fadeBuilder = new AlertDialog.Builder(getActivity());
              fadeBuilder.setTitle(R.string.alarm_fade);
              fadeBuilder.setView(fadeView);
              fadeBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      settings.setVolumeStartPercent(seekBar.getProgress());
                      settings.setVolumeEndPercent(endSeekBar.getProgress());
                      settings.setVolumeChangeTimeSec(durationSeekBar.getProgress());

                      settingsAdapter.notifyDataSetChanged();

                      dismiss();
                  }
              });
              fadeBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dismiss();
                  }
              });
              return fadeBuilder.create();

          case DELETE_CONFIRM:
              final AlertDialog.Builder deleteConfirmBuilder = new AlertDialog.Builder(getActivity());
              deleteConfirmBuilder.setTitle(R.string.delete);
              deleteConfirmBuilder.setMessage(R.string.confirm_delete);
              deleteConfirmBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      service.deleteAlarm(alarmId);
                      dismiss();
                      getActivity().finish();
                  }
              });
              deleteConfirmBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dismiss();
                  }
              });
              return deleteConfirmBuilder.create();
        case EXPLAIN_READ_EXTERNAL_STORAGE:
            final AlertDialog.Builder builder = new AlertDialog.Builder(
                    getActivity());

            builder.setTitle(R.string.read_external_storage_title);

            builder.setMessage(R.string.read_external_storage_message);

            builder.setPositiveButton(R.string.grant,
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();

                    _requestReadExternalStoragePermission(getActivity());
                }
            });

            builder.setNegativeButton(R.string.cancel,
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                }
            });

            return builder.create();
        case PERMISSION_NOT_GRANTED:
            final AlertDialog.Builder permissionBuilder = new AlertDialog.Builder(
                    getActivity());

            permissionBuilder.setTitle(R.string.permission_not_granted_title);

            permissionBuilder.setMessage(R.string.permission_not_granted);

            permissionBuilder.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dismiss();
                        }
                    });

            return permissionBuilder.create();
        default:
          return super.onCreateDialog(savedInstanceState);
      }
    }

  }
}
