package keyone.keytwo.lesson3_2kotlin.lesson4;

import android.util.Log;

public class LambdaJava {
    public static void main(){

        // Лямбды
        // удобно записывать код,
        // вызвать на месте его описания, без метода, имени
        //


        // реализация интерфейса 1 вариант
        Operation operation = new Operation() {
            @Override
            public int calculate(int x, int y) {
                return x+y;
            }
        };
        int z = operation.calculate(2,3);
        Log.d("mylogs", "z= "+z);


// или второй вариант реализации интерфейса
        //переменная функционального типа лямбда
        Operation operation2 = (x,y)->x+y;
        int z2 = operation2.calculate(2,3);
        Log.d("mylogs", "z= "+z2);
    }
}

// создадим интерфейс
interface Operation{
    int calculate(int x, int y);

    //
}
