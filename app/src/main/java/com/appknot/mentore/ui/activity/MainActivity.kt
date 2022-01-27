package com.appknot.mentore.ui.activity

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.appknot.mentore.R
import com.appknot.mentore.databinding.ActivityMainBinding
import com.appknot.mentore.model.IssueData
import com.appknot.mentore.model.PageFormationData
import com.appknot.mentore.module.MentorListener
import com.appknot.mentore.module.MentorModule
import com.appknot.mentore.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(){
    override val layoutResourceId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()
    var actionFlag: Boolean = false

    private val mentorModule: MentorModule by lazy {
        MentorModule(mentorListener)
    }

    private val mentorListener: MentorListener by lazy {
        object : MentorListener {
            override fun closeTagListener(tag: String) {
                when (tag) {
                    MentorModule.TAG_PAGE_FORMATIONS -> {
                        setCurrentPage("1")
                    }
                }
            }

            override fun issueListener(issue: IssueData) {
            }

            override fun pageListener(pageFormation: PageFormationData) {
                viewModel.pageList.add(pageFormation)
            }

            override fun objectListener() {
            }

            override fun eventListener() {
            }
        }
    }

    override fun initStartView() {
        mentorModule.readXmlData(resources.getXml(R.xml.mentor))
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initDataBinding() {
        viewDataBinding.vpMentor.run {
            adapter = viewModel.mentorAdapter
            offscreenPageLimit = 100
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    when (state) {
                        ViewPager2.SCROLL_STATE_DRAGGING -> Log.d("vp2 state", "DRAGGING")
                        ViewPager2.SCROLL_STATE_IDLE -> Log.d("vp2 state", "IDLE")
                        ViewPager2.SCROLL_STATE_SETTLING -> {
                            Log.d("vp2 state", "SETTLING")
                            actionFlag = true
                        }
                    }
                }

                override fun onPageSelected(position: Int) {
                    Log.d("vp2 selected", position.toString())
                    if (actionFlag) {
                        actionFlag = false
                        viewModel.changeItem(viewModel.mentorAdapter.currentList[position].pageNo)
                    }
                }
            })
        }
    }

    override fun initAfterBinding() {

    }

    fun setCurrentPage(page: String) {
        viewModel.run {
            val list = getCurrentPageList(page)
            mentorAdapter.submitList(list)
            Handler(Looper.getMainLooper()).postDelayed({
                var idx = 0
                list.forEachIndexed { index, pageFormationData ->
                    if (pageFormationData.pageNo == page) {
                        idx = index
                        Log.d("idx", idx.toString())
                    }
                }
                viewDataBinding.vpMentor.setCurrentItem(idx, false)
            }, 100)
        }
    }
}