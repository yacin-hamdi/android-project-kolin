package ym.tutorials.calculator.presentation

sealed class CalculatorOperation(val op: String){
    object Add: CalculatorOperation("+")
    object Sub: CalculatorOperation("-")
    object mul: CalculatorOperation("x")
    object Div: CalculatorOperation("/")
}