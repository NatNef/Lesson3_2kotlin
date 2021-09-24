package keyone.keytwo.lesson3_2kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import keyone.keytwo.lesson3_2kotlin.R
import keyone.keytwo.lesson3_2kotlin.lesson4.LambdaJava
import keyone.keytwo.lesson3_2kotlin.lesson4.LambdaKotlin
import keyone.keytwo.lesson3_2kotlin.lesson4.MyExtension
import keyone.keytwo.lesson3_2kotlin.lesson4.main
import keyone.keytwo.lesson3_2kotlin.view.main.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //вызываем MainFragment
        if (savedInstanceState == null)// при повороте сохраняет
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance()).commit()



//--------------------------------------
    // урок 3 массивы
//        val lesson = Lesson3()
//        lesson.mainFirstPart(this)

    // не можем создать новый объект класса AppState
    //var appState: AppState = AppState()

//----------------------------------------------------
    // урок 4. Лямбда

    // вызовем
    LambdaJava.main()

       // LambdaKotlin().main()
       // MyExtension().main()
        main()
}
}