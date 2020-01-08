package ir.km.batman.adapter

import androidx.databinding.ViewDataBinding
import ir.km.batman.base.BaseAdapter
import ir.km.batman.viewModel.BaseViewModel


open class SingleLayoutAdapter<T, B : ViewDataBinding>(
    private val layoutId: Int,
    items: List<T>,
    viewModel: BaseViewModel? = null,
    onBind: B.(Int) -> Unit = {}
) : BaseAdapter<T, B>(viewModel = viewModel, items = items, onBind = onBind) {

    override fun getLayoutId(position: Int): Int = layoutId
}