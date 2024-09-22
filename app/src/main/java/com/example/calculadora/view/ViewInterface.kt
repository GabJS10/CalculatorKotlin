package com.example.calculadora.view

interface ViewInterface {
    fun operationsButtonsAction(btnPressed: String)
    fun resultButtonAction()
    fun clearButtonAction()
    fun deleteButtonAction()
    fun paintOperations(value:String)
    fun paintResult(value:String)
    fun clear()
    fun delete(value: String)
}