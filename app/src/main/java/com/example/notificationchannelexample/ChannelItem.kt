package com.example.notificationchannelexample

enum class ChannelItem(val channelId: String) {
    CHANNEL_1("notification_channel_1"),
    CHANNEL_2("notification_channel_2"),
    CHANNEL_3("notification_channel_3");

    fun getTextStringRes(): Int {
        return when(this) {
            CHANNEL_1 -> R.string.channel_name_notification_1
            CHANNEL_2 -> R.string.channel_name_notification_2
            CHANNEL_3 -> R.string.channel_name_notification_3
        }
    }
}
