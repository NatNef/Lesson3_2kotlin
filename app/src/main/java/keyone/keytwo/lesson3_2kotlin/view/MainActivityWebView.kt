package keyone.keytwo.lesson3_2kotlin.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import keyone.keytwo.lesson3_2kotlin.R
import keyone.keytwo.lesson3_2kotlin.databinding.ActivityMainBinding
import keyone.keytwo.lesson3_2kotlin.lesson4.LambdaJava
import keyone.keytwo.lesson3_2kotlin.lesson4.LambdaKotlin
import keyone.keytwo.lesson3_2kotlin.lesson4.MyExtension
import keyone.keytwo.lesson3_2kotlin.lesson4.main
import keyone.keytwo.lesson3_2kotlin.view.main.MainFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLClassLoader
import java.net.URLConnection
import java.nio.Buffer
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread


class MainActivityWebView : AppCompatActivity() {

    //      урок 5. Выход в инет
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if (savedInstanceState == null)
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, MainFragment.newInstance()).commit()

        val str = "http://gb.ru"
        binding.editText.setText(str)

        // вызовем урл
        binding.okAppCompatButton.setOnClickListener {
            showUrl(binding.editText.text.toString())
        }


        //--------------------------------------------------------------------
        //урок4
/* override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

     //вызываем MainFragment
     if (savedInstanceState == null)// при повороте сохраняет
         supportFragmentManager.beginTransaction()
             .replace(R.id.fragment_container, MainFragment.newInstance()).commit() */


//--------------------------------------
        // урок 3 массивы
//        val lesson = Lesson3()
//        lesson.mainFirstPart(this)

        // не можем создать новый объект класса AppState
        //var appState: AppState = AppState()
//----------------------------------------------------
        // урок 4. Лямбда
        // вызовем
//  LambdaJava.main()
        // LambdaKotlin().main()
        // MyExtension().main()
        //   main()
        //---------------------------------------------
    }

    //________________________________________
    // урок 5
    // в главном потоке нельзя делать запрос в интернет

    @RequiresApi(Build.VERSION_CODES.N)
    fun showUrl(urlString: String) {

        //спарсим строку в адрес чего-то в сети
        val url = URL(urlString)

        // 2 вариант val handler = Handler() // получаем указатель, на текущий поток
        // 2 вариант val handler = Handler(Looper.myLooper()!!) // получаем указатель, на текущий поток


        //вынесем вспомогательный поток
// в главном потоке нельзя делать запрос в интернет
        thread {
            // открыли коннекшен тпо ссылке, привели к httpConnection
            // get метод получения данных
            val urlConnection = url.openConnection() as HttpsURLConnection
            //запрос указали точный
            urlConnection.requestMethod = "GET"
            //таймаут ответ в течении 10 сек
            urlConnection.readTimeout = 10000
            // ответ, создаем входящий поток на основе коннекта
            //вынесем вспомогательный поток
            // буфер считали
            val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
            //все строки потоком, нужно объединить в одно
// результат+функция+ то что пришло в реадер
            // объединить строки
            val result = getLines(reader)

            // вынесем в главный поток часть кода

            // 1 вариант
            //  runOnUiThread({
            // вызов webView, загрузить, отобразить
            //   binding.webView.loadData(result,"text/html; charset=utf-8","utf-8")

            // 2 вариант
            //handler.post { binding.webView.loadData(result,"text/html; charset=utf-8","utf-8") }

            // 3 вариант
            val handler = Handler(Looper.getMainLooper())
            handler.post {
//                //binding.webView.loadData(result,"text/html; charset=utf-8","utf-8")
                // вывели строки
                binding.webView.loadDataWithBaseURL(null,result,"text/html; charset=utf-8","utf-8",null)

        }
        // выключаем
        urlConnection.disconnect()

        }.start()
    }

    // функция объединения строк
    // на вход набор и склеиваем
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }
}