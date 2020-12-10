package com.itvo.miperfil

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.itvo.miperfil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private  lateinit var binding: ActivityMainBinding
    private var myNombre: MyNombre = MyNombre(nombre = "oscar franco")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.miNombre = myNombre

        binding.btnTerminar .setOnClickListener {
            agregarUsuario(it)
        }
    }

    private fun agregarUsuario(boton: View) {
        //val editText = findViewById<EditText>(R.id.usuario_edit_text)
        //val usuarioTextView = findViewById<TextView>(R.id.usuario_text)
        binding.apply {
            invalidateAll()

            miNombre?.usuario = usuarioEditText.toString()

            usuarioEditText.visibility = View.GONE

            boton.visibility = View.GONE

            usuarioText.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(boton.windowToken,0)
    }
}