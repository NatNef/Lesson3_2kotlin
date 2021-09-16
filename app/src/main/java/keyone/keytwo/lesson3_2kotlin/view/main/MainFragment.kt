package keyone.keytwo.lesson3_2kotlin.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import keyone.keytwo.lesson3_2kotlin.R
import keyone.keytwo.lesson3_2kotlin.databinding.FragmentMainBinding
import keyone.keytwo.lesson3_2kotlin.domain.Weather
import keyone.keytwo.lesson3_2kotlin.view.OnItemViewClickListener
import keyone.keytwo.lesson3_2kotlin.viewmodel.AppState
import keyone.keytwo.lesson3_2kotlin.viewmodel.MainViewModel
import ru.geekbrains.lesson_1423_2_2_main.view.main.MainFragmentAdapter



//MainFragment 2 урок называется DetailsFragment
// на 3 уроке все меняем
//OnItemViewClickListener реализует поведение

class MainFragment:Fragment(), OnItemViewClickListener {

    // представление файла fragment_main.xml в виде кода
 //   private lateinit var binding: FragmentMainBinding // FIXME утечка памяти

    private var _binding: FragmentMainBinding? = null
    private val binding:FragmentMainBinding
    get(){
        return _binding!!
    }


    // какой язык включен
    private var isDataSetRus: Boolean = true

    //реализуем адаптер
    private var adapter = MainFragmentAdapter()

    //---------------------------------------------
    // реализуем, создаем viewmodel, ссылку на него
    //lateinit реализовать ссылку чуть позже

private lateinit var viewModel: MainViewModel



//---------------------------------------------
    // резервация, прописываем фрагмент
    companion object{
//        fun newInstance():Fragment{
//            return MainFragment()
//       }
        // или сократим запись если возвращаем
        fun newInstance()= MainFragment()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //1 инфлейтим макет
       // return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        //binding.TextView.text = "kakoito tekst"
        return binding.root
    }

    // 2 все остальное
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // передаем адаптер
        binding.mainFragmentRecyclerView.adapter= adapter

        //адаптер передает себя
        //принять фрагмент, который умеет в себя принимать клики
        //listener это ссылка на возможность принимать в себя клики
        adapter.setOnItemViewClickListener(this)

        //3 урок повесить кливер на floatactionbutton
        // по клику на object будет запрос
        binding.mainFragmentFAB.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                isDataSetRus = !isDataSetRus
                //делаем запрос
                // эконка
                if(isDataSetRus){
                    viewModel.getWeatherFromLocalSourceRus()
                    ////картинка
                    binding.mainFragmentFAB.setImageResource(R.drawable.ic_russia)
                }else {
                    viewModel.getWeatherFromLocalSourceWorld()
                    binding.mainFragmentFAB.setImageResource(R.drawable.ic_earth)
                }
            }
        })

        //ViewModelProvider жанглирует моделями и переживают смерть MainFragment
        //сохраняет состояние View
        // создаем ссылку на  viewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //обработчикБ передаем viewLifecycleOwner
        // передаем наши состояния приложения ( до этого была заглушка Observer<Any>
        // подписываемся на viewModel обновления через getLiveData()
        // вешаем обработчик на viewModel
        viewModel.getLiveData().observe(viewLifecycleOwner,Observer<AppState>{appState:AppState->
           // Toast.makeText(context,"its work", Toast.LENGTH_LONG).show()
            renderData(appState)
        })

        //вызываем запрос на сервер
        //viewModel.getDataFromRemoteSource()
        viewModel.getWeatherFromLocalSourceRus()
        //-----------------------------

    }

    // функции делаем видимыми
    // выводим ошибку
    private fun renderData(appState: AppState){
        when(appState){
            is AppState.Error -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE

                val throwable = appState.error

                Snackbar.make(binding.root, "Error $throwable", Snackbar.LENGTH_LONG).show()
            }

            // делаем видимым прогресс бар призагрузке
            // добавляем сообщение, когда нет значенний
            // прописываем значения
            AppState.Loading -> {
                binding.mainFragmentLoadingLayout.visibility = View.VISIBLE
               // binding.message.text = ""

            }
            // при удаче делаем прогресс бар Не видимым
            // добавляем сообщение, когда нет значенний
            // прописываем значения
            // добавляем Snackbar окошко снизу для ответа
            is AppState.Success -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE
                val weather = appState.weatherData
               // binding.message.text = "Готово"
                adapter.setWeather(weather)
                Snackbar.make(binding.root, "Success", Snackbar.LENGTH_LONG).show()
            }
          //  is AppState.Error2 -> TODO()
        }
    }

//    // прописываем выводим значенния
//    private fun setData(weather: Weather) {
//        binding.cityName.text = weather.city.name
//        binding.cityCoordinates.text = "lat ${weather.city.lat}\n lon ${weather.city.lon}"
//        binding.temperatureValue.text = weather.temperature.toString()
//        binding.feelsLikeLabel.text =  weather.feelsLike.toString()
//       // binding.feelsLikeLabel.text = "${weather.feelsLike}"
//    }

    //_________________________________

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

    // реализует поведение OnItemViewClickListener
    // который готов в себя получать Weather
    override fun onItemClick(weather: Weather) {
        //откроем новый фрагмент
        val bundle = Bundle()
        bundle.putParcelable(DetailsFragment.BUNDLE_WEATHER_KEY,weather)
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DetailsFragment.newInstance(bundle))
            .addToBackStack("")
            .commit()

    }


}




