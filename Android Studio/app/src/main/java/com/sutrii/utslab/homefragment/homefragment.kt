package com.sutrii.utslab.homefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sutrii.utslab.R
import com.sutrii.utslab.adapter.ButtonAdapter
import com.sutrii.utslab.adapter.CategoryAdapter
import com.sutrii.utslab.data.DataButton
import com.sutrii.utslab.data.DataCategory

private lateinit var recyclerViewButtons: RecyclerView
private lateinit var recyclerViewCategories: RecyclerView
private lateinit var adapter: ButtonAdapter
private lateinit var categoryAdapter: CategoryAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homefragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_homefragment, container, false)

        // Sample data for the first RecyclerView
        val items = listOf(
            DataButton("Loose Weight", R.color.black, R.color.grey),
            DataButton("Gain Weight", R.color.black, R.color.grey),
            DataButton("Body Building", R.color.black, R.color.grey),
            DataButton("Healthy", R.color.black, R.color.grey)
        )
        recyclerViewButtons = view.findViewById(R.id.recycler_buttons)
        adapter = ButtonAdapter(items) {selectedItem -> }
        recyclerViewButtons.adapter = adapter
        recyclerViewButtons.layoutManager = LinearLayoutManager(activity, LinearLayoutManager. HORIZONTAL, false)

        // Sample data for the second RecyclerView
        val categoryItems = listOf(
            DataCategory(R.drawable.category_yoga,"Yoga"),
            DataCategory(R.drawable.category_gym,"Gym"),
            DataCategory(R.drawable.category_cardio,"Cardio"),
            DataCategory(R.drawable.category_stretch,"Stretch"),
            DataCategory(R.drawable.category_fullbody,"Full Body"),
        )
        recyclerViewCategories = view.findViewById(R.id.recycler_category)
        categoryAdapter = CategoryAdapter(categoryItems)
        recyclerViewCategories.adapter = categoryAdapter
        recyclerViewCategories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment homefragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            homefragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}