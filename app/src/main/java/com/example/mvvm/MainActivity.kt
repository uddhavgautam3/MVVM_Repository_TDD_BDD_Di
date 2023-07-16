package com.example.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.ui.main.UserFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserFragment.newInstance())
                .commitNow()
        }
    }
}