package com.example.notificationchannelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NotificationUtil.createChannel(applicationContext)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                NotificationFragment.createInstance(
                    NotificationFragment.Args(
                        hoge = "hoge"
                    )
                )
            )
            .addToBackStack(null)
            .commit()
    }
}
