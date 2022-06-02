package br.com.zup.tabuada.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.tabuada.MENSAGEM_CAMPO_NUMERO_OBRIGATORIO
import br.com.zup.tabuada.NUMERO
import br.com.zup.tabuada.databinding.ActivityMainBinding
import br.com.zup.tabuada.resultado.ResultadoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var numeroACalcular: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcula.setOnClickListener {
            enviaDados()
        }
    }

    private fun enviaDados() {
        recuperaNumeroDigitado()
        if (!verificaCampos()) {
            val intent = Intent(this, ResultadoActivity::class.java).apply {
                putExtra(NUMERO, numeroACalcular)
            }
            startActivity(intent)
            limpaCampos()
        }
    }

    private fun recuperaNumeroDigitado(): String {
        this.numeroACalcular = binding.editText.text.toString()
        return numeroACalcular
    }

    private fun verificaCampos(): Boolean {
        when {
            this.numeroACalcular.isEmpty() -> {
                binding.editText.error = MENSAGEM_CAMPO_NUMERO_OBRIGATORIO
                return true
            }
        }
        return false
    }

    private fun limpaCampos() {
        binding.editText.text.clear()
    }
}