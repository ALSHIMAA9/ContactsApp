package com.example.contactsapp.ui.screens.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ActivityMainBinding
import com.example.contactsapp.ui.screens.fragment.splashfragment.SplashFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.contanerfragment, SplashFragment())
            .addToBackStack(null).commit()

    }
}