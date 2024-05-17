package eu.tutorials.counterviewmodel



data class CounterModel(var counter:Int)

class CounterRepository(){
    private val _counter = CounterModel(0)
    fun getCount() = _counter

    fun increment(){
        getCount().counter++
    }

    fun decrement(){
        getCount().counter--
    }
}







































//data class CounterModel(var count: Int)
//
//class CounterRepository{
//    private var _counter = CounterModel(0)
//
//    fun getCounter() = _counter
//
//    fun incrementCounter(){
//        _counter.count++
//    }
//
//    fun decrementCounter(){
//        _counter.count--
//    }
//}