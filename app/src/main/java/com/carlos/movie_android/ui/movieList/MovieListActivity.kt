package com.carlos.movie_android.ui.movieList

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.movie_android.databinding.ActivityMovieListBinding
import com.carlos.movie_android.models.MovieModel
import com.carlos.movie_android.repositories.MovieRepository
import com.carlos.movie_android.ui.movieDetail.MovieDetailActivity

class MovieListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieListBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var movieAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla o layout usando View Binding
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

            viewModel = ViewModelProvider(this, MovieListViewModelFactory(MovieRepository()))[MovieListViewModel::class.java]

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        movieAdapter = MovieListAdapter { movie ->
            navigateToMovieDetail(movie)
        }
        binding.recyclerViewMovies.apply {
            layoutManager = LinearLayoutManager(this@MovieListActivity)
            adapter = movieAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.movies.observe(this) { movies ->
            movieAdapter.submitList(movies)
        }
    }

    private fun navigateToMovieDetail(movie: MovieModel) {
        val intent = Intent(this, MovieDetailActivity::class.java).apply {
            putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, movie.id)
        }
        startActivity(intent)
    }
}

class MovieListViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}