package keyone.keytwo.lesson3_2kotlin.lesson4

import android.util.Log

// для инициалиации переменных delegate


// by lazy как оболочка поверх делигирования
val word by lazy{
    Log.d("mylogs", "word by lazy")
    "word"
}





// вызовем
fun main() {
    val baseImpl = BaseImpl()
    val delegate = Delegate(baseImpl,baseImpl);
    //delegate.funBase1();
    //delegate.funBase2();
    //Log.d("mylogs", delegate.nameBase1)
    //Log.d("mylogs", delegate.nameBase2)
    Log.d("mylogs",word )
}


// поведение в классе
//переиспользует класс
class Delegate(base1: Base1, base2: Base2):Base1 by base1, Base2 by base2  {
}

// есть класс, который имплеметирует поведение интерфейса
class BaseImpl:Base1, Base2{
    override fun funBase1() {
        Log.d("mylogs", "funBase1_d")
    }

    override val nameBase1 = "nameBase1_d"

    override fun funBase2() {
        Log.d("mylogs", "funBase2_d")
    }
    override val nameBase2 = "nameBase2_d"
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