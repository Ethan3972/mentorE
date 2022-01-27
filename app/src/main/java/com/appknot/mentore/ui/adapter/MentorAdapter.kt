package com.appknot.mentore.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appknot.mentore.R
import com.appknot.mentore.databinding.ItemMentorBinding
import com.appknot.mentore.model.PageFormationData

/**
 *
 * @author Ethan on 2022-01-26
 */
class MentorAdapter: ListAdapter<PageFormationData, MentorAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<PageFormationData>() {
        override fun areItemsTheSame(oldItem: PageFormationData, newItem: PageFormationData): Boolean {
            return oldItem.pageNo == newItem.pageNo
        }

        override fun areContentsTheSame(oldItem: PageFormationData, newItem: PageFormationData): Boolean {
            return oldItem.pageNo == newItem.pageNo
        }
    }
) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bind = ItemMentorBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_mentor, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with (holder.bind) {
            pageno = currentList[position].pageNo
        }
    }
}