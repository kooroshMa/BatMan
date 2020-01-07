package ir.km.batman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.km.batman.viewModel.BaseViewModel


abstract class BaseAdapter<T, B : ViewDataBinding>(
    private var itemBindingId: Int = BR.item,
    private var viewModelBindingId: Int = BR.viewModel,
    private var viewModel: BaseViewModel?,
    var items: List<T>,
    var onBind: B.(Int) -> Unit = {}
) : RecyclerView.Adapter<BaseViewHolder<T, B>>() {

    fun getItem(position: Int): T = items[position]

    override fun getItemCount(): Int = items.size

    abstract fun getLayoutId(position: Int): Int

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: B = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.bind(itemBindingId, getItem(position), viewModelBindingId, viewModel)
        holder.binding.onBind(position)
    }

    open fun swapItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]

            override fun getOldListSize(): Int =
                items.size

            override fun getNewListSize(): Int =
                newItems.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]
        })
        diffResult.dispatchUpdatesTo(this)

        // newItems.toList() provide a new instance of list with different reference in memory
        // to prevent same instance of objects issues
        items = newItems.toList()
    }

    interface OnItemClickListener<T> {
        fun onItemClick(view: View, item: T, position: Int = -1)
    }
}