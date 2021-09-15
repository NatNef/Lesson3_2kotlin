package keyone.keytwo.lesson3_2kotlin.repository

import keyone.keytwo.lesson3_2kotlin.domain.Weather
import keyone.keytwo.lesson3_2kotlin.domain.getRussianCities
import keyone.keytwo.lesson3_2kotlin.domain.getWorldCities


// реализация Repository

class RepositoryImplement:Repository {
    override fun getWeatherFromRemoteSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalSource(): Weather {
        return Weather()
    }

    //  урок 3
    // имплементируем, возвращаем значение города
    override fun getWeatherFromLocalStorageRus(): List<Weather> {
        return getRussianCities()
    }

    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
        return getWorldCities()
    }

}