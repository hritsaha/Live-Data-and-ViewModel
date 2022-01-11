package com.example.livedataexample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt : TextView = findViewById(R.id.tv_data)
        val btn : Button = findViewById(R.id.btn_update)
        val input : EditText = findViewById(R.id.editTxt)

        //we have to initialize mainViewModel object with ViewModelProvider and pass the lifecycle owner as context
        mainViewModel = ViewModelProvider(this).get(MainViewModel :: class.java)


        //now we will observe live data (first parm = lifecycle owner,
        // 2nd parm  = Observer lambda func)
        //everytime data is changed the text view will be automatically updated
        mainViewModel.factsLiveData.observe(this, Observer {
            txt.text=it
        })


        //whenever we click the update button it takes the value from the EditText
        //and calls the updateLiveData func in the ViewModel
        btn.setOnClickListener {
            if(input.text.toString() == ""){
                Toast.makeText(this,"Input Something",Toast.LENGTH_SHORT).show()
            }
            else{
                val inpValue = input.text.toString()
                mainViewModel.updateLiveData(inpValue)
            }

        }
    }
}