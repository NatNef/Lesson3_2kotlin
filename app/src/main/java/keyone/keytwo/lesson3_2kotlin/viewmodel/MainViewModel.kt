package keyone.keytwo.lesson3_2kotlin.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import keyone.keytwo.lesson3_2kotlin.domain.Weather
import keyone.keytwo.lesson3_2kotlin.repository.Repository
import keyone.keytwo.lesson3_2kotlin.repository.RepositoryImplement
import keyone.keytwo.lesson3_2kotlin.viewmodel.AppState
import java.lang.IllegalStateException
import java.lang.Thread.sleep
import kotlin.random.Random

// это хранилище всех ViewModel

class MainViewModel(
    private val liveDataToObserve:MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImplement: RepositoryImplement = RepositoryImplement()
)
    :ViewModel() {

    // создали liveDataToObserve и будем в нее что-то добавлять

//        fun getLiveData():LiveData<Any> {
//            return liveDataToObserve;
//        }
        // сокращаем
    fun getLiveData() = liveDataToObserve;
// на liveDataToObserve будем подписывать


    // добавляем функцию, которая эмулирует запрос на сервер
    // потом /заглушки/ на состояния загрузка, удача, ошибка
    // обновлет состояние и срабатывает renderData
    // для 3 урока меняем getDataFromLocalSource делим 2 метода на true false


    //3урок делим 2 метода на true false
    fun getWeatherFromLocalSourceWorld(){
        getDataFromLocalSource(false)
    }
    fun getWeatherFromLocalSourceRus(){
        getDataFromLocalSource(true)
    }


    private fun getDataFromLocalSource(isRussian:Boolean){


        //выводим города
        liveDataToObserve.postValue(AppState.Loading)
        Thread{
            sleep(2000)
           // val r = (0..10).random()

            if (isRussian){
                liveDataToObserve.postValue(AppState.Success(repositoryImplement.getWeatherFromLocalStorageRus()))
            }

            else {
                liveDataToObserve.postValue(AppState.Success(repositoryImplement.getWeatherFromLocalStorageWorld()))
              //  liveDataToObserve.postValue(AppState.Error(IllegalStateException()))
            }

        }.start()
    }
    //-------------------------



}