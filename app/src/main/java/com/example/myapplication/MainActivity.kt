package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.core.graphics.drawable.DrawableCompat

class MainActivity : AppCompatActivity() {

    lateinit var textIP: TextView
    lateinit var relativeMain: RelativeLayout
    lateinit var switchTheme: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textIP = findViewById(R.id.text_ip)
        relativeMain = findViewById(R.id.relative_main)
        switchTheme = findViewById(R.id.customSwitch)

        var drawable: Drawable = relativeMain.background
        drawable = DrawableCompat.wrap(drawable)

        val lightModeSettings = getSharedPreferences("LightModePreference", MODE_PRIVATE)
        val prefEditor = lightModeSettings.edit()

        if (lightModeSettings.getBoolean("night", true)) {
            switchTheme.isChecked = true
            drawable.setTint(Color.BLACK)
            textIP.setTextColor(Color.WHITE)
            relativeMain.background = drawable
        } else {
            switchTheme.isChecked = false
            drawable.setTint(Color.WHITE)
            textIP.setTextColor(Color.BLACK)
            relativeMain.background = drawable
        }

        textIP.text = Utils.getIPAddress(true)
        switchTheme.setOnCheckedChangeListener { buttonView, isChecked ->
            if (switchTheme.isChecked) {
                drawable.setTint(Color.BLACK)
                textIP.setTextColor(Color.WHITE)
                relativeMain.background = drawable
                prefEditor.putBoolean("night", true)
                prefEditor.apply()
            } else {
                drawable.setTint(Color.WHITE)
                textIP.setTextColor(Color.BLACK)
                relativeMain.background = drawable
                prefEditor.putBoolean("night", false)
                prefEditor.apply()
            }
        }
    }
}