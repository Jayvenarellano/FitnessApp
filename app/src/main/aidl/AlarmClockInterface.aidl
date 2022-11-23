// AlarmClockInterface.aidl
package com.example.villanueva.alarm;

import com.example.villanueva.alarm.AlarmTime;

interface AlarmClockInterface {
 void createAlarm(in AlarmTime time);
  long resurrectAlarm(in AlarmTime time, in String alarmName, boolean enabled);
  void deleteAlarm(long alarmId);
  void deleteAllAlarms();
  void scheduleAlarm(long alarmId);
  void unscheduleAlarm(long alarmId);
  void acknowledgeAlarm(long alarmId);
  void snoozeAlarm(long alarmId);
  void snoozeAlarmFor(long alarmId, int minutes);
  AlarmTime pendingAlarm(long alarmId);
  AlarmTime[] pendingAlarmTimes();
   }
