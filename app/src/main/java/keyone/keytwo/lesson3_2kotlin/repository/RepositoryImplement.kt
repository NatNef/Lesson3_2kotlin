package keyone.keytwo.lesson3_2kotlin.repository

import keyone.keytwo.lesson3_2kotlin.domain.Weather


// реализация Repository

class RepositoryImplement:Repository {
    override fun getWeatherFromRemoteSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalSource(): Weather {
        return Weather()
    }

}