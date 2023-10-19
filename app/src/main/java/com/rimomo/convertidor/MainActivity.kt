package com.rimomo.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.rimomo.convertidor.R

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertir = findViewById<Button>(R.id.button)
        val limpiar = findViewById<Button>(R.id.button2)
        val valor = findViewById<EditText>(R.id.editTextText)
        val despliegue1 = findViewById<Spinner>(R.id.spinner)

        val tiposdeTemperaturas = arrayOf("°C→°F","°C→°K","°F→°C","°F→°K","°K→C°","°K→°F")


        despliegue1.adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1, tiposdeTemperaturas).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            despliegue1.adapter = adapter
            despliegue1.onItemSelectedListener = this
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
        val itemSeleccionado = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this, "Seleccionaste: $itemSeleccionado", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}