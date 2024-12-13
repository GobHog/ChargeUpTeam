package com.example.chargeup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkoutFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Здесь можно инициализировать данные или выполнить действия, не связанные с UI
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Инфлейт разметки фрагмента
        val view = inflater.inflate(R.layout.fragment_workout, container, false)

        // Найти RecyclerView в разметке
        recyclerView = view.findViewById(R.id.recyclerView)

        // Настроить LayoutManager для вертикального списка
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Создать список данных
        val items = listOf(
            WorkoutItem("Сила", R.drawable.but_power),
            WorkoutItem("Растяжка", R.drawable.but_stretching),
            WorkoutItem("Выносливость", R.drawable.but_stamina)
        )

        // Настроить адаптер и привязать его к RecyclerView
        recyclerView.adapter = WorkoutAdapter(items) { item ->
            Toast.makeText(requireContext(), "Вы выбрали: ${item.text}", Toast.LENGTH_SHORT).show()
        }

        return view
    }


    companion object {
        // Фабричный метод для создания нового экземпляра фрагмента
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}