package com.example.myapplication3.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication3.R
import com.example.myapplication3.models.Film

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var listMovies = emptyList<Film>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_title)
        val date: TextView = view.findViewById(R.id.item_date)
        val img: ImageView = view.findViewById(R.id.item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = listMovies[position].nameRu
        holder.date.text = listMovies[position].year

        Glide.with(holder.itemView.context)
            .load(listMovies[position].posterUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<Film>){
        listMovies = list
        notifyDataSetChanged()
    }
}