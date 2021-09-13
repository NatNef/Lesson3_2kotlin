package keyone.keytwo.lesson3_2kotlin.lesson3

import android.app.Application
import androidx.appcompat.app.AppCompatActivity

class Lesson3 {

    fun  main(){

        val bar = AppCompatActivity().getSupportActionBar()
        val menu = AppCompatActivity().menuInflater
        val  appNotNullable: Application = AppCompatActivity().application
        val  appNullable: Application? = AppCompatActivity().application


        //_____-----------
        var notNullable:String = ""
        val testObg:Test? = Test()
        var nullable:String? = ""

        // оператор элвиса ?:
        notNullable = testObg?.stringTest ?: ""
        // или
        notNullable = if (testObg?.stringTest!=null){testObg?.stringTest}else{ ""}


        //или
        nullable = null
        
        if (nullable!==null){
            nullable!!
        }

        if (nullable!==null){

        }


        testObg = null

    }
}

class Test{
    val stringTest: String?
}