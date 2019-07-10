package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var firstNum = 0.0
    var secondNum = 0.0
    var currOp = '$'
    var isResultSet = false

    val calcLogic = CalcLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachListeners()
    }

    fun attachListeners(){
        val btnArray = arrayOf(
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnResult, btnClear,
            btnAdd, btnSub, btnMul, btnDiv
        )

        for(btn in btnArray){
            btn.setOnClickListener(this)
        }
    }

    fun showResult() {
        if (currOp != '$') {
            val result = calcLogic.evaluate(firstNum, secondNum, currOp)
            tvResult.text = result.toString()

            firstNum = result
            isResultSet = true
        }
    }

    fun displayNum(currNum: Int) {
        if(currOp != '$') {
            secondNum = secondNum * 10 + currNum
            tvSecond.text = secondNum.toString()
        } else {
            firstNum = firstNum * 10 + currNum
            tvFirst.text = firstNum.toString()
        }
    }

    fun displayOp(inputOp: Char) {
        if(isResultSet) {
            clear(false)
            tvFirst.text = firstNum.toString()
        }
        currOp = inputOp
        tvOp.text = currOp.toString()
    }

    fun clear(allClear: Boolean = true) {
        tvResult.text = ""
        tvOp.text = ""
        tvFirst.text = ""
        tvSecond.text = ""

        if (allClear) {
            firstNum = 0.0
        }

        secondNum = 0.0
        currOp = '$'
        isResultSet = false
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn0 -> displayNum(0)
            R.id.btn1 -> displayNum(1)
            R.id.btn2 -> displayNum(2)
            R.id.btn3 -> displayNum(3)
            R.id.btn4 -> displayNum(4)
            R.id.btn5 -> displayNum(5)
            R.id.btn6 -> displayNum(6)
            R.id.btn7 -> displayNum(7)
            R.id.btn8 -> displayNum(8)
            R.id.btn9 -> displayNum(9)
            R.id.btnAdd -> displayOp('+')
            R.id.btnSub -> displayOp('-')
            R.id.btnMul -> displayOp('*')
            R.id.btnDiv -> displayOp('/')
            R.id.btnResult -> showResult()
            R.id.btnClear -> clear()
        }
    }
}


/*

package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var res=""
        var sym=""
        var fg=0

        btnClear.setOnClickListener {
            tvResult.text = "0"
            //  tvSym.text = ""
            res=""
            sym=""
        }

        btnResult.setOnClickListener {
            if(res!="" && sym!="")
            {
                val a = res.toFloat()
                val b = tvResult.text.toString().toFloat()

                if(sym=="+")    tvResult.text = (a+b).toString()
                if(sym=="/")    tvResult.text = (a/b).toString()
                if(sym=="*")    tvResult.text = (a*b).toString()
                if(sym=="-")    tvResult.text = (a-b).toString()

                sym=""
                //   tvSym.text = ""
                res = tvResult.text.toString()
                fg=1

            }
        }

        btnPlus.setOnClickListener {
            if(sym!="" && res!="")
            {
                val a = res.toFloat()
                val b = tvResult.text.toString().toFloat()

                if(sym=="+")
                    tvResult.text = (a+b).toString()
                if(sym=="/")
                    tvResult.text = (a/b).toString()
                if(sym=="*")
                    tvResult.text = (a*b).toString()
                if(sym=="-")
                    tvResult.text = (a-b).toString()

                res = tvResult.text.toString()
                fg=1
            }
            else {
                sym = "+"
                //  tvSym.text = "+"
                res = tvResult.text.toString()
                tvResult.text = "0"
            }
        }
        btnMinus.setOnClickListener {
            if(sym!="" && res!="")
            {
                val a = res.toFloat()
                val b = tvResult.text.toString().toFloat()

                if(sym=="+")
                    tvResult.text = (a+b).toString()
                if(sym=="/")
                    tvResult.text = (a/b).toString()
                if(sym=="*")
                    tvResult.text = (a*b).toString()
                if(sym=="-")
                    tvResult.text = (a-b).toString()

                res = tvResult.text.toString()
                fg=1
            }
            else {
                sym = "-"
                //    tvSym.text = "-"
                res = tvResult.text.toString()
                tvResult.text = "0"
            }
        }
        btnMul.setOnClickListener {
            if(sym!="" && res!="")
            {
                val a = res.toFloat()
                val b = tvResult.text.toString().toFloat()

                if(sym=="+")
                    tvResult.text = (a+b).toString()
                if(sym=="/")
                    tvResult.text = (a/b).toString()
                if(sym=="*")
                    tvResult.text = (a*b).toString()
                if(sym=="-")
                    tvResult.text = (a-b).toString()

                res = tvResult.text.toString()
                fg=1
            }
            else {
                sym = "*"
                // tvSym.text = "*"
                res = tvResult.text.toString()
                tvResult.text = "0"
            }
        }
        btndiv.setOnClickListener {
            if(sym!="" && res!="")
            {
                val a = res.toFloat()
                val b = tvResult.text.toString().toFloat()

                if(sym=="+")
                    tvResult.text = (a+b).toString()
                if(sym=="/")
                    tvResult.text = (a/b).toString()
                if(sym=="*")
                    tvResult.text = (a*b).toString()
                if(sym=="-")
                    tvResult.text = (a-b).toString()

                res = tvResult.text.toString()
                fg=1
            }
            else {
                sym = "/"
                // tvSym.text = "/"
                res = tvResult.text.toString()
                tvResult.text = "0"
            }
        }

        btn0.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="0"
            }else if(tvResult.text != "0"){
                tvResult.text = tvResult.text.toString()+"0"
            }
        }

        btn1.setOnClickListener {
            if(fg==1) {
                fg = 0
                tvResult.text = "1"
            }else if(tvResult.text == "0")
                tvResult.text = "1"
            else
                tvResult.text = tvResult.text.toString()+"1"
        }

        btn2.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="2"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "2"
                else
                    tvResult.text = tvResult.text.toString()+"2"
        }

        btn3.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="3"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "3"
                else
                    tvResult.text = tvResult.text.toString()+"3"
        }

        btn4.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="4"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "4"
                else
                    tvResult.text = tvResult.text.toString()+"4"
        }

        btn5.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="5"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "5"
                else
                    tvResult.text = tvResult.text.toString()+"5"
        }

        btn6.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="6"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "6"
                else
                    tvResult.text = tvResult.text.toString()+"6"
        }

        btn7.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="7"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "7"
                else
                    tvResult.text = tvResult.text.toString()+"7"
        }

        btn8.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="8"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "8"
                else
                    tvResult.text = tvResult.text.toString()+"8"
        }

        btn9.setOnClickListener {
            if(fg==1){
                fg=0
                tvResult.text="9"
            }else
                if(tvResult.text == "0")
                    tvResult.text = "9"
                else
                    tvResult.text = tvResult.text.toString()+"9"
        }

    }
}

*/
