package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.remote.BASE_URL
import com.syntax_institut.whatssyntax.databinding.ItemCallBinding
import com.syntax_institut.whatssyntax.model.Calls

class CallAdapter (
    private val dataset: List<Calls>,
    private val viewModel: MainViewModel

    ): RecyclerView.Adapter<CallAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemCallBinding) : RecyclerView.ViewHolder (binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallAdapter.ItemViewHolder {
        val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CallAdapter.ItemViewHolder, position: Int) {
        val call = dataset[position]
        val binding = holder.binding

        binding.tvCallName.text = call.contact.name
        binding.tvCallTime.text = call.time

        val imageUrl = BASE_URL + call.contact.image
        binding.tvCallContactImage.load(imageUrl)

        if (call.incoming) {
            if (call.accepted) {
                binding.ivCallStatus.setImageResource(R.drawable.icon_call_accepted)
                binding.ivCallStatus.scaleX = -1F
                binding.ivCallStatus.scaleY = -1F
            } else {
                binding.ivCallStatus.setImageResource(R.drawable.icon_call_missed)
                binding.ivCallStatus.scaleX = -1F
                binding.ivCallStatus.scaleY = -1F
            }
        } else {
            if (call.accepted) {
                binding.ivCallStatus.setImageResource(R.drawable.icon_call_accepted)
            } else {
                binding.ivCallStatus.setImageResource(R.drawable.icon_call_missed)
            }
        }

    }

    override fun getItemCount(): Int {
       return dataset.size
    }
}