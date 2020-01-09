package ir.km.batman.adapter

import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.ViewDataBinding
import ir.km.batman.ClickHandleInterface
import ir.km.batman.base.BaseAdapter
import ir.km.batman.base.BaseViewHolder
import ir.km.batman.viewModel.BaseViewModel
import ir.km.batman.views.activities.MainActivity
import ir.km.batman.views.activities.MovieDetailActivity
import kotlinx.android.synthetic.main.item_movie.view.*


open class SingleLayoutAdapter<T, B : ViewDataBinding>(
    private val layoutId: Int,
    items: List<T>,
    viewModel: BaseViewModel? = null,
    onBind: B.(Int) -> Unit = {},
    val clickHandleInterface: ClickHandleInterface
) : BaseAdapter<T, B>(viewModel = viewModel, items = items, onBind = onBind) {

    override fun getLayoutId(position: Int): Int = layoutId

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener(View.OnClickListener { clickHandleInterface.click(holder.itemView.imgAvatar) })
    }

}