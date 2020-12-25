package com.yos.recyclerview

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    private lateinit var onItemClickCallback: GridHeroAdapter.OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: GridHeroAdapter.OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_heroes, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, p1: Int) {

        Glide.with(holder.itemView.context)
                .load(listHero[p1].photo)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data:Hero)
    }
}