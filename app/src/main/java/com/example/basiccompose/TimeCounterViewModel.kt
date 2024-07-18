package com.example.basiccompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var counterFlow = flow<Int> {
        val initialValue = 20
        var counterFlow = initialValue
        emit(counterFlow)

        while(counterFlow > 10) {

            emit(counterFlow--)
            delay(1000)
          //  Log.d("CounterFlow", counterFlow.toString())
        }
    }



    init {
        collectFlow()
    }

    private fun collectFlow() {

        viewModelScope.launch {
            val count = counterFlow.fold(100) { acc, value ->
                acc + value
            }
            println("count : $count")
        }
    }
}