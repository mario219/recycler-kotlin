package com.example.mario219.proof_recycler

/**
 * Created by mario219 on 5/11/18.
 *
 */

interface SwipeAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int) : Boolean
    fun onItemDismiss(position: Int)

}
