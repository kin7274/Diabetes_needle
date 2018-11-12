package com.dreamwalkers.elab_yang.mmk.activity.select

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import com.dreamwalker.multiselection.MultiSelect
import com.dreamwalker.multiselection.MultiSelectBuilder
import com.dreamwalkers.elab_yang.mmk.R
import com.dreamwalkers.elab_yang.mmk.adapter.drugselect.LeftAdapter
import com.dreamwalkers.elab_yang.mmk.adapter.drugselect.RightAdapter
import com.dreamwalkers.elab_yang.mmk.model.drugselect.Track
import com.dreamwalkers.elab_yang.mmk.model.drugselect.TrackList

class SelectDrugActivity : AppCompatActivity() {

    private var mMultiSelect: MultiSelect<Track>? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_drug)

        setUpToolbar(findViewById<View>(R.id.toolbar) as Toolbar)

        val builder = MultiSelectBuilder(Track::class.java)
                .withContext(this)
                .mountOn(findViewById<View>(R.id.mount_point) as ViewGroup)
                .withSidebarWidth((46 + 8 * 2).toFloat()) // ImageView width with paddings

        setUpAdapters(builder)
        mMultiSelect = builder.build()

        setUpDecoration()
    }

    private fun setUpDecoration() {
        val itemDecorator = TracksItemDecorator(resources.getDimensionPixelSize(R.dimen.decoration_size))
        mMultiSelect!!.recyclerLeft.addItemDecoration(itemDecorator)
        mMultiSelect!!.recyclerRight.addItemDecoration(itemDecorator)
    }

    private fun setUpAdapters(builder: MultiSelectBuilder<Track>) {
        val leftAdapter = LeftAdapter { position -> mMultiSelect!!.select(position) }
        val rightAdapter = RightAdapter { position -> mMultiSelect!!.deselect(position) }

        leftAdapter.addAll(TrackList.TRACKS)

        builder.withLeftAdapter(leftAdapter)
                .withRightAdapter(rightAdapter)
    }

    private fun setUpToolbar(toolbar: Toolbar) {
        toolbar.inflateMenu(R.menu.menu)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.select) {
                val items = mMultiSelect!!.selectedItems
                val selectedCount = items!!.size
                val msg: String
                if (selectedCount == 0) {
                    msg = getString(R.string.nothing_selected)
                    mMultiSelect!!.showNotSelectedPage()
                } else {
                    msg = resources.getQuantityString(R.plurals.you_selected_x_songs, selectedCount, selectedCount)
                    mMultiSelect!!.showSelectedPage()
                }
                Snackbar.make(toolbar, msg, Snackbar.LENGTH_LONG).show()
                return@setOnMenuItemClickListener true
            } else {
                return@setOnMenuItemClickListener false
            }
        }

    }
}
