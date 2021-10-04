package keyone.keytwo.lesson3_2kotlin.repository

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import keyone.keytwo.lesson3_2kotlin.view.details.DetailsFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread


// оболочка вокруг функции WeatherLoader
class WeatherLoader(val listener: DetailsFragment, val lat:Double, val lon:Double) {
    fun loadWeather(){
        //спарсим строку в адрес чего-то в сети
        val url = URL("https://api.weather.yandex.ru/v2/informers?=lat${lat}&lon${lon}")


        //вынесем вспомогательный поток
// в главном потоке нельзя делать запрос в интернет
        Thread {
            // создадим коннекшен
            // get метод получения данных
            val urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.requestMethod = "GET"
            //передадим ключ
            urlConnection.addRequestProperty("X-Yandex-API-Key", "251c6f68-f542-4f2b-9ca6-bf0c60e05147")
            //таймаут ответ в течении 10 сек
            urlConnection.readTimeout = 10000
            // ответ, создаем входящий поток на основе коннекта
            //вынесем вспомогательный поток
            val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
            val weatherDTO = Gson().fromJson(reader,WeatherDTO::class.java)
            //val reader нужно распарсить
            val handler = Handler(Looper.getMainLooper())
            handler.post { listener.onLoaded(weatherDTO) }
            urlConnection.disconnect()
        }.start()
    }
//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun getLines(reader: BufferedReader): String {
//        return reader.lines().collect(Collectors.joining("\n"))
//    }

}