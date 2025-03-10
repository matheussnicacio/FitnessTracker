package co.tiagoaguiar.fitnesstracker

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class ImcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Substituindo enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_imc)

        editWeight = findViewById(R.id.edit_imc_weight)
        editHeight = findViewById(R.id.edit_imc_height)

        val btnSend: Button = findViewById(R.id.btn_imc_send)
        btnSend.setOnClickListener {

            if (!validate()) {

                Toast.makeText(this, R.string.fields_message, Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }
            // Aqui deu sucesso
            val weight = editWeight.text.toString().toInt()
            val height = editHeight.text.toString().toInt()

            val result = calculateImc(weight, height)
            Log.d("Teste", "Resultado: $result")

            val imcResponseId = imcResponse(result)
            Toast.makeText(this, imcResponseId, Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /*
    class R {
    class string {
         imc_severely_low_weight = 213141233143213
         imc_very_low_weight     = 142312313414122
    }
    class layout {
    }
    class string {
    }

    }

    R.string
    R.layout
    R.id
     */

@StringRes
    private fun imcResponse(imc: Double): Int {

        return when {
            imc < 15.0 -> R.string.imc_severely_low_weight
            imc < 16.0 -> R.string.imc_very_low_weight
            imc < 18.5 -> R.string.imc_low_weight
            imc < 25.0 -> R.string.normal
            imc < 30.0 -> R.string.imc_high_weight
            imc < 35.0 -> R.string.imc_so_high_weight
            imc < 40.0 -> R.string.imc_severely_high_weight
            else -> R.string.imc_extreme_weight

        }

//        if (imc < 15.0) {
//            return R.string.imc_severely_low_weight
//        } else if (imc < 16.0) {
//            return R.string.imc_very_low_weight
//        } else if (imc < 18.5) {
//            return R.string.imc_low_weight
//        } else if (imc < 25.0) {
//            return R.string.normal
//        } else if (imc < 30.0) {
//            return R.string.imc_high_weight
//        } else if (imc < 35.0) {
//            return R.string.imc_so_high_weight
//        } else if (imc < 40.0) {
//            return R.string.imc_severely_high_weight
//        } else {
//            return R.string.imc_extreme_weight
//        }

    }


    private fun calculateImc(weight: Int, height: Int): Double {
        // peso / (altura * altura)

        return weight / ((height / 100.0) * (height / 100.0))
    }

    private fun validate(): Boolean {
        // nao pode inserir valores nulos / vazio
        // nao pode inserir / comecao com 0

        // true && true = true
        // true && false = false
        // false && true = false
        // false && false = false

        // opçao 1 : Usar if else
//        if (editWeight.text.toString().isNotEmpty()
//            && editHeight.text.toString().isNotEmpty()
//            && !editWeight.text.toString().startsWith("0")
//            && !editHeight.text.toString().startsWith("0")
//        ) {
//            return true
//        } else {
//            return false
//        }

        // opção 2 : Usar somente return pra simular if e else
//        if (editWeight.text.toString().isNotEmpty()
//            && editHeight.text.toString().isNotEmpty()
//            && !editWeight.text.toString().startsWith("0")
//            && !editHeight.text.toString().startsWith("0")
//        ) {
//            return true
//        }
//        return false
//    }

        // opcao 3 : Forma mais  enxuta possivel para retornar um true | false
        // return direto o que for verdadeiro
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0")
                )
    }

}
