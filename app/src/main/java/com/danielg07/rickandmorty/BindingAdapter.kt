package com.danielg07.rickandmorty

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.danielg07.rickandmorty.network.Result
import com.danielg07.rickandmorty.overview.ItemListAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri)
    }
}

@BindingAdapter("name")
fun bindName(textView: TextView, name: String?){
    name?.let {
        textView.text = name
    }
}

@BindingAdapter("origin")
fun bindOrigin(textView: TextView, origin: String?){
    origin?.let {
        textView.text = origin
    }
}

@BindingAdapter("lastseen")
fun bindLastSeen(textView: TextView, lastseen: String?){
    lastseen?.let {
        textView.text = lastseen
    }
}

@BindingAdapter("status")
fun bindStatus(imageView: ImageView, status: String?){
    when(status){
        "Alive" -> {
            imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.green))
        }
        "unknown" -> {
            imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.orange))
        }
        "Dead" -> {
            imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.red))
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Result>?){
    val adapter = recyclerView.adapter as ItemListAdapter
    adapter.submitList(data)
}