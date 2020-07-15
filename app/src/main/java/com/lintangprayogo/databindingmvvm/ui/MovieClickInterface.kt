package com.lintangprayogo.databindingmvvm.ui

import android.view.View
import com.lintangprayogo.databindingmvvm.data.model.Movie

interface MovieClickInterface {
    fun onItemClicked(view:View,movie:Movie)
}