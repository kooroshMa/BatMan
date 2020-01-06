package ir.km.batman

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import ir.km.batman.databinding.ActivityMainBinding
import ir.km.batman.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun configEvents() {
    }

    override fun bindObservables() {
        viewModel.moviesLiveData.observe(this, Observer {
        })
    }

    override fun initBinding() {
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        //sample_text.text = stringFromJNI()
    }


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
