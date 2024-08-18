package ym.tutorials.calculator.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var number1 by mutableStateOf("")



    var opState by mutableStateOf("+")
        private set

    var number2 by mutableStateOf("")
        private set


    var resultState by mutableStateOf(0f)
        private set

    var secondState by mutableStateOf(false)
        private set

    fun onEvent(event: String){

        if(event.isDigitsOnly()){
            if(!secondState)
                number1 += event
            else
                number2 += event
        }else if(event == "."){
            if(!secondState){
                if(!number1.contains('.'))
                    number1 += event
            }else{
                if(!number2.contains('.'))
                    number2 += event
            }
        } else if(event == "="){
            if(number1.isNotBlank() && number2.isNotBlank()){
                if(opState == "+")
                    resultState = number1.toFloat() + number2.toFloat()
                else if(opState == "-")
                    resultState = number1.toFloat() - number2.toFloat()
                else if(opState == "x")
                    resultState = number1.toFloat() * number2.toFloat()
                else if(opState == "/")
                    resultState = number1.toFloat() / number2.toFloat()

                secondState = false
                number1 = ""
                number2 = ""
            }
        }else{
            if(number1.isNotBlank()){
                opState = event
                secondState = true
            }

        }
//        when(event){
//
//            event.isDigitsOnly().toString() -> {
//
//            }
//            "+" -> {
//                if(numState1.isDigitsOnly())
//                    opState = event
//            }
//            "-" -> {
//                if(numState1.isDigitsOnly())
//                    opState = event
//            }
//
//            "/"-> {
//
//            }
//            "x" -> {
//
//            }
//
//            "="-> {
//
//            }
//            else -> {
//                if(!chooseState)
//                    numState1 += event
//                else
//                    numState2 += event
//            }
//        }
    }
}