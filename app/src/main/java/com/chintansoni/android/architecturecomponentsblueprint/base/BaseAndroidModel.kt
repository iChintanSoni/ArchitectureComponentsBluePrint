package com.chintansoni.android.architecturecomponentsblueprint.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

/**
 * Created by chint on 2/18/2018.
 */
abstract class BaseAndroidModel(application: Application) : AndroidViewModel(application)