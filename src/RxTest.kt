
import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.util.concurrent.Executors

class RxTest {
    @Test
    fun test() {
        var d: Disposable = Observable.just("string")
                .map {
                    println("1: ${Thread.currentThread().name}")
                    return@map it
                }
                .observeOn(Schedulers.io())
                .map {
                    println("2: ${Thread.currentThread().name}")
                    return@map it
                }
                //.observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
                .subscribeOn(Schedulers.computation())
                .map {
                    println("3: ${Thread.currentThread().name}")
                    return@map it //Mike: Should be MAIN THREAD
                }
                .subscribe {
                    println("4: ${Thread.currentThread().name}")
                }
        Thread.sleep(100)
    }

}