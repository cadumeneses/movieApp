package com.carlos.movie_android.ui.movieList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carlos.movie_android.databinding.MovieListItemBinding
import com.carlos.movie_android.models.MovieModel
import com.bumptech.glide.Glide


class MovieListAdapter(private val onItemClicked: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, MovieListAdapter.MovieViewHolder>(MovieDiffCallback())  {

    class MovieViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieModel, onItemClicked: (MovieModel) -> Unit) {
            binding.textViewMovieTitle.text = movie.title
            binding.textViewMovieYear.text = movie.year.toString()
            binding.textViewMovieGenre.text = movie.genre

            Glide.with(binding.imageViewMoviePoster.context)
                .load(movie.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery) // Placeholder enquanto carrega
                .error(android.R.drawable.ic_delete) // Imagem de erro se falhar
                .into(binding.imageViewMoviePoster)

            binding.root.setOnClickListener {
                onItemClicked(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie, onItemClicked)
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.id == newItem.id // Compara se são o mesmo item (pelo ID)
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }
    }
}