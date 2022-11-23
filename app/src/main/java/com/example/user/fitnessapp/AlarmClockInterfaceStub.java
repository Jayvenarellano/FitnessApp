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

import android.content.Context;
import android.os.RemoteException;
import android.widget.Toast;

public final class AlarmClockInterfaceStub extends AlarmClockInterface.Stub {
  private Context context;
  private AlarmClockService service;

  AlarmClockInterfaceStub(Context context, AlarmClockService service) {
    this.context = context;
    this.service = service;
  }

  @Override
  public AlarmTime pendingAlarm(long alarmId) throws RemoteException {
    return service.pendingAlarm(alarmId);
  }

  @Override
  public AlarmTime[] pendingAlarmTimes() throws RemoteException {
    return service.pendingAlarmTimes();
  }

  @Override
  public long resurrectAlarm(AlarmTime time, String alarmName, boolean enabled)
      throws RemoteException {
    return service.resurrectAlarm(time, alarmName, enabled);
  }

  @Override
  public void createAlarm(AlarmTime time) throws RemoteException {
    service.createAlarm(time);
  }

  @Override
  public void deleteAlarm(long alarmId) throws RemoteException {

    service.deleteAlarm(alarmId);
  }

  @Override
  public void deleteAllAlarms() throws RemoteException {

    service.deleteAllAlarms();
  }

  @Override
  public void scheduleAlarm(long alarmId) throws RemoteException {
    service.scheduleAlarm(alarmId);
  }

  @Override
  public void unscheduleAlarm(long alarmId) {

    service.dismissAlarm(alarmId);
  }

  public void acknowledgeAlarm(long alarmId) {

    service.acknowledgeAlarm(alarmId);
  }

  @Override
  public void snoozeAlarm(long alarmId) throws RemoteException {

    service.snoozeAlarm(alarmId);
  }

  @Override
  public void snoozeAlarmFor(long alarmId, int minutes) throws RemoteException {

    service.snoozeAlarmFor(alarmId, minutes);
  }

  private void debugToast(String message) {
    if (AppSettings.isDebugMode(context)) {
    }
  }
}
