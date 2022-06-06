package me.whiteship.thejavajava8.basic_interface;

import com.sun.org.apache.xpath.internal.operations.Plus;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {

        // Function : T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스

        // 1.
        // 별도의 클래스를 Function 람다 표현식을 구현하여 만들 수도 있고
        Plus10 plus10 = new Plus10();
        System.out.println( plus10.apply(1) );

        // 2-1.
        // 별도의 클래스 없이 바로 구현할 수도 있다.
        Function<Integer, Integer> plus20 = (i) -> i + 20;
        System.out.println( plus20.apply(1) );

        // 2-2.
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println( multiply2.apply(1) );

        // 조합도 가능
        // compose : 10을 더하기 전에, 2를 곱하겠다.
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println( multiply2AndPlus10.apply(2) );

        // andThen : 10을 더한 뒤, 2를 곱하겠다.
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println( plus10AndMultiply2.apply(2) );

        // Consumer : T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier : T 타입의 값을 제공하는 함수 인터페이스
        // 입력 값을 받지 않는다.
        // 무조건 10을 리턴하는 함수
        Supplier<Integer> get10 = () -> 10;
        System.out.println( get10.get() );

        // Predicate : T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
        // a로 시작하는지 true/false를 리턴하는 함수
        Predicate<String> startsWith = (s) -> s.startsWith("a");
        System.out.println( startsWith.test("abcd") );

        // 짝수인지 검사하는 함수
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println( isEven.test(2) );

        // Predicate 조합도 가능
        // negate : true/false에 대해서 not을 붙인다.
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println( isOdd.test(2) );

        // and : 동시 조건 := false
        System.out.println( isEven.and(isOdd).test(1) );

        // or : 따로 조건 := true
        System.out.println( isEven.or(isOdd).test(1));

        // UnaryOperator :
        // Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
        UnaryOperator<Integer> integerUnaryOperator = (i) -> i + 10;
        System.out.println( integerUnaryOperator.apply(1) );
    }
}