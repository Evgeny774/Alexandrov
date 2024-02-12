package com.example.myapplication3.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.MAIN
import com.example.myapplication3.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var mBinding: FragmentMainBinding ?= null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        try {
            viewModel.getMoviesRetrofit()
            viewModel.myMovies.observe(viewLifecycleOwner, {list ->
                adapter.setList(list.body()!!.films)
            })
        }catch (e: Exception){
            Toast.makeText(MAIN, e.message, Toast.LENGTH_SHORT).show()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}
