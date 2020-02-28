package com.rastko.emplate_interview.ui.common.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rastko.emplate_interview.ui.common.event.ViewEvent
import com.rastko.emplate_interview.ui.common.state.ViewModelState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    private val mutableViewState = MutableLiveData<ViewModelState>()
    val viewState: LiveData<ViewModelState> get() = mutableViewState

    protected fun updateState(viewModelState: ViewModelState) {
//        Timber.d("Current state ${viewState.value}")
//        Timber.d("Next state $viewModelState")
        mutableViewState.value = viewModelState
    }

    protected fun addAll(vararg disposable: Disposable) {
        this.disposables.addAll(*disposable)
    }

    open fun setupViewEvents(viewEvents: Observable<ViewEvent>) {
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
