package keyone.keytwo.lesson3_2kotlin.repository

interface WeatherLoaderListener {
    //поведение класса, который принимает ответ weatherDTO
    //загрузить данные или нет

    fun onLoader(weatherDTO: WeatherDTO)
    fun onFailed(throwable: Throwable)
}