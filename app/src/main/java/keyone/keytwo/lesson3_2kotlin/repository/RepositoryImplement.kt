package keyone.keytwo.lesson3_2kotlin.repository

import keyone.keytwo.lesson3_2kotlin.domain.Weather
import keyone.keytwo.lesson3_2kotlin.domain.getRussianCities
import keyone.keytwo.lesson3_2kotlin.domain.getWorldCities


// реализация Repository

class RepositoryImplement:Repository {
//    override fun getWeatherFromRemoteSource(): Weather {
//        return Weather()
    // или упростим код
    override fun getWeatherFromRemoteSource() = Weather ()

//    override fun getWeatherFromLocalSource(): Weather {
//        return Weather()
        // упростим код
        override fun getWeatherFromLocalSource() = Weather ()

    //  урок 3
    // имплементируем, возвращаем значение города
//    override fun getWeatherFromLocalStorageRus(): List<Weather> {
//        return getRussianCities()
        // упростим код
        override fun getWeatherFromLocalStorageRus()=getRussianCities()


//    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
//        return getWorldCities()
        // упростим код
        override fun getWeatherFromLocalStorageWorld() = getWorldCities()


}