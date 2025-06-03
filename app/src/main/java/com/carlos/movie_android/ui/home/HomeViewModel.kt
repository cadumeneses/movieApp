package com.carlos.movie_android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlos.movie_android.models.MovieModel
import com.carlos.movie_android.repositories.MovieRepository

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieModel>>()
    val movies: LiveData<List<MovieModel>> = _movies

    init {
        loadMovies()
    }

    private fun loadMovies() {
        _movies.value = repository.getMovies()
    }
}