package leetcode;

import org.junit.Test;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.*;
interface MonthDayHelper {
    default MonthDay construct(Month month, int dayOfMonth) {
        return MonthDay.of(month, dayOfMonth);
    }
    static String toString(MonthDay monthDay) {
        return monthDay.getMonth().toString() + " " + monthDay.getDayOfMonth();
    }
}
interface LocalTimeHelper  {
    default LocalTime construct(int hour, int minute, int second) {
        return LocalTime.of(hour,minute,second);
    }
    static String toString(LocalTime localTime) {
        return localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond();
    }
}
class DateTimeClass implements MonthDayHelper, LocalTimeHelper {
    private MonthDay monthDay;
    private LocalTime localTime;

    DateTimeClass(Month month, int dayOfMonth, int hours, int minutes, int seconds) {
        monthDay = MonthDayHelper.super.construct(month,dayOfMonth);
        localTime = LocalTimeHelper.super.construct(hours,minutes,seconds);
    }
    void print() {
        System.out.print(MonthDayHelper.toString(monthDay));
        System.out.println(" "+ LocalTimeHelper.toString(localTime));
    }

}

interface StringMapper<T> {
    String map(T t);
}
class X {
    String s;
    public X(String s) { this.s=s; }
    @Override public String toString() { return s.toLowerCase();}
    public String toLowerCase() { return s.toLowerCase();}
}
class Y<T> {
    T s;
    public Y(T s) { this.s=s; }
    @Override public String toString() { return s.toString();}
}
class H2 {
    static String mapme(Y y, StringMapper<Y> t) {
        return t.map(y);
    }
    static String mapme(X x, StringMapper<X> t) {
        return t.map(x);
    }
    public static void main(String[] args) {
        //*****
    }
}

class Invoice {
    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }
}

class SalesInvoice extends Invoice {
    public static String formatId(String oldId) {
        return oldId + "_SalesInvoice";
    }
}

class Indices {
    public String s;
    public List<Integer> indices;
    public Indices(String s) {
        this.s=s;
        indices= new LinkedList<>();
        for (int i=0;i<this.s.length();++i) {
            indices.add(i);
        }
    }
}



interface I1 { boolean f();}
interface I2 { boolean f(String s);}
interface I3 { boolean f(String s,String t);}



public class TestOnline {

    @Test
    public void remTest() {
        System.out.println("4/3: rem: " + 4%(-3) );
        assertEquals(true, false);
    }

    static void print(I1 i) {}
    static void print(I2 i) {}
    static void print(I3 i) {}

    @Test
    public void test() {
        Stream.of(new Indices("Mercury"),new Indices("Venus"),new Indices("Earth"))
                .flatMap( i -> i.indices.stream())
                .mapToInt(j -> j)
                .max()
                .ifPresent(s -> System.out.println(s));

    }

    @Test
    public void test2() {
        DateTimeClass dt1 = new DateTimeClass(Month.OCTOBER,31,12,5,30);
        DateTimeClass dt2 = new DateTimeClass(Month.JANUARY,1,5,14,25);
        dt1.print();
        dt2.print();
//        String s = "1";
//        System.out.println( (new String() == new String()) ? "true" : "false");
//        YearMonth ym1 = YearMonth.of(2015, Month.SEPTEMBER);
//        YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY);
//        System.out.println(ym1.minus(Period.ofMonths(4)).getMonthValue());
//        System.out.println(ym1.until(ym2, ChronoUnit.MONTHS));
//        Supplier<String> i = () -> "Car";
//        Consumer<String> c = x -> System.out.print(x.toLowerCase());
//        Consumer<String> d = x -> System.out.print(x.toUpperCase());
//        c.andThen(d).accept(i.get());
        //Stream.of("1RED","2RED","3RED").findFirst().map(String::toLowerCase).ifPresent(System.out::println);
//        System.out.println(H2.mapme(new X("HELLO"),
//                e -> {if (e.s.charAt(0)=='H') return e.toString();return e.toLowerCase();}));
//        System.out.print(I2.name+",");
//        System.out.print(I2.s1+",");
//        System.out.print(((I1)this).name);
//        Stream.of("little", "red", "riding", "hood")
//                .parallel()
//                .map(s -> {System.out.println("map: " + s + " " + Thread.currentThread().getName()); return s + "_";})
//                .filter(s -> {System.out.println("filter: " + s + " " + Thread.currentThread().getName()); return s.length()>3;})
//                .reduce( (s1, s2) -> {
//                    System.out.println("reducer: " + s1 + " " + Thread.currentThread().getName());
//                    return s1.length() > s2.length()? s1:s2;
//                });
        Console cons = System.console();
        assertFalse(true);
    }

    public Integer getNumber() {
        return 2;
    }
    public void setNumber(Integer n) {
    }

}

