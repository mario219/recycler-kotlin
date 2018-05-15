package com.example.mario219.proof_recycler

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

/**
 * Created by mario219 on 5/11/18.
 *
 */

class SwipeHelper(val swipeAdapter: SwipeAdapter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        val dragFlags = 0
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags,
                                    swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean =
            swipeAdapter.onItemMove(viewHolder!!.adapterPosition, target!!.adapterPosition)

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) =
            swipeAdapter.onItemDismiss(viewHolder!!.adapterPosition)

    override fun isItemViewSwipeEnabled() = true

    override fun isLongPressDragEnabled() = true

}