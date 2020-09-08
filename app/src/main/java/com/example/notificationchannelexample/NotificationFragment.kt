package com.example.notificationchannelexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.notificationchannelexample.databinding.FragmentNotificationBindingImpl
import com.example.notificationchannelexample.model.PushMessageItem
import kotlinx.android.synthetic.main.fragment_notification.*
import java.io.Serializable

class NotificationFragment : Fragment() {

    companion object {

        private const val BUNDLE_KEY_ARGS = "notification_fragment"

        @JvmStatic
        fun createInstance(args: Args): NotificationFragment =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(BUNDLE_KEY_ARGS, args)
                }
            }
    }

    private lateinit var binding: FragmentNotificationBindingImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            notification1.setOnClickListener {
                NotificationUtil.localPush(
                    requireContext(),
                    PushMessageItem("notification_channel_1", "テスト通知", "チャンネル1"
                    )
                )
            }

            notification2.setOnClickListener {
                NotificationUtil.localPush(
                    requireContext(),
                    PushMessageItem("notification_channel_2", "テスト通知", "チャンネル2"
                    )
                )
            }

            notification3.setOnClickListener {
                NotificationUtil.localPush(
                    requireContext(),
                    PushMessageItem("notification_channel_3", "テスト通知", "チャンネル3"
                    )
                )
            }
        }
    }

    data class Args(
        val hoge: String
    ) : Serializable
}
