package com.rimomo.convertidor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.rimomo.convertidor.R

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertir = findViewById<Button>(R.id.button)
        val limpiar = findViewById<Button>(R.id.button2)
        val valor = findViewById<EditText>(R.id.editTextText)
        val resultado = findViewById<TextView>(R.id.textView)
        val despliegue1 = findViewById<Spinner>(R.id.spinner)
        val tiposdeTemperaturas = arrayOf(" ","°C→°F","°C→°K","°F→°C","°F→°K","°K→C°","°K→°F")



        despliegue1.adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1, tiposdeTemperaturas).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            despliegue1.adapter = adapter
            despliegue1.onItemSelectedListener = this
        }

        convertir.setOnClickListener{

            when(despliegue1.selectedItem.toString()){

                "°C→°F" -> resultado.text = "${valor.text.toString().toInt() * 1.8 + 32}°F"

                "°C→°K" -> resultado.text = "${valor.text.toString().toInt() + 273.15}K"

                "°F→°C" -> resultado.text = "${(valor.text.toString().toInt() -32 ) * 5/9}°C"

                "°F→°K" -> resultado.text = "${(valor.text.toString().toInt() -32 ) * 5/9 + 273.15}K"

                "°K→°C" -> resultado.text = "${valor.text.toString().toInt() - 273.15}°C"

                "°K→°F" -> resultado.text = "${valor.text.toString().toInt() - 273.15 * 9/5 + 32}°F"

            }
        }
        limpiar.setOnClickListener { // Realizar acciones de limpieza aquí, por ejemplo, borrar campos de texto
            valor.text.clear()
            resultado.text = " "
            despliegue1.setSelection(0)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {

        val itemSeleccionado = parent?.getItemAtPosition(position).toString()
        if (itemSeleccionado.isNotBlank()) {
            Toast.makeText(this, "Seleccionaste: $itemSeleccionado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }



}