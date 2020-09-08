package com.example.notificationchannelexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationchannelexample.model.PushMessageItem

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

            val channelItem = ChannelItem.value(item.channelId) ?: return

            val builderChild = NotificationCompat.Builder(context, item.channelId)
                .setContentTitle(item.title)
                .setContentText(item.body)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroup(item.channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)

            val builderParent = NotificationCompat.Builder(context, item.channelId)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroup(item.channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .setSummaryText(
                            context.getString(channelItem.getTextStringRes())
                        ))
                .setGroupSummary(true)
                .setAutoCancel(true)

            NotificationManagerCompat.from(context).run {
                notify(System.currentTimeMillis().toInt(), builderChild.build())
                notify(channelItem.ordinal, builderParent.build())
            }
        }
    }
}
