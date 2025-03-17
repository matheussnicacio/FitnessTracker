package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private lateinit var btnImc: LinearLayout

    private lateinit var rvMain: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) o layout XML
        // 2) a onde a recycleview vai aparecer (tela principal, tela cheia)
        // 3) logica - conectar o xml da celula DENTRO do recycleView + a sua quantidade de elementos dinamicos

        val adapter = MainAdapter()
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

        // classe para administrar a recyclerView a suas celulas (os seus layouts de itens)
        // Adapter ->


        //        btnImc = findViewById(R.id.btn_imc)

//        btnImc.setOnClickListener {
//            // Navegar para proxima tela
//            val i = Intent(this,ImcActivity::class.java)
//            startActivity(i)
//        }
    }

    private inner class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

        // 1 - Qual é o layout XML da celula especifica (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)

        }


        // 2 - Disparado toda vez que houver uma rolagem na tela e for
        // necessario trocar o conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        }

        // 3 - Informar quantas celulas essa listagem terá
        override fun getItemCount(): Int {
            return 30
        }


    }

    // é a classe da celula em si !!!
    private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)

}