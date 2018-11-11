package com.dreamwalkers.elab_yang.mmk.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dreamwalkers.elab_yang.mmk.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        db_management_button.setOnClickListener {

        }
    }
}
