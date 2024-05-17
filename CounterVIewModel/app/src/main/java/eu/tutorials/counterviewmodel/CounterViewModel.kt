package eu.tutorials.counterviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CounterViewModel: ViewModel(){
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCount().counter)
    val count: MutableState<Int> = _count

    fun increment(){
        _repository.increment()
        _count.value = _repository.getCount().counter
    }

    fun decrement(){
        _repository.decrement()
        _count.value = _repository.getCount().counter
    }
}







































//class CounterViewModel(): ViewModel(){
//    private val _repository: CounterRepository = CounterRepository()
//    private val _count = mutableIntStateOf(_repository.getCounter().count)
//    val count:MutableState<Int> = _count
//
//    fun increment(){
//        _repository.incrementCounter()
//        _count.intValue = _repository.getCounter().count
//    }
//    fun decrement(){
//        _repository.decrementCounter()
//        _count.intValue = _repository.getCounter().count
//    }
//}