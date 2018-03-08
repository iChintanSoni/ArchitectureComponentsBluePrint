package com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel

import com.chintansoni.android.architecturecomponentsblueprint.base.BaseViewModel
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiService
import javax.inject.Inject

/**
 * Created by chint on 2/18/2018.
 */
class HomeActivityViewModel() : BaseViewModel() {

    @Inject
    constructor(apiService: ApiService) : this() {

    }
}