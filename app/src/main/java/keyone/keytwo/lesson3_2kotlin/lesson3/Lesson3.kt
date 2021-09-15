package keyone.keytwo.lesson3_2kotlin.lesson3

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Lesson3 {

    fun mainFirstPart() {

        val bar = AppCompatActivity().getSupportActionBar()
        val menu = AppCompatActivity().menuInflater
        val appNotNullable: Application = AppCompatActivity().application
        val appNullable: Application? = AppCompatActivity().application


        //_____-----------
        var notNullable: String = ""

        //val testObg:Test? = if (Random(2).nextInt()>0) Test() else null

        // сделали объект тест nullable типа
        // если testObg? null, то все выражение null
        val testObg: Test? = Test()
        var nullable: String? = ""


        // проверка nullable или notNullable
        // оператор элвиса ?:
        notNullable = testObg?.stringTest ?: ""
        // или полная версия
        notNullable = if (testObg?.stringTest != null) {
            testObg.stringTest
        } else {
            ""
        }

        // nullpointerexception выстрелим в ногу, укажем явно, но так лучше не делать, что-бы самому не
        // отслеживать
        notNullable = testObg!!.stringTest


        //или полная версия
        nullable = null

        if (nullable !== null) {
            nullable!!
        }

        if (nullable !== null) {

        }
        //------------------------------------------
        // массивы
        // массивы создаем через arrayOf()
        fun mainSecondPart() {
            val phrase: Array<String> = arrayOf("какоето, значение")
            // получаем фразы по индексу
            val word = phrase[1]
            // присваиваем значение
            phrase[1] = "другое"

            // размер присвоить
            val size = phrase.size

            //-------------------------------
            // коллекции
            // Mutable коллекции для изменений
            // создадим список
            // mutableList изменяемый
            class Person(val name: String, var age: Int)
// хочет var age: сделать String
            val people: List<Person> = listOf(Person("Макс", "27"), Person("Оля", "25"))
            //
            people.[0].age = 26

            // добавить people изменяемый MutableList исп функцию toMutableList()
            val peopleHack:MutableList<Person> = people.toMutableList()
            // добавляем нового
            peopleHack.add(Person("Новый","0"))

            //переменная для
            var myInt:Int = 2
            Log.d("myLogs","${myInt.mySguare()}")
        }

        //---------------------------
        //своя экстеншен функция для инт
        fun Int.mySguare():Int{
            return this*this;
        }
    }

}
// есть объект тест
class Test{
    val stringTest: String = "test"
}