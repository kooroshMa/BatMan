package ir.km.batman

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ir.km.batman.viewModel.BaseViewModel

class BaseViewHolder<in T, out B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemBindingId: Int, item: T, viewModelBindingId: Int, viewModel: BaseViewModel?) {
        binding.setVariable(itemBindingId, item)
        if (viewModel != null)
            binding.setVariable(viewModelBindingId, viewModel)
        binding.executePendingBindings()
    }
}
