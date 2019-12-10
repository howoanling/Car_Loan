package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calbtn = findViewById<Button>(R.id.buttonCalculate)

        calbtn.setOnClickListener{
            calculateloan()
        }

        val rstbtn = findViewById<Button>(R.id.buttonReset)

        rstbtn.setOnClickListener{
            editTextCarPrice.text = null
            editTextDownPayment.text = null
            editTextLoanPeriod.text = null
            editTextInterestRate.text = null
            textViewLoan.text = "Loan :"
            textViewInterest.text = "Interest :"
            textViewMonthlyRepayment.text = "Monthly Repayment: "

        }


    }

    private fun calculateloan( ) {
        val carPrice : Float = editTextCarPrice.text.toString().toFloat()
        val downPayment : Float = editTextDownPayment.text.toString().toFloat()
        val loanresult : String = String.format("%.2f",carPrice-downPayment)
        textViewLoan.text = "Loan Result :" + loanresult
        val interest : Float = editTextInterestRate.text.toString().toFloat()
        val loanPeriod : Float = editTextLoanPeriod.text.toString().toFloat()
        val loanFloat : Float = loanresult.toFloat()
        val interestResult :String = String.format("%.2f",loanFloat*interest/100*loanPeriod)
        textViewInterest.text = "Interest Result :" + interestResult
        val interestFloat : Float = interestResult.toFloat()
        val monthlyPaymentResult : Float =  (loanFloat+interestFloat)/loanPeriod/12
        val MPResult : String = String.format("%.2f",monthlyPaymentResult)
        textViewMonthlyRepayment.text = "Monthly Repayment :" + MPResult


    }






}
