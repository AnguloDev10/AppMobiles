package com.example.appnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_joke.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        btJoke.setOnClickListener {
            loadJoke()
        }
    }
    fun loadJoke() {
        //tvJoke.text="Chiste"
        val retrot = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jokeservice :JokeService
         jokeservice = retrot.create(JokeService::class.java)
        val request =jokeservice.getJoke("json")
        request.enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if(response.isSuccessful){
                    tvJoke.text= response.body()!!.Joke
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.d("jokeActvity", t.toString())
            }

        })
    }
}