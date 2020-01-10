package ir.km.batman.views.activities

import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import ir.km.batman.R
import ir.km.batman.app.GlideApp
import ir.km.batman.base.BaseActivity
import ir.km.batman.databinding.ActivityMovieDetailBinding
import ir.km.batman.models.MoviesListModel
import ir.km.batman.viewModel.MovieDetailViewModel
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity<MovieDetailViewModel , ActivityMovieDetailBinding>() {


    var moviesListModel:MoviesListModel? = null

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
        viewModel.movieDetailsLiveData.observe(this , Observer {
            Log.i("movie" ,it.poster)

        })
    }

    override fun initBinding() {
        binding.apply {
            vm = viewModel
            moviesListModel= binding.vm?.getExtra(intent.getSerializableExtra("MovieListModel")as? MoviesListModel)
                Glide.with(this@MovieDetailActivity)
                    .load(moviesListModel?.poster)
                    .into(imgAvatarDetail)
            lifecycleOwner = this@MovieDetailActivity
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_movie_detail


}
