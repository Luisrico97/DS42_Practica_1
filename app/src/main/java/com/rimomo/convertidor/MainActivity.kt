package com.rimomo.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.rimomo.convertidor.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertir = findViewById<Button>(R.id.button)
        val limpiar = findViewById<Button>(R.id.button2)
        val valor = findViewById<EditText>(R.id.editTextText)
        val despliegue1 = findViewById<Spinner>(R.id.spinner)
        val despliegue2 = findViewById<Spinner>(R.id.spinner2)
        val tiposdeTemperaturas = arrayOf("°C","°F","°K")


        despliegue1.adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1, tiposdeTemperaturas)

        despliegue2.adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1, tiposdeTemperaturas)
    }
}
