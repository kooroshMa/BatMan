package ir.km.batman.base

import android.app.Application
import androidx.annotation.NonNull
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import ir.km.batman.BR

abstract class BaseViewModel(@NonNull application: Application) :
    AndroidViewModel(application), Observable {


    @delegate:Transient
    private val mCallbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.remove(callback)
    }

    fun notifyChange() {
        mCallbacks.notifyChange(this, BR._all)
    }


}