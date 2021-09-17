package ru.geekbrains.lesson_1423_2_2_main.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import keyone.keytwo.lesson3_2kotlin.R
import keyone.keytwo.lesson3_2kotlin.domain.Weather
import keyone.keytwo.lesson3_2kotlin.view.OnItemViewClickListener


//3 урок
class MainFragmentAdapter:RecyclerView.Adapter<MainFragmentAdapter.MainFragmentViewHolder>() {

    // адаптер

    // weatherData указывает на что-то в куче
    private var weatherData: List<Weather> = listOf() //список погоды

    //передаем
    private lateinit var listener: OnItemViewClickListener

    //   private lateinit var  listener: OnItemViewClickListener


    // для доступа к weatherData пропишем и вызовем метод
    fun setWeather(data: List<Weather>) {
        weatherData = data
        notifyDataSetChanged()//обновляет данные все
    }

    // пропишем и вызовем метод
    fun setOnItemViewClickListener(onItemViewClickListener: OnItemViewClickListener) {
        listener = onItemViewClickListener
    }


    //  fun setOnItemViewClickListener(onItemViewClickListener:OnItemViewClickListener){
    //     listener = onItemViewClickListener


    //создаем новый холдер и передаем в него item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentViewHolder {
        val holder = MainFragmentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_main_recycler_item, parent, false)
        )
        return holder;
    }


    //получаем погоду
    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) {
        holder.render(weatherData[position])
    }

    //
    override fun getItemCount() = weatherData.size


    // создадим класс свой ViewHolder
    // свою функцию render принимает в себя погоду и отображает город в его списке
    //itemView ссылка на View
// inner  для доступа к внутренним классам
    inner class MainFragmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(weather: Weather) {
            //получаем имя города
            itemView.findViewById<TextView>(R.id.mainFragmentRecyclerItemTextView).text =
                weather.city.name
            //по клику на список нужно открыть фрагмент детаилс
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    Toast.makeText(itemView.context, "РАБОТАЕТ", Toast.LENGTH_SHORT).show()

                    //  может принимать клики, пропишем это
                    listener.onItemClick(weather)
                }
            })
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "РАБОТАЕТ", Toast.LENGTH_SHORT).show()
                listener.onItemClick(weather)
            }
        }
    }
}