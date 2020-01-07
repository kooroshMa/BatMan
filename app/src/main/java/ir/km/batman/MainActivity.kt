package ir.km.batman

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import ir.km.batman.databinding.ActivityMainBinding
import ir.km.batman.databinding.ItemMovieBinding
import ir.km.batman.models.MovieDetailsModel
import ir.km.batman.models.MoviesModel
import ir.km.batman.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
        viewModel.moviesLiveData.observe(this, Observer {
            Log.i("movie" ,it.search.toString())
            binding.adapter?.swapItems(it.search)
        })
    }

    override fun initBinding() {
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@MainActivity
            //executePendingBindings()

            adapter = SingleLayoutAdapter<MovieDetailsModel, ItemMovieBinding>(
                R.layout.item_movie,
                emptyList(),
                viewModel)
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_main



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
