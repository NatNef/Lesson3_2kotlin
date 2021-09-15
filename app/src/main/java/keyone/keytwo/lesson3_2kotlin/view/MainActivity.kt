package keyone.keytwo.lesson3_2kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import keyone.keytwo.lesson3_2kotlin.R
import keyone.keytwo.lesson3_2kotlin.lesson3.Lesson3


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //вызываем MainFragment
        if(savedInstanceState==null)// при повороте сохраняет
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,MainFragment.newInstance()).commit()

//--------------------------------------
        // урок 3 массивы
        val lesson = Lesson3()
        lesson.mainFirstPart()



    }
}