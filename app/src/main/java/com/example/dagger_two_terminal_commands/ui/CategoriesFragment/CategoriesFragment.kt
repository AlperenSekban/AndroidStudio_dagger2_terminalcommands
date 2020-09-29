package com.example.dagger_two_terminal_commands.ui.CategoriesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dagger_two_terminal_commands.R
import com.example.dagger_two_terminal_commands.adapters.AdapterOnClick
import com.example.dagger_two_terminal_commands.adapters.CategoriesAdapter
import com.example.dagger_two_terminal_commands.models.CategoriesModel
import kotlinx.android.synthetic.main.fragment_categories.view.*
import javax.inject.Inject

class CategoriesFragment @Inject constructor() : Fragment(), CategoriesContract.View,AdapterOnClick {

    var categorylist: List<CategoriesModel> = ArrayList<CategoriesModel>()
    private lateinit var categoriesAdapter: CategoriesAdapter

    @Inject
    lateinit var mPresenter: CategoriesPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        this.mPresenter.setView(this, view)
        this.mPresenter.created()

        return view
    }

    override fun setAdapter(response: List<CategoriesModel>, viewObject: View) {
        categoriesAdapter = CategoriesAdapter(requireContext(), response, this@CategoriesFragment)
        viewObject.fragment_categories_recyclerview.layoutManager =
            GridLayoutManager(requireContext(), 3)
        viewObject.fragment_categories_recyclerview.adapter = categoriesAdapter
    }

    override fun onClick(position: Int) {
        TODO("Not yet implemented")
    }
}