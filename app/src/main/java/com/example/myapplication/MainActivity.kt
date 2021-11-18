package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num_1 = findViewById<EditText>(R.id.ac_main_num1)
        var num_2 = findViewById<EditText>(R.id.ac_main_num2)
        var tv_result = findViewById<TextView>(R.id.ac_main_tv_result)

        val status = arrayOf("انتخاب کنید","+","-","÷","×")
        val sp_calu = findViewById<Spinner>(R.id.ac_main_sp_calc)
        val sp_adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,status)
        sp_calu.adapter = sp_adapter

        sp_calu.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(num_1.text.toString()!="" && num_2.text.toString()!="") {
                    if (sp_calu.selectedItemPosition == 0) {
                        tv_result.text = "   "
                    } else if (sp_calu.selectedItemPosition == 1) {

                        var n1: Int = num_1.text.toString().toInt()
                        var n2: Int = num_2.text.toString().toInt()
                        var result = n1 + n2
                        tv_result.text = result.toString()

                    } else if (sp_calu.selectedItemPosition == 2) {

                        var n1: Int = num_1.text.toString().toInt()
                        var n2: Int = num_2.text.toString().toInt()
                        var result = n1 - n2
                        tv_result.text = result.toString()

                    }else if (sp_calu.selectedItemPosition == 3) {
                        if(num_2.text.toString()!="0"){
                            var n1: Int = num_1.text.toString().toInt()
                            var n2: Int = num_2.text.toString().toInt()
                            var result = n1 / n2
                            tv_result.text = result.toString()
                        }
                    }
                    else if (sp_calu.selectedItemPosition == 4) {

                        var n1: Int = num_1.text.toString().toInt()
                        var n2: Int = num_2.text.toString().toInt()
                        var result = n1 * n2
                        tv_result.text = result.toString()

                    }
                }
                else{
                    Toast.makeText(this@MainActivity,"فیلد ها خالی میباشد", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }
}