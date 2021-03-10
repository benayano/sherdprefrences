package com.example.sherdprefrences.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.preference.PreferenceManager
import com.example.sherdprefrences.R
import com.example.sherdprefrences.model.OnBoardingRepository
import com.example.sherdprefrences.viewModel.MainViewModel
import com.example.sherdprefrences.viewModel.OnBoardingRepositoryFactory

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> { OnBoardingRepositoryFactory(
            OnBoardingRepository((PreferenceManager.getDefaultSharedPreferences(this)))
    )}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.bindIsVisitedOnBoarding().observe(this){
            if (!it){
                val onBoardingActivity = Intent (this, OnBordingActivity::class.java)
                startActivity(onBoardingActivity)
            }
        }
        viewModel.onMainLunched()
    }
}