package com.example.sherdprefrences.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sherdprefrences.model.OnBoardingRepository

class MainViewModel(private val repository: OnBoardingRepository):ViewModel() {

    private val isVisitedOnBoardingObserver = MutableLiveData<Boolean>()
    fun bindIsVisitedOnBoarding():LiveData<Boolean> = isVisitedOnBoardingObserver

    fun onMainLunched(){
        isVisitedOnBoardingObserver.postValue(repository.isOnBoardingVisited())
    }

    fun onAppIsAold(){
        repository.saveOnBoardingVisited(isVisited = true)
    }

}