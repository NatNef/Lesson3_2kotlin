package keyone.keytwo.lesson3_2kotlin.view

import keyone.keytwo.lesson3_2kotlin.domain.Weather

//создадим интерфейс, который отвечает за поведение
// что-то должно уметь принимать клики

interface OnItemViewClickListener {
    fun onItemClick(weather: Weather)
}