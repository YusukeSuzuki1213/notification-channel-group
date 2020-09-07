package com.example.notificationchannelexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    data class Args(
        val hoge: String
    ) : Serializable
}
