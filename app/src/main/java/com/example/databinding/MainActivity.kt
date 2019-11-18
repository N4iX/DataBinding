package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit = late initialization, assign value LATER
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Chew")
    private val myContactNum: MyContactNum = MyContactNum("0123456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonSetName.setOnClickListener{
            //it = object (button associated to an event)
            addNickName(it)
        }

        binding.buttonSetContactNum.setOnClickListener{
            addContactNum(it)
        }

        binding.myName = myName
        binding.myContactNum = myContactNum
        //setContentView(R.layout.activity_main)
    }

    private fun addContactNum(it: View?) {
        binding.apply {
            myContactNum?.contactNum = editTextContactNum.text.toString()
            this.invalidateAll()
        }
    }

    private fun addNickName(it: View?) {
        //apply = execute multiple setters
        binding.apply{
            myName?.name = editTextName.text.toString()
            this.invalidateAll()//refresh the content
        }
    }


}
