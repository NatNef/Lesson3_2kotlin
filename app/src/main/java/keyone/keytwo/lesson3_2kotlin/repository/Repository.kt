package keyone.keytwo.lesson3_2kotlin.repository

import keyone.keytwo.lesson3_2kotlin.domain.Weather


//Repository интерфейс, поведение
interface Repository {
    fun getWeatherFromRemoteSource():Weather
    fun getWeatherFromLocalSource():Weather

    //------------------
    //урок 3
    //получаем возврат значения городов по запросу
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}