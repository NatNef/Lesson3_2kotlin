package keyone.keytwo.lesson3_2kotlin.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import keyone.keytwo.lesson3_2kotlin.databinding.FragmentDetailsBinding
import keyone.keytwo.lesson3_2kotlin.databinding.FragmentMainBinding
import keyone.keytwo.lesson3_2kotlin.domain.Weather
import keyone.keytwo.lesson3_2kotlin.viewmodel.AppState
import keyone.keytwo.lesson3_2kotlin.viewmodel.MainViewModel


//сохранили код MainFragment 2 урока

class DetailsFragment:Fragment() {

    // представление файла fragment_main.xml в виде кода
 //   private lateinit var binding: FragmentMainBinding // FIXME утечка памяти

   // private var _binding: FragmentMainBinding? = null
    private var _binding: FragmentDetailsBinding? = null
    private val binding:FragmentDetailsBinding
    get(){
        return _binding!!
    }

    //---------------------------------------------
    // реализуем, создаем viewmodel, ссылку на него
    //lateinit реализовать ссылку чуть позже

//private lateinit var viewModel: MainViewModel



//---------------------------------------------
    // резервация, прописываем фрагмент
    companion object {
    //        fun newInstance():Fragment{
//            return MainFragment()
//       }
    // или сократим запись если возвращаем
    fun newInstance(bundle: Bundle): DetailsFragment {
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        return fragment
    }

    //ключ
    const val BUNDLE_WEATHER_KEY = "key"
}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //1 инфлейтим макет
       // return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        //binding.TextView.text = "kakoito tekst"
        return binding.root
    }

    // 2 все остальное
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //достать из аргументов погоду и передать ее в setData
//        val weather = (arguments?.getParcelable<Weather>(BUNDLE_WEATHER_KEY)) ?: Weather()
//        setData(weather)
        // сократим
        arguments?.let{
            val weather = (it?.getParcelable<Weather>(BUNDLE_WEATHER_KEY)) ?: Weather()
            setData(weather)
        }



//        // ---------------------
//        //2 урок
////        super.onViewCreated(view, savedInstanceState)
////        //ViewModelProvider жанглирует моделями и переживают смерть MainFragment
////        //сохраняет состояние View
////        // создаем ссылку на  viewModel
////        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
////
////        //обработчикБ передаем viewLifecycleOwner
////        // передаем наши состояния приложения ( до этого была заглушка Observer<Any>
////        // подписываемся на viewModel обновления через getLiveData()
////        // вешаем обработчик на viewModel
////        viewModel.getLiveData().observe(viewLifecycleOwner,Observer<AppState>{appState:AppState->
////           // Toast.makeText(context,"its work", Toast.LENGTH_LONG).show()
////            renderData(appState)
////        })
////
////        //вызываем запрос на сервер
////        viewModel.getDataFromRemoteSource()
////        //-----------------------------
//
//    }
//
//    // функции делаем видимыми
//    // выводим ошибку
//    private fun renderData(appState: AppState){
//        when(appState){
//            is AppState.Error -> {
//                binding.loadingLayout.visibility = View.GONE
//
//                val throwable = appState.error
//
//                Snackbar.make(binding.mainView, "Error $throwable", Snackbar.LENGTH_LONG).show()
//            }
//
//            // делаем видимым прогресс бар призагрузке
//            // добавляем сообщение, когда нет значенний
//            // прописываем значения
//            AppState.Loading -> {
//                binding.loadingLayout.visibility = View.VISIBLE
//               // binding.message.text = ""
//
//            }
//            // при удаче делаем прогресс бар Не видимым
//            // добавляем сообщение, когда нет значенний
//            // прописываем значения
//            // добавляем Snackbar окошко снизу для ответа
//            is AppState.Success -> {
//                binding.loadingLayout.visibility = View.GONE
//                val weather = appState.weatherData
//               // binding.message.text = "Готово"
//                setData(weather)
//                Snackbar.make(binding.mainView, "Success", Snackbar.LENGTH_LONG).show()
//            }
//          //  is AppState.Error2 -> TODO()
//        }
//

    }
    // прописываем выводим значенния
    private fun setData(weather: Weather) {
//        binding.cityName.text = weather.city.name
//        binding.cityCoordinates.text = "lat ${weather.city.lat}\n lon ${weather.city.lon}"
//        binding.temperatureValue.text = weather.temperature.toString()
//        binding.feelsLikeLabel.text =  weather.feelsLike.toString()
       // binding.feelsLikeLabel.text = "${weather.feelsLike}"

        // сократим
        with(binding) {
            with(weather){
                cityName.text = city.name
                cityCoordinates.text = "lat ${city.lat}\n lon ${city.lon}"
                temperatureValue.text = temperature.toString()
                feelsLikeLabel.text =  feelsLike.toString()
            }
        }
    }



    //_________________________________

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


    }




