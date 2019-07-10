package com.example.calculator

class CalcLogic {
    val OP_ADD = '+'
    val OP_SUB = '-'
    val OP_MUL = '*'
    val OP_DIV = '/'

    fun evaluate(num1: Double, num2: Double, currOp: Char): Double{
        val result = when (currOp) {
            OP_ADD -> num1 + num2
            OP_SUB -> num1 - num2
            OP_MUL -> num1 * num2
            OP_DIV -> num1 / num2
            else -> throw Exception("INVALID OPERATOR")
        }
        return result
    }
}