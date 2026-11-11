package com.example.androidProyect.vista

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.androidProyect.ConsolaActivity
import com.example.androidProyect.MainActivity
import com.example.androidProyect.R
import com.example.androidProyect.datos.RepositorioSingleton

class AdaptadorLista(val contexto: Context) : RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    //RecyclerView.Adapter: Es una superclase que trae todo el mecanismo interno para manejar listas grandes, reciclar tarjetas que salen de la pantalla para que no gasten memoria, etc.

    val lista = RepositorioSingleton.instance.listaConsolas
    //El adaptador necesita consultar esta lista constantemente para saber cuántos personajes hay, qué nombre poner en cada tarjeta, qué ocupación tienen, etc.
    val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    //Para saber cómo materializar el diseño visual de cada tarjeta en la pantalla.



    //Crear y poblar la interfaz
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {

        //Que coja el layout y lo infle
        val vista = inflador.inflate(R.layout.tarjeta_consola, parent, false)

        //Devolver la vista
        return CreadorItems(vista, contexto) //la devuelve junto con su contexo

    }

    //"Tu eres el elemento x de la lista, cuando poblamos la interfaz"
    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val consola = MainActivity.listaConsolas.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre).text = consola.nombre

        holder.itemView.findViewById<TextView>(R.id.tarjeta_fecha)
            .text = consola.FechaLanzamiento.toString()

        holder.itemView.findViewById<TextView>(R.id.tarjeta_descripcion)
            .text = consola.descripcion


        val draw = AppCompatResources.getDrawable(contexto, consola.imagen)
        holder.itemView.findViewById<ImageView>(R.id.imagen_pequenno).setImageDrawable(draw)
    }

    //Le dice cuantos elementos hay en la lista
    override fun getItemCount(): Int {
        return MainActivity.listaConsolas.longitud()
    }

    //Representa cada una de las tarjetas
    class CreadorItems(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView) { //Aqui arriba ya he escrito un constructor

        //Codigo dentro del constructor que no sea inicializar cosas
        init {
            val layout = itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
            layout.setOnClickListener {
                val position = bindingAdapterPosition //Posicion en la lista en la que estamos
                val intent = Intent(contexto, ConsolaActivity::class.java) // :: --> Acceder a metadatos ///// .java --> tiene que ser capaz de instanciar la clase
                intent.putExtra("numero", position)
                contexto.startActivity(intent)
            }
        }

    }

}


