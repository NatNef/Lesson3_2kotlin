package keyone.keytwo.lesson3_2kotlin.lesson3

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Lesson3 {

    fun  mainFirstPart(){

        val bar = AppCompatActivity().getSupportActionBar()
        val menu = AppCompatActivity().menuInflater
        val  appNotNullable: Application = AppCompatActivity().application
        val  appNullable: Application? = AppCompatActivity().application


        //_____-----------
        var notNullable:String = ""

        //val testObg:Test? = if (Random(2).nextInt()>0) Test() else null

        // сделали объект тест nullable типа
        // если testObg? null, то все выражение null
        val testObg:Test? = Test()
        var nullable:String? = ""


       // проверка nullable или notNullable
        // оператор элвиса ?:
        notNullable = testObg?.stringTest ?: ""
        // или полная версия
        notNullable = if (testObg?.stringTest!=null){testObg.stringTest}else{ ""}

        // nullpointerexception выстрелим в ногу, укажем явно, но так лучше не делать, что-бы самому не
        // отслеживать
        notNullable = testObg!!.stringTest


        //или полная версия
        nullable = null
        
        if (nullable!==null){
            nullable!!
        }

        if (nullable!==null){

        }
//------------------------------------------
        // коллекции и массивы
        //
    fun mainSecondPart(){

    }



    }

}
// есть объект тест
class Test{
    val stringTest: String = "test"
}