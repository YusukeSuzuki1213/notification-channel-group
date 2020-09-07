package com.example.notificationchannelexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationManagerCompat

class NotificationUtil {
    companion object {
        fun createChannel(context: Context) {
            val manager = NotificationManagerCompat.from(context)
            manager.createNotificationChannels(
                ChannelItem.values().map {
                    NotificationChannel(
                        it.channelId,
                        context.getString(it.getTextStringRes()),
                        NotificationManager.IMPORTANCE_HIGH
                    )
                }
            )
        }

        fun localPush(context: Context, item: PushMessageItem) {

        }
    }
}
