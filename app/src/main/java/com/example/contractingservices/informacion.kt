package com.example.contractingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.informacion.*
import kotlinx.android.synthetic.main.inicio.*

class informacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informacion)

        volver.setOnClickListener {
            val intent: Intent = Intent(this, inicio::class.java)
            startActivity(intent)
        }
    }
}