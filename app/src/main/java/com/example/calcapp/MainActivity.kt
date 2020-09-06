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
        pulsImage.setOnClickListener(this)
        minusImage.setOnClickListener(this)
        multiplyImage.setOnClickListener(this)
        divisionImage.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        try {
            var i = editTextNumber.text.toString().toDouble()
            var i2 = editTextNumber2.text.toString().toDouble()

            var x: Double
            val intent = Intent(this, ResultActivity::class.java)
            if (p0 != null) {
                when (p0.id) {
                    R.id.pulsImage -> {
                        x = (i + i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                        pulsImage.imageAlpha = 50
                    }
                    R.id.minusImage -> {
                        x = (i - i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                        minusImage.imageAlpha = 50
                    }
                    R.id.multiplyImage -> {
                        x = (i * i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                        multiplyImage.imageAlpha = 50
                    }
                    R.id.divisionImage -> {
                        x = (i / i2)
                        intent.putExtra("VALUE1", x)
                        Log.d("TEST", x.toString())
                        divisionImage.imageAlpha = 50
                    }
                }
                startActivity(intent)
            }
        }catch (e :NumberFormatException){
            Toast.makeText(this, "数値を入力してください。", Toast.LENGTH_SHORT).show()
        }

    }
}

