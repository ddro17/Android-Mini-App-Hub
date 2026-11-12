package com.example.multi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calculator : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentInput = ""
    private var operator = ""
    private var firstOperand = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        tvDisplay = findViewById(R.id.tvDisplay)

        val numberButtons = listOf(
            findViewById<Button>(R.id.btn0),
            findViewById<Button>(R.id.btn1),
            findViewById<Button>(R.id.btn2),
            findViewById<Button>(R.id.btn3),
            findViewById<Button>(R.id.btn4),
            findViewById<Button>(R.id.btn5),
            findViewById<Button>(R.id.btn6),
            findViewById<Button>(R.id.btn7),
            findViewById<Button>(R.id.btn8),
            findViewById<Button>(R.id.btn9)
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                appendToInput((it as Button).text.toString())
            }
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { performOperation("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { performOperation("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { performOperation("×") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { performOperation("÷") }

        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearInput() }
    }

    private fun appendToInput(value: String) {
        currentInput += value
        tvDisplay.text = currentInput
    }

    private fun performOperation(op: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            operator = op
            currentInput = ""
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && operator.isNotEmpty()) {
            val secondOperand = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "×" -> firstOperand * secondOperand
                "÷" -> if (secondOperand != 0.0) firstOperand / secondOperand else Double.NaN
                else -> 0.0
            }
            tvDisplay.text = result.toString()
            currentInput = result.toString()
            operator = ""
        }
    }

    private fun clearInput() {
        currentInput = ""
        operator = ""
        tvDisplay.text = "0"
    }
}