package com.example.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        multiplyButton.setOnClickListener(this)
        divisionButton.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        try {
            var i = editTextNumber.text.toString().toDouble()
            var i2 = editTextNumber2.text.toString().toDouble()

            var x: Double
            val intent = Intent(this, ResultActivity::class.java)

                when (p0.id) {
                    R.id.plusButton -> {
                        x = (i + i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                    }
                    R.id.minusButton -> {
                        x = (i - i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                    }
                    R.id.multiplyButton -> {
                        x = (i * i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                    }
                    R.id.divisionButton -> {
                        x = (i / i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                    }
                }
                startActivity(intent)
        }catch (e :NumberFormatException){
            Snackbar.make(p0,"数値を入力してください",Snackbar.LENGTH_INDEFINITE).setAction("確認"){
                Log.d("UI_PARTS", "Snackbarをタップした")
            }.show()
//            Toast.makeText(this, "数値を入力してください。", Toast.LENGTH_SHORT).show()
        }

    }
}

