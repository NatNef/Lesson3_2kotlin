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


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null)
         supportFragmentManager.beginTransaction()
               .replace(R.id.fragment_container, MainFragment.newInstance()).commit()

        }

}