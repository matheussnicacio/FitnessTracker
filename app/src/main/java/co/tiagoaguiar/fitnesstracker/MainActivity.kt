package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private lateinit var btnImc: LinearLayout

    private lateinit var rvMain: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_accessibility_24,
                textStringId = R.string.label_imc,
                color = Color.GREEN
            ),
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_remove_red_eye_24,
                textStringId = R.string.tmb,
                color = Color.YELLOW
            ),
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_remove_red_eye_24,
                textStringId = R.string.tmb,
                color = Color.MAGENTA
            ),
        )




        // 1) o layout XML
        // 2) a onde a recycleview vai aparecer (tela principal, tela cheia)
        // 3) logica - conectar o xml da celula DENTRO do recycleView + a sua quantidade de elementos dinamicos

        val adapter = MainAdapter(mainItems)
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

    private inner class MainAdapter (private val mainItems: List<MainItem>): RecyclerView.Adapter<MainViewHolder>() {

        // 1 - Qual é o layout XML da celula especifica (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)

        }

        // 2 - Disparado toda vez que houver uma rolagem na tela e for
        // necessario trocar o conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        // 3 - Informar quantas celulas essa listagem terá
        override fun getItemCount(): Int {
            return mainItems.size
        }
    }

    // é a classe da celula em si !!!
    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item : MainItem){
            val img: ImageView = itemView.findViewById(R.id.item_img_icon)
            val name: TextView = itemView.findViewById(R.id.item_txt_name)
            val container: LinearLayout = itemView.findViewById(R.id.item_container_imc) // Aqui está a correção

            img.setImageResource(item.drawableId)
            name.setText(item.textStringId)
            container.setBackgroundColor(item.color)
        }
    }

}

