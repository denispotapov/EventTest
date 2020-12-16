package com.example.eventtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventViewModel : ViewModel() {

    private val _showToast = MutableLiveData<Event<Boolean>>()

    val showToast: LiveData<Event<Boolean>> = _showToast

    fun onButtonClick() {
        _showToast.value = Event(true)
    }
}