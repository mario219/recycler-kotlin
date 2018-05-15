package com.example.mario219.proof_recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.linear_layout.view.*

/**
 *
 *  Created by mario219 on 4/23/18.
 */

class CustomAdapter(val userList: ArrayList<User>, val listener: (User) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(), SwipeAdapter {

    /**
     * SwipeAdapter interface implementation
     */
    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                //Collections.swap(mItems, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                //Collections.swap(mItems, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        userList.removeAt(position)
        notifyItemRemoved(position)
    }

    /**
     *  Contracted form
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.linear_layout))

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(userList[position], listener)

    /**
     *  ViewHolder Class
     */
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: User, listener: (User) -> Unit) = with(itemView) {
            tvName.text = item.name
            tvAddress.text = item.address
            itemView.setOnClickListener { listener(item) }
        }
    }

    /**
     *  Extension function in Kotlin to override the inflater in onCreateViewHolder method
     */
    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

}

