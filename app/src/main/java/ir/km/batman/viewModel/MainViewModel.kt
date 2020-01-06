package ir.km.batman.viewModel

import androidx.annotation.NonNull
import io.reactivex.disposables.CompositeDisposable
import ir.km.batman.App
import ir.km.batman.AppRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(@NonNull application: App, val appRepository: AppRepository) :
    BaseViewModel(application) {


    private val compositDisposable: CompositeDisposable = CompositeDisposable()



    override fun onCleared() {
        super.onCleared()
        compositDisposable.clear()
    }

}
