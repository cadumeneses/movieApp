package com.carlos.movie_android.ui.movieDetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.carlos.movie_android.repositories.MovieRepository
import com.bumptech.glide.Glide
import com.carlos.movie_android.R
import com.carlos.movie_android.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MovieDetailViewModelFactory(MovieRepository()))[MovieDetailViewModel::class.java]

        binding.buttonBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)

        if (movieId != null) {
            viewModel.loadMovieDetail(movieId)
            observeViewModel()
        } else {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeViewModel() {
        viewModel.movie.observe(this) { movie ->
            movie?.let {
                binding.textViewDetailTitle.text = it.title
                binding.textViewDetailYear.text = "Ano: ${it.year}"
                binding.textViewDetailGenre.text = "Gênero: ${it.genre}"
                binding.textViewDetailSynopsis.text = it.synopsis

                Glide.with(this)
                    .load(it.imageUrl)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_delete)
                    .into(binding.imageViewDetailPoster)

                supportActionBar?.title = it.title
            } ?: run {
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

class MovieDetailViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}