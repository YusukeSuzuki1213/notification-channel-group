package com.example.notificationchannelexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.notificationchannelexample.databinding.FragmentNotificationBindingImpl
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

            }

            notification2.setOnClickListener {

            }

            notification3.setOnClickListener {

            }
        }
    }

    data class Args(
        val hoge: String
    ) : Serializable
}
