package keyone.keytwo.lesson3_2kotlin.viewmodel

import keyone.keytwo.lesson3_2kotlin.domain.Weather

sealed class AppState {

    // закрытый запакованный sealed class можем менять, разные конструкторы, от них можно наследоваться
    // принимает внутри любые классы любого типа, для записи много разных объектов, разные сигнатуры,классы
    //создавать разные экземпляры, объекты,

//AppState модет быто только в одном месте, в других местах мы его создать не можем
    //все его объекты доступны
    //____________________________
    // состояния нашего приложения

    // загpузка
//    class Loading:AppState() //FIXME object
//    // Fo запрещает создавать много лоэдинг
    object Loading:AppState() // состояние, оно есть и оно одно

// удача
   // data class Success(val weatherData:Weather):AppState()

    // ошибка
    data class Error(val error:Throwable):AppState()
   // data class Error2(val error:Throwable):AppState()

    //--------------------------------------
    //урок3
    // меняем Weather на listWeather
    data class Success(val weatherData:List<Weather>):AppState()
}
