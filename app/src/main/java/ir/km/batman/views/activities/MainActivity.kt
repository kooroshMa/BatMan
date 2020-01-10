package ir.km.batman.views.activities

import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import ir.km.batman.ClickHandleInterface
import ir.km.batman.R
import ir.km.batman.adapter.SingleLayoutAdapter
import ir.km.batman.base.BaseActivity
import ir.km.batman.databinding.ActivityMainBinding
import ir.km.batman.databinding.ItemMovieBinding
import ir.km.batman.models.MoviesListModel
import ir.km.batman.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
        viewModel.moviesLiveData.observe(this, Observer {
            binding.adapter?.swapItems(it.search)
        })

        viewModel.startActivityLiveData.observe(this, Observer {


            /* val imagePair = Pair.create((it.third as View), "avatar")
             val option =
                 ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity, imagePair)
             intent = Intent(this, MovieDetailActivity::class.java)
             intent.putExtra("MovieLisetModel", it.first)
             ActivityCompat.startActivity(this@MainActivity, intent, option.toBundle())*/


            //startActivity(intent)
        })
    }

    override fun initBinding() {
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@MainActivity
            //executePendingBindings()
            adapter = SingleLayoutAdapter<MoviesListModel, ItemMovieBinding>(
                R.layout.item_movie,
                emptyList(),
                viewModel,
                onBind = {
                    position = it
                },
                clickHandleInterface = object : ClickHandleInterface<MoviesListModel> {
                    override fun click(view: View, items: List<MoviesListModel> , position:Int) {
                        val imagePair = Pair.create(view, "avatar")
                        val option =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                this@MainActivity,
                                imagePair
                            )
                        intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
                        intent.putExtra("MovieListModel", items[position])
                        ActivityCompat.startActivity(this@MainActivity, intent, option.toBundle())
                    }
                }
            )
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