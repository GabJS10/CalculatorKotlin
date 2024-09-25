package com.example.calculadora.modelo

import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder


class ModelMain {

    private val operators = listOf('+', '-', '*', '/', '(' , ')', '.')

    private val WITH_LIBRARIES = false
    fun addToViewOperations(oldValue:String,valueToAdd:String):String{
        var newV = valueToAdd
        var old = oldValue


        if(old.last() in operators && newV.last() in operators){
            newV = ""
        }

        if(old == "0"){
            old = ""
        }


        return  old+newV



    }

    fun deleteLast(oldValue:String):String{

        if (oldValue == "0"){
            return oldValue
        }

        val newValue = oldValue.dropLast(1)
        return newValue

    }

    fun result(value:String):String {

        val result = if (WITH_LIBRARIES) evaluateWithLibraries(value) else evaluate(value)

        return result


    }


    private fun evaluate(value: String): String {
        var result = 0.0
        var operator = '+'
        var currentNumber = StringBuilder()


        try {
            value.forEach { valor ->
                if (valor in operators) {

                    if (currentNumber.isNotEmpty()) {
                        result = when (operator) {
                            '+' -> sum(result, currentNumber.toString().toDouble())
                            '-' -> subs(result, currentNumber.toString().toDouble())
                            '*' -> mult(result, currentNumber.toString().toDouble())
                            '/' -> div(result, currentNumber.toString().toDouble())
                            else -> result
                        }
                        currentNumber.clear()
                    }
                    operator = valor
                } else {

                    currentNumber.append(valor)
                }
            }


            if (currentNumber.isNotEmpty()) {
                result = when (operator) {
                    '+' -> sum(result, currentNumber.toString().toDouble())
                    '-' -> subs(result, currentNumber.toString().toDouble())
                    '*' -> mult(result, currentNumber.toString().toDouble())
                    '/' -> div(result, currentNumber.toString().toDouble())
                    else -> result
                }
            }
        } catch (e: Exception) {
            Log.d("error","error")
            return "Error"
        }
        Log.d("resultado",result.toString())

        return if (result == result.toLong().toDouble()) result.toLong().toString() else result.toString()
    }

    private fun sum(num1:Double,num2:Double):Double{
        return num1 + num2
    }

    private fun div(num1:Double,num2:Double):Double{
        return num1 / num2
    }

    private fun subs(num1:Double,num2:Double):Double{
        return num1 - num2
    }

    private fun mult(num1:Double,num2:Double):Double{
        return num1 * num2
    }


    private  fun evaluateWithLibraries(value: String): String {
        try {
            val expression = ExpressionBuilder(value).build()
            val result = expression.evaluate()
            return if( result == result.toLong().toDouble()) result.toLong().toString() else result.toString()

        }catch (e:Exception){
            Log.d("Exception","message : " + e.message)
            return "error"
        }

    }

}