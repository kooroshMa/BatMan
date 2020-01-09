package ir.km.batman.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import ir.km.batman.models.MoviesListModel
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    val binding by lazy { DataBindingUtil.setContentView(this, getLayoutRes()) as DB }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModel())

        initBinding()
        configEvents()
        bindObservables()

    }

    protected abstract fun getViewModel(): Class<VM>

    abstract fun configEvents()

    abstract fun bindObservables()

    /**
     *
     *  You need override this method.
     *  And you need to set viewModel to binding: binding.viewModel = viewModel
     *
     */
    abstract fun initBinding()

    @LayoutRes
    abstract fun getLayoutRes(): Int

}