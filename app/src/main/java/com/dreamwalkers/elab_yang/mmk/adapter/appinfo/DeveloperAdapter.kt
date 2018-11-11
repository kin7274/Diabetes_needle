package com.dreamwalkers.elab_yang.mmk.adapter.appinfo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class DeveloperAdapter(val context: Context, private val developerList: ArrayList<String>) : RecyclerView.Adapter<DeveloperAdapter.DeveloperViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DeveloperViewHolder {

    }

    override fun getItemCount(): Int {
        return developerList.size
    }

    override fun onBindViewHolder(p0: DeveloperViewHolder, p1: Int) {

    }

    inner class DeveloperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}