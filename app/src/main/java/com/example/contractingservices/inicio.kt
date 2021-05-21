package com.example.contractingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.inicio.*

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)
        inicio1.setOnClickListener {
            val intent: Intent = Intent(this, iniciosesion::class.java)
            startActivity(intent)
        }
        registro1.setOnClickListener {
            val intent: Intent = Intent(this, registrotrabajadorcliente::class.java)
            startActivity(intent)
        }
        informacion1.setOnClickListener {
            val intent: Intent = Intent(this, informacion::class.java)
            startActivity(intent)
        }
    }
}