package com.example.calculadora.modelo

import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder

class ModelMain {

    private val operators = listOf('+', '-', '*', '/', '(' , ')', '.')


    fun addToViewOperations(oldValue:String,valueToAdd:String):String{
        var newV = valueToAdd
        var old = oldValue

        if(old.last() in operators && newV.last() in operators){
            newV = ""
        }


        if (old == "0") {
            old = ""
        }


        return old+newV

    }

    fun deleteLast(oldValue:String):String{

        if (oldValue == "0"){
            return oldValue
        }

        val newValue = oldValue.dropLast(1)
        return newValue

    }

    fun result(value:String):String{
        try {
            val expression = ExpressionBuilder(value).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if(result == longResult.toDouble()){
                return longResult.toString()
            }else{
                return result.toString()
            }
        }catch (e:Exception){
            Log.d("Exception","message : " + e.message)
            return "error"
        }

    }


}