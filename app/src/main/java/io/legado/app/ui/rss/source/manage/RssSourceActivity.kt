package io.legado.app.ui.rss.source.manage

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import io.legado.app.R
import io.legado.app.base.VMBaseActivity
import io.legado.app.data.entities.RssSource
import io.legado.app.help.ItemTouchCallback
import io.legado.app.lib.theme.ATH
import io.legado.app.lib.theme.primaryTextColor
import io.legado.app.utils.getViewModel
import kotlinx.android.synthetic.main.activity_rss_source.*
import kotlinx.android.synthetic.main.view_search.*


class RssSourceActivity : VMBaseActivity<RssSourceViewModel>(R.layout.activity_rss_source),
    RssSourceAdapter.CallBack {

    override val viewModel: RssSourceViewModel
        get() = getViewModel(RssSourceViewModel::class.java)

    private lateinit var adapter: RssSourceAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        initRecyclerView()
        initSearchView()
    }

    private fun initRecyclerView() {
        ATH.applyEdgeEffectColor(recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                ContextCompat.getDrawable(baseContext, R.drawable.ic_divider)?.let {
                    this.setDrawable(it)
                }
            })
        adapter = RssSourceAdapter(this, this)
        recycler_view.adapter = adapter
        val itemTouchCallback = ItemTouchCallback()
        itemTouchCallback.onItemTouchCallbackListener = adapter
        itemTouchCallback.isCanDrag = true
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(recycler_view)
    }

    private fun initSearchView() {
        ATH.setTint(search_view, primaryTextColor)
        search_view.onActionViewExpanded()
        search_view.queryHint = getString(R.string.search_book_source)
        search_view.clearFocus()
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun del(source: RssSource) {

    }

    override fun edit(source: RssSource) {

    }

    override fun update(vararg source: RssSource) {

    }

    override fun toTop(source: RssSource) {

    }

    override fun upOrder() {

    }

}