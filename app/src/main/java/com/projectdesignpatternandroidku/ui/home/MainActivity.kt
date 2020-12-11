package com.projectdesignpatternandroidku.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.projectdesignpatternandroidku.R
import com.projectdesignpatternandroidku.databinding.ActivityMainBinding
import com.projectdesignpatternandroidku.ui.auth.AuthActivity
import com.projectdesignpatternandroidku.ui.auth.ProjectDesignPatternAndroidKuAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogOut.setOnClickListener {
            ProjectDesignPatternAndroidKuAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}