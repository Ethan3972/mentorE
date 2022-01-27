package com.appknot.mentore.viewmodel

import android.util.Log
import com.appknot.mentore.model.PageFormationData
import com.appknot.mentore.ui.adapter.MentorAdapter

/**
 *
 * @author Ethan on 2022-01-26
 */
class MainViewModel : BaseViewModel() {
    val pageList = ArrayList<PageFormationData>()
    val mentorAdapter: MentorAdapter by lazy {
        MentorAdapter()
    }

    fun getCurrentPageList(pos: String): ArrayList<PageFormationData> {
        val currentList = ArrayList<PageFormationData>()
        val currentPage = pageList.filter { it.pageNo == pos }

        if (currentPage.isNotEmpty()) {
            // prev 추가
            if (currentPage[0].prevpage != "-1") {
                val prevPage = pageList.filter { it.pageNo == currentPage[0].prevpage }[0]
                currentList.add(prevPage)
            }

            // current 추가
            currentList.add(currentPage[0])

            // next 추가
            if (currentPage[0].nextpage != "-1") {
                val nextPage = pageList.filter { it.pageNo == currentPage[0].nextpage }[0]

                currentList.add(nextPage)
            }
        }
        Log.d("list", currentList.map { it.pageNo }.toString())
        return currentList
    }

    fun changeItem(currentPage: String) {
        mentorAdapter.submitList(getCurrentPageList(currentPage))
    }
}