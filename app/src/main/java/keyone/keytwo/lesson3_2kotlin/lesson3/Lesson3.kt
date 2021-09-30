package keyone.keytwo.lesson3_2kotlin.lesson3

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import keyone.keytwo.lesson3_2kotlin.view.MainActivityWebView


class Lesson3 {

    fun mainFirstPart(mainActivity: MainActivityWebView) {

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
    }

    //------------------------------------------
    // массивы
    // массивы создаем через arrayOf()
    fun mainSecondPart(context: Context) {
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
        //class Person(val name: String, var age: Int)
// хочет var age: сделать String
        val people: List<Person> = listOf(Person("Макс", 5), Person("Оля", 25))
        //
        people[0].age = 26

        // добавить people изменяемый MutableList исп функцию toMutableList()
        val peopleHack: MutableList<Person> = people.toMutableList()
        // добавляем нового
        peopleHack.add(Person("Новый", 0))

        //переменная для
        var myInt: Int = 2
        Log.d("myLogs", "${myInt.mySguare()} $myInt")
        // простое форматирование строк

        //-------------------------------------------
        //выводим значение
        write(1);
        write(1.0);
        write("");
        write(1f);
        write(people[0]);

        //или
        writeInt(1);
        writeDouble(1.0);
        writeString("");
        writeFloat(1f);
        writePerson(people[0]);

        //проверка
        val btn = Button(context)
        val layout = LinearLayout(context)
        val view1 = Generic2(layout)


    //---------------------------
    //создать свою экстеншен функцию для инт
        // экстеншен функция дает доступ к private полям
    fun Int.mySguare(): Int {
        return this * this;
    }
}

    private fun Int.mySguare() {
    }


    // есть объект тест
    class Test {
        val stringTest: String = "test"
    }
        //------------------------------------
        //дженерики
    //обобщение
    // какие классы принимают дженерики
        class Generic<Type1>(val field1:Type1)

    //класс, который принимает в себя любые типы, но наследуется только от ViewGroup
    class Generic2<T:ViewGroup>(val field1:T)

    //class Generic<Type1,Type2>(val field1:Type1,val field2:Type2)


    //дженерики
    //нужно вывезти значени в стоку
    //значение любого типа
    data class Person(val name: String, var age: Int)

    private fun writeInt(input: Int) = Log.d("myLogs", input.toString())
    private fun writeDouble(input: Double) = Log.d("myLogs", input.toString())
    private fun writeString(input: String) = Log.d("myLogs", input.toString())
    private fun writeFloat(input: Float) = Log.d("myLogs", input.toString())
    private fun writePerson(input: Person) = Log.d("myLogs", input.toString())

    // можно заменить
    // вызвать у любого типа <Type> стринг
    fun <Type> write(input: Type) = Log.d("myLogs", input.toString())
    fun <T, R, J> write(input1: T, input2: R, input3: J) = Log.d("myLogs", input1.toString())


    // ______________________________
    // интерфейс
    interface Test3 {
        //св-ва без реализации
        val string: String

        // функция с реализацией
        fun withImpl(): String {
            //что-то происходит
            return ""
        }
        fun withoutImpl(): String
    }

}

