package com.example.learnkotlin.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
  private var retrofit: Retrofit? = null
  val apiService: GitHubService
    get() {
      if (retrofit == null) {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
      }
      return retrofit!!.create(GitHubService::class.java)
    }
}