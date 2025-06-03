package com.carlos.movie_android.ui.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlos.movie_android.models.MovieModel
import com.carlos.movie_android.repositories.MovieRepository

class MovieDetailViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movie = MutableLiveData<MovieModel?>()
    val movie: LiveData<MovieModel?> = _movie

    fun loadMovieDetail(movieId: String) {
        _movie.value = repository.getMovieById(movieId)
    }
}