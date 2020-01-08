package ir.km.batman.views.activities

import ir.km.batman.R
import ir.km.batman.base.BaseActivity
import ir.km.batman.databinding.ActivityMovieDetailBinding
import ir.km.batman.viewModel.MovieDetailViewModel

class MovieDetailActivity : BaseActivity<MovieDetailViewModel , ActivityMovieDetailBinding>() {

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
    }

    override fun initBinding() {
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@MovieDetailActivity
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_movie_detail
}
