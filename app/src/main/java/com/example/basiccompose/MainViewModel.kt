package com.example.basiccompose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
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
        counterFlow.onEach {time ->
            println("The current time is $time")
        }.launchIn(viewModelScope)

        viewModelScope.launch {
            counterFlow.filter {time ->
                time % 2 == 0
            }
                .map { time->
                    time * time
                }
                .onEach {time ->
                    println("The current time is ${time * time}")
                }
                .collect{time ->
                println("The current time is $time")
            }
        }
    }
}