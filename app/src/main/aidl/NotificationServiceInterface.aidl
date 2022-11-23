
package com.example.villanueva.alarm;

interface NotificationServiceInterface {
    long currentAlarmId();
     int firingAlarmCount();
     float volume();
     void acknowledgeCurrentNotification(int snoozeMinutes);
}
