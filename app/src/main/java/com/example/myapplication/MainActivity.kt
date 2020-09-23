package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.buttons.*
import kotlinx.android.synthetic.main.input_layout.*


class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun numberEvent(view: View){
        if(isNewOp)
            tvInput.text = ""
        isNewOp=false
        var buClick: String = tvInput.text.toString()
        var buSelect: Button = view as Button
        when(buSelect.id){
            btn0.id -> {buClick += "0"}
            btn1.id -> {buClick += "1"}
            btn2.id -> {buClick += "2"}
            btn3.id -> {buClick += "3"}
            btn4.id -> {buClick += "4"}
            btn5.id -> {buClick += "5"}
            btn6.id -> {buClick += "6"}
            btn7.id -> {buClick += "7"}
            btn8.id -> {buClick += "8"}
            btn9.id -> {buClick += "9"}
            btnDot.id -> {buClick += "."}
            btnPM.id -> {buClick = "-$buClick" }
        }
        tvInput.text = buClick

    }

    fun operatorEvent(view: View){
        isNewOp = true
        oldNumber = tvInput.text.toString()
        var buSelect: Button = view as Button
        when(buSelect.id){
            btnMultiply.id -> {op = "*"}
            btnDivision.id -> {op = "/"}
            btnPlus.id -> {op = "+"}
            btnMinus.id -> {op = "-"}
            btnPercent.id -> {op = "%"}
        }

    }

    fun equalEvent(view: View){

        var newNumber = tvInput.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "%" -> {result = oldNumber.toDouble() % newNumber.toDouble()}
        }

        tvInput.text = result.toString()
    }

    fun clearEvent(view: View){
        tvInput.text = ""
        tvOutput.text = ""
        isNewOp = true
    }

}