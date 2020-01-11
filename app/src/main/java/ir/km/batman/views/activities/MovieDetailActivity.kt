package ir.km.batman.views.activities

import android.util.Log
import androidx.lifecycle.Observer
import ir.km.batman.R
import ir.km.batman.base.BaseActivity
import ir.km.batman.databinding.ActivityMovieDetailBinding
import ir.km.batman.models.MoviesListModel
import ir.km.batman.utils.BindingAdapter
import ir.km.batman.viewModel.MovieDetailViewModel

class MovieDetailActivity : BaseActivity<MovieDetailViewModel, ActivityMovieDetailBinding>() {


    var moviesListModel: MoviesListModel? = null

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
        viewModel.movieDetailsLiveData.observe(this, Observer {
            Log.i("movie", it.poster)

            binding.title.text = it.title
            binding.genre.text = it.genre
            binding.rating.text = it.rated
            binding.year.text = it.year
        })
    }

    override fun initBinding() {
        binding.apply {
            vm = viewModel
            moviesListModel = intent.getSerializableExtra("MovieListModel") as? MoviesListModel
            binding.vm?.getExtra(moviesListModel)


            BindingAdapter.setImageSrc(imgAvatarDetail, moviesListModel?.poster)

            lifecycleOwner = this@MovieDetailActivity
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_movie_detail


}
