package com.ulza.iwanttoridemyrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_cardview_hero.view.*

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview_hero, viewGroup, false)
        return CardViewViewHolder(view)
    }
    override fun getItemCount(): Int = listHero.size
    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)
                tv_item_name.text = hero.name
                tv_item_description.text = hero.description
                btn_set_favorite.setOnClickListener { Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT).show() }
                btn_set_share.setOnClickListener { Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT).show() }
                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}