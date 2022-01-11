package com.example.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //we do not want any component to manipulate our LiveData
    private val factsLiveDataObject = MutableLiveData<String>("This is a fact")

    //this Non_mutable Live data will be visible to all
    val factsLiveData : LiveData<String>
    get()=factsLiveDataObject

    fun updateLiveData(str : String){
        factsLiveDataObject.value=str.toString()
    }
}