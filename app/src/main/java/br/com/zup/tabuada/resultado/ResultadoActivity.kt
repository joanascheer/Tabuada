package br.com.zup.tabuada.resultado

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.tabuada.NUMERO
import br.com.zup.tabuada.R
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
        val totalMult0 = numero * 0
        val totalMult1 = numero * 1
        val totalMult2 = numero * 2
        val totalMult3 = numero * 3
        val totalMult4 = numero * 4
        val totalMult5 = numero * 5
        val totalMult6 = numero * 6
        val totalMult7 = numero * 7
        val totalMult8 = numero * 8
        val totalMult9 = numero * 9
        val totalMult10 = numero * 10

        exibe(
            totalMult0,
            totalMult1,
            totalMult2,
            totalMult3,
            totalMult4,
            totalMult5,
            totalMult6,
            totalMult7,
            totalMult8,
            totalMult9,
            totalMult10,
            numero
        )
    }

    private fun exibe(
        totalMult0: Int,
        totalMult1: Int,
        totalMult2: Int,
        totalMult3: Int,
        totalMult4: Int,
        totalMult5: Int,
        totalMult6: Int,
        totalMult7: Int,
        totalMult8: Int,
        totalMult9: Int,
        totalMult10: Int,
        numero: Int,
    ) {

        binding.resultadoText0.text =
            getString(R.string.resultado_text_0, numero.toString(), totalMult0.toString())
        binding.resultadoText1.text =
            getString(R.string.resultado_text_1, numero.toString(), totalMult1.toString())
        binding.resultadoText2.text =
            getString(R.string.resultado_text_2, numero.toString(), totalMult2.toString())
        binding.resultadoText3.text =
            getString(R.string.resultado_text_3, numero.toString(), totalMult3.toString())
        binding.resultadoText4.text =
            getString(R.string.resultado_text_4, numero.toString(), totalMult4.toString())
        binding.resultadoText5.text =
            getString(R.string.resultado_text_5, numero.toString(), totalMult5.toString())
        binding.resultadoText6.text =
            getString(R.string.resultado_text_6, numero.toString(), totalMult6.toString())
        binding.resultadoText7.text =
            getString(R.string.resultado_text_7, numero.toString(), totalMult7.toString())
        binding.resultadoText8.text =
            getString(R.string.resultado_text_8, numero.toString(), totalMult8.toString())
        binding.resultadoText9.text =
            getString(R.string.resultado_text_9, numero.toString(), totalMult9.toString())
        binding.resultadoText10.text =
            getString(R.string.resultado_text_10, numero.toString(), totalMult10.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}