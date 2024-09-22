package com.example.calculadora.presentador

import com.example.calculadora.view.MainActivity

interface PresentadorInterface {

    fun operationsButtonsAction(btnPressed: String, viewText:String)
    fun resultButtonAction(value:String)
    fun clearButtonAction()
    fun deleteButtonAction(value:String)
}