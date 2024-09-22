package com.example.calculadora.view

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.R
import com.example.calculadora.presentador.PresentadorMain

class MainActivity : AppCompatActivity(), ViewInterface {

    private lateinit var btn_0:Button
    private lateinit var btn_1:Button
    private lateinit var btn_2:Button
    private lateinit var btn_3:Button
    private lateinit var btn_4:Button
    private lateinit var btn_5:Button
    private lateinit var btn_6:Button
    private lateinit var btn_7:Button
    private lateinit var btn_8:Button
    private lateinit var btn_9:Button
    private lateinit var btn_clear:Button
    private lateinit var btn_mult:Button
    private lateinit var btn_sum:Button
    private lateinit var btn_sub:Button
    private lateinit var btn_div:Button
    private lateinit var btn_equal:Button
    private lateinit var btn_dot:Button
    private lateinit var btn_del:Button
    private lateinit var btn_parenthesis_start:Button
    private lateinit var btn_parenthesis_end:Button
    private lateinit var vw_viewoperations:TextView
    private lateinit var vw_viewresult: TextView

    private lateinit var presenter: PresentadorMain


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initPresenter()
        initComponents()
        initUi()
        initListeners()
    }

    private fun initPresenter(){
        presenter = PresentadorMain(this)
    }
    private fun initComponents() {

        btn_0 = findViewById(R.id.btn_zero)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_seven)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)

        btn_clear = findViewById(R.id.btn_clear)
        btn_mult = findViewById(R.id.multiply)
        btn_sum = findViewById(R.id.sum)
        btn_sub = findViewById(R.id.substract)
        btn_div = findViewById(R.id.btn_division)
        btn_equal = findViewById(R.id.equal)
        btn_dot = findViewById(R.id.btn_dot)
        btn_del = findViewById(R.id.btn_delete)
        btn_parenthesis_start = findViewById(R.id.btn_parenthesis_start)
        btn_parenthesis_end = findViewById(R.id.btn_parenthesis_end)

        vw_viewoperations = findViewById(R.id.vw_viewoperations)
        vw_viewresult = findViewById(R.id.vw_viewresult)


    }
    private fun initUi() {
        vw_viewoperations.text = "0"
    }
    private fun initListeners() {
        btn_0.setOnClickListener { operationsButtonsAction("0") }
        btn_1.setOnClickListener { operationsButtonsAction("1") }
        btn_2.setOnClickListener { operationsButtonsAction("2") }
        btn_3.setOnClickListener { operationsButtonsAction("3") }
        btn_4.setOnClickListener { operationsButtonsAction("4") }
        btn_5.setOnClickListener { operationsButtonsAction("5") }
        btn_6.setOnClickListener { operationsButtonsAction("6") }
        btn_7.setOnClickListener { operationsButtonsAction("7") }
        btn_8.setOnClickListener { operationsButtonsAction("8") }
        btn_9.setOnClickListener { operationsButtonsAction("9") }
        btn_sum.setOnClickListener { operationsButtonsAction("+") }
        btn_sub.setOnClickListener { operationsButtonsAction("-") }
        btn_mult.setOnClickListener { operationsButtonsAction("*") }
        btn_div.setOnClickListener { operationsButtonsAction("/") }
        btn_dot.setOnClickListener { operationsButtonsAction(".") }
        btn_parenthesis_start.setOnClickListener { operationsButtonsAction("(") }
        btn_parenthesis_end.setOnClickListener { operationsButtonsAction(")") }


        btn_clear.setOnClickListener { clearButtonAction() }
        btn_del.setOnClickListener { deleteButtonAction() }

        btn_equal.setOnClickListener { resultButtonAction() }
    }

    override fun operationsButtonsAction(btnPressed: String) {
        presenter.operationsButtonsAction(btnPressed, vw_viewoperations.text.toString())
    }

    override fun resultButtonAction() {
        presenter.resultButtonAction(vw_viewoperations.text.toString())
    }

    override fun clearButtonAction() {
        presenter.clearButtonAction()
    }

    override fun deleteButtonAction() {
        presenter.deleteButtonAction(vw_viewoperations.text.toString())
    }

    override fun paintOperations(value: String) {
        vw_viewoperations.text = value
    }

    override fun paintResult(value: String) {
        vw_viewresult.text = value
    }

    override fun clear() {
        vw_viewoperations.text = "0"
        vw_viewresult.text = ""

    }

    override fun delete(value: String) {
        vw_viewoperations.text = value
    }


}