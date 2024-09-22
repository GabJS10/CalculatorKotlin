package com.example.calculadora.presentador

import com.example.calculadora.modelo.ModelMain
import com.example.calculadora.view.MainActivity

class PresentadorMain(private var view: MainActivity) :PresentadorInterface {

    private val model = ModelMain()


    override fun operationsButtonsAction(btnPressed: String, viewText: String) {
        val result = model.addToViewOperations(viewText, btnPressed)
        view.paintOperations(result)
    }


    override fun resultButtonAction(value: String) {
        val result = model.result(value)
        view.paintResult(result)
    }

    override fun clearButtonAction() {
        view.clear()
    }

    override fun deleteButtonAction(value: String) {
        val newValue = model.deleteLast(value)
        view.delete(newValue)
    }
}