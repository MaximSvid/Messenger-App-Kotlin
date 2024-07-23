package com.syntax_institut.whatssyntax.adapter

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.data.remote.BASE_URL
import com.syntax_institut.whatssyntax.databinding.ItemContactBinding
import com.syntax_institut.whatssyntax.databinding.ItemNoteBinding
import com.syntax_institut.whatssyntax.databinding.ItemStatusBinding
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact
import com.syntax_institut.whatssyntax.ui.StatusFragmentDirections

class StatusAdapter (
    var dataset: List<Contact>,
    val viewModel: MainViewModel
    ): RecyclerView.Adapter<StatusAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusAdapter.ItemViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusAdapter.ItemViewHolder, position: Int) {
        dataset = dataset.sortedBy { it.status == null }
        val items = dataset[position]

        holder.binding.tvContactName.text = items.name

        val imageUrl = BASE_URL + items.image

        if (items.status == null) {
            holder.binding.ivContactImage.load(imageUrl) {
                val colorMatrix = ColorMatrix()
                colorMatrix.setSaturation(0f)
                holder.binding.ivContactImage.colorFilter = ColorMatrixColorFilter(colorMatrix)
            }
        } else {
            holder.binding.ivContactImage.load(imageUrl)
        }

        holder.binding.cvContact.setOnClickListener {
            if (items.status != null) {
                viewModel.getCurrentContact(items)

                holder.itemView.findNavController().navigate(StatusFragmentDirections.actionStatusFragmentToStatusDetailFragment())
            }
        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}