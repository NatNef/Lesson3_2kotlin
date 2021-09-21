package keyone.keytwo.lesson3_2kotlin.lesson4

import android.util.Log

class LambdaKotlin {
    fun main(){

        /*
        // лямбда исп для кода, не давая ему имени
        // не давая имени функции, запишем ее в переменную
        //переменная функционального типа
        //l1 ссылка на функцию
        val l1 = {Log.d("mylogs", "run1") // этот блок назыв лямбда
        "run2"}

        // запишем в лямбду значение
        //run код внутри, закрывает от кода снаружи, не  имеет доступа к внешним полям и обратно
        // когда в одном месте надо много методов
        //l2 результат выполнения
        val l2 = run {Log.d("mylogs", "run3")
            "run4"}

        //выведем
        Log.d("mylogs", l1())
        Log.d("mylogs", l2) */

        // вызов
        printMy(valAnonymous)
        printMy(valLambda)

        // лямбда - {пришло -> тело лямбды
        // последняя строка это возврат
        val l3 = { int1: Int, int2: Int ->
            Log.d("mylogs", " 1")
            Log.d("mylogs", " 2")
            Log.d("mylogs", " 3")
            Unit
        }
        // передаем значение
        val l4 = l3(1, 3)
    }

    // анонимная функция
    private val valAnonymous = fun (int1:Int, int2:Int):String{
        Log.d("mylogs", "Зашли в funAnonymous")
        return "funAnonymous"
    }

    //лямбда
    // нельзя указать строгий тип
    //return@hack определитель
    private val valLambda = hack@{ int1: Int, int2: Int ->
        Log.d("mylogs", " Зашли в funLambda")
        return@hack "funLambda"
    }

    // ф принимает на вход другую функцию
    private fun printMy(fun1: (int1: Int, int2: Int) -> String) {
        Log.d("mylogs", " Зашли в printMy")
        Log.d("mylogs", fun1(1, 2))
    }

    // 4 урок проверка

}