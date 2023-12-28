package com.example.basiccompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    var counterFlow = flow<Int> {
        val initialValue = 20
        var counterFlow = initialValue
        emit(counterFlow)

        while(true) {
            emit(counterFlow--)
            delay(1000)
        }
    }
}