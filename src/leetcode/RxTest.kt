package leetcode

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
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
}