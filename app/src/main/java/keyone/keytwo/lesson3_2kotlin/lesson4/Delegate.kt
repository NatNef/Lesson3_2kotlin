package keyone.keytwo.lesson3_2kotlin.lesson4

import android.util.Log

//
val word by lazy{
    Log.d("mylogs", "word by lazy")
    "word"
}





// вызовем
fun main() {
    val baseImpl = BaseImpl()
    val delegate = Delegate(baseImpl,baseImpl);
    delegate.funBase1();
    delegate.funBase2();
    Log.d("mylogs", delegate.nameBase1)
    Log.d("mylogs", delegate.nameBase2)
}


// поведение в классе
class Delegate(base1: Base1, base2: Base2):Base1 by base1, Base2 by base2  {
}

// есть класс, который имплеметирует поведение интерфейса
class BaseImpl:Base1, Base2{
    override fun funBase1() {
        Log.d("mylogs", "funBase1")
    }

    override val nameBase1 = "nameBase1"

    override fun funBase2() {
        Log.d("mylogs", "funBase2")
    }
    override val nameBase2 = "nameBase2"
}


// интерфейс

interface Base1{
    fun funBase1()
    val nameBase1:String
}

interface Base2{
    fun funBase2()
    val nameBase2:String
}