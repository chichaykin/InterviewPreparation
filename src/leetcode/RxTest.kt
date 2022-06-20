package leetcode

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.junit.Test

class RxTest {

    @Test
    fun test() {
        Observable.just("q")
            .map {
                println("1: ${Thread.currentThread().name}") //TODO: computation
                return@map it
            }
            .observeOn(Schedulers.io())
            .map {
                println("2: ${Thread.currentThread().name}") //TODO: computation. Wrong Answer
                return@map it
            }
            .observeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.computation())
            .map {
                println("3: ${Thread.currentThread().name}") //TODO:  io. Wrong Answer
                return@map it
            }
            .subscribe {
                println("4: ${Thread.currentThread().name}") //TODO: computation. Wrong Answer
            }
        println("finish")
    }

    @Test
    fun testPublishSubject() {
        val cd = CompositeDisposable()
        var sub: PublishSubject<String> = PublishSubject.create()
        sub.hide().subscribe({
            println(it)
        }, {
            println(it)
        }).let { cd.add(it) }
        sub.hide().subscribe({
            println("Sub #2 $it")
        }, {
            println("Sub #2 $it")
        }).let { cd.add(it) }
        sub.onNext("test1")
        cd.dispose()
        sub.onError(RuntimeException("test2"))
    }
}