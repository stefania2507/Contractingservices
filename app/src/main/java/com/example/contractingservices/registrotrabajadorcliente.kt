package com.example.contractingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.inicio.*
import kotlinx.android.synthetic.main.registrotrabajadorcliente.*

class registrotrabajadorcliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrotrabajadorcliente)

        trabajador.setOnClickListener {
            val intent: Intent = Intent(this, registrogeneral::class.java)
            startActivity(intent)
        }
        cliente.setOnClickListener {
            val intent: Intent = Intent(this, registrogeneral::class.java)
            startActivity(intent)
        }
    }
}