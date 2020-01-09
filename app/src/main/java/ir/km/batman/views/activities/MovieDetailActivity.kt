package ir.km.batman.views.activities

import android.util.Log
import androidx.lifecycle.Observer
import io.reactivex.disposables.Disposable
import ir.km.batman.R
import ir.km.batman.base.BaseActivity
import ir.km.batman.databinding.ActivityMovieDetailBinding
import ir.km.batman.models.MoviesListModel
import ir.km.batman.viewModel.MovieDetailViewModel

class MovieDetailActivity : BaseActivity<MovieDetailViewModel , ActivityMovieDetailBinding>() {

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
        viewModel.movieDetailsLiveData.observe(this , Observer {
           // Log.i("movie" ,it)

        })
    }

    override fun initBinding() {
        binding.apply {
            vm = viewModel
            //binding.vm?.getExtra(intent.getSerializableExtra("MovieLisetModel")as MoviesListModel)

            lifecycleOwner = this@MovieDetailActivity
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_movie_detail


}
