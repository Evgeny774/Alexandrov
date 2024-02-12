package com.example.myapplication3.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.R
import com.example.myapplication3.databinding.FragmentDetailBinding
import com.example.myapplication3.databinding.FragmentFavoriteBinding
import com.example.myapplication3.screens.favorite.FavoriteFragmentViewModel
import com.example.myapplication3.screens.main.MainAdapter

class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}