package com.appknot.mentore.ui.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.appknot.core_rx.base.RxBaseActivity
import com.appknot.mentore.viewmodel.BaseViewModel

/**
 *
 * @author Ethan on 2022-01-27
 */
abstract class BaseActivity<VB: ViewDataBinding, VM: BaseViewModel> : RxBaseActivity<VB, VM>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}