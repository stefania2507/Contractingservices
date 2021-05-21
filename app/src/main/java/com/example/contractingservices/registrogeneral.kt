package com.example.contractingservices

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.registrogeneral.*


class registrogeneral : AppCompatActivity(), View.OnClickListener {
            //defining view objects
            private var TextEmail: EditText? = null
            private var TextPassword: EditText? = null
            private var btnRegistrar: Button? = null
            private var progressDialog: ProgressDialog? = null

            //Declaramos un objeto firebaseAuth
            private var firebaseAuth: FirebaseAuth? = null
            override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                setContentView(com.example.contractingservices.R.layout.registrogeneral)


                //inicializamos el objeto firebaseAuth
                firebaseAuth = FirebaseAuth.getInstance()

                //Referenciamos los views
                TextEmail = findViewById<View>(com.example.contractingservices.R.id.Email) as EditText
                TextPassword = findViewById<View>(com.example.contractingservices.R.id.password) as EditText
                btnRegistrar = findViewById<View>(com.example.contractingservices.R.id.botonaceptar) as Button
                progressDialog = ProgressDialog(this)

                //attaching listener to button
                botonaceptar.setOnClickListener(this)
            }

            private fun registrarUsuario() {

                //Obtenemos el email y la contraseña desde las cajas de texto
                val email = TextEmail!!.text.toString().trim { it <= ' ' }
                val password = TextPassword!!.text.toString().trim { it <= ' ' }

                //Verificamos que las cajas de texto no esten vacías
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show()
                    return
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show()
                    return
                }
                progressDialog!!.setMessage("Realizando registro en linea...")
                progressDialog!!.show()

                //creating a new user
                firebaseAuth!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        this
                    ) { task -> //checking if success
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@registrogeneral,
                                "Se ha registrado el usuario con el email: " + TextEmail!!.text,
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this@registrogeneral,
                                "No se pudo registrar el usuario ",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        progressDialog!!.dismiss()
                    }
            }

            override fun onClick(view: View?) {
                //Invocamos al método:
                registrarUsuario()
            }
        }

