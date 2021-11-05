package com.najed.notificationapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService


class Notifications(private val callerContext: Context) {

    fun createNotification(message: String) {
        val channelId = "najed.notificationapp"
        val description = "Notification App Example"
        val notificationManager: NotificationManager =
            getSystemService(callerContext, NotificationManager::class.java) as NotificationManager
        var builder: Notification.Builder
        builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
            Notification.Builder(callerContext, channelId)
        } else {
            Notification.Builder(callerContext)
        }
        builder.setContentTitle("My Notification")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText(message)
        notificationManager.notify(0, builder.build())
    }
}