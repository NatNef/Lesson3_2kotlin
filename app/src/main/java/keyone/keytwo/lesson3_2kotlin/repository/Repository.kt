package keyone.keytwo.lesson3_2kotlin.repository

import keyone.keytwo.lesson3_2kotlin.domain.Weather

interface Repository {
    fun getWeatherFromRemoteSource():Weather
    fun getWeatherFromLocalSource():Weather
}