package br.com.zup.tabuada.resultado

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.tabuada.NUMERO
import br.com.zup.tabuada.R
import br.com.zup.tabuada.TEXTO_TABUADA
import br.com.zup.tabuada.databinding.ActivityResultadoBinding
import br.com.zup.tabuada.main.MainActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_resultado_tabuada)

        exibeResultado()

        binding.btnNovoCalculo.setOnClickListener {
            chamaHome()
        }
    }

    private fun chamaHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun exibeResultado() {
        val numero = recuperaDados()

        if (numero != null) {
            calcula(numero)
        }
    }
    
    private fun recuperaDados(): Int? {
        return intent.getStringExtra(NUMERO)?.toInt()
    }


    private fun calcula(numero: Int) {
        var totalMult = 0
        for (i in 0..10) {
            totalMult = numero * i
            println("$numero * $i = $totalMult")
        }
        binding.resultadoText.text = totalMult.toString()
    }
}