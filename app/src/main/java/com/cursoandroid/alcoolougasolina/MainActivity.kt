package com.cursoandroid.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cursoandroid.alcoolougasolina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCalcular.setOnClickListener(){
            calcularPreco()
        }
    }

    fun calcularPreco(){
        //val precoAlcool = findViewById<EditText>(R.id.txtAlcool)

        val precoAlcool = binding.txtAlcool.text.toString()
        val precoGasolina = binding.txtGasolina.text.toString()

        if(validarCampos(precoAlcool, precoGasolina)){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            binding.txtResultado.text = "Preencha os campos primeiro!"
        }
    }
    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina
        if(resultadoPreco >= 0.7){
            binding.txtResultado.text = "Melhor utilizar gasolina"
        }else{
            binding.txtResultado.text = "Melhor utilizar alcool"
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{

        var camposValidados: Boolean = true
        if(precoAlcool == null  || precoAlcool.equals("") || precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }

}