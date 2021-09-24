package keyone.keytwo.lesson3_2kotlin.lesson4

import android.util.Log
import keyone.keytwo.lesson3_2kotlin.lesson4.LambdaKotlin.Person

class MyExtension {

    // with
    fun main() {
        val people: List<Person> = listOf(
            Person("name1", 10),
            Person("name2", 20)
        )

        // создадим
        people.indexOf(people[0])
        people.indexOf(people[1])
        people[0].name
        people[0].age


        // заменим на  with
        // with экстеншен фция, возвращает
        // принимает 2 арг, ресивер people объект и фцию блок withname1
        //возвращается новый объект
        val withRes = with(people) {
//                    indexOf(get(0))
//                    indexOf(get(1))
//                    get(0).name
//                    get(0).age
            //сократим
            // with изменяем name на "withname1" но не возвразает объект
            get(0).name = "withname1"
            get(1).name = "withname2"
        }
        //вызовем
        //  withRes.print2

        //applyRes.forEach {  (it.print2()) }
        //alsoRes.forEach {  (it.print2()) }

        //apply возвращает результат, который был внутри
        //в apply people передается, изменяет поля и возвращается измененниый объект
        val applyRes = people.apply {
//            indexOf(get(0))
//            indexOf(get(1))
//            get(0).name
//            get(0).age
            //сократим
            get(0).name = "applyname1"
            get(1).name = "applyname2"


            val alsoRes = people.also {
                it.get(0).name = "applyname1"
                it.get(1).name = "applyname2"
            }
        }
    }

    fun Person.print2(): String {
        Log.d("mylogs", "${this.name} ${this.age}")
        return "ретерн"


        //also меняе местами значения
        //на вход приходит сам объект
        var x = 20
        var y = 30
        x = y.also { y = x }
        //можно и так поменять
        //x = y.apply{ y=x}
        // Log.d("mylogs", "x=${x}  y=${y}")


        //let потокобезопасен
        var person: LambdaKotlin.Person? = null
        //person = LambdaKotlin.Person("no-null", 12)
        if (person != null) {
            person.print2()
        }
        //сократим
        person?.let {
            it.print2()
        }
    }
}
