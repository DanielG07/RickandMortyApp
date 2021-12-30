package com.danielg07.rickandmorty

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.danielg07.rickandmorty.databinding.ActivityMainBinding
import com.danielg07.rickandmorty.network.RickAndMortyProperty
import com.danielg07.rickandmorty.network.RickAndMortyApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var properties: RickAndMortyProperty

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        runBlocking {
            launch {getRickAndMorty()}
        }



    }

    suspend fun getRickAndMorty(){
        Log.i("datos", RickAndMortyApi.retrofitService.getCharacter().toString())
        properties =  RickAndMortyApi.retrofitService.getCharacter()
        binding.textdad.text = properties.toString()
    }
}