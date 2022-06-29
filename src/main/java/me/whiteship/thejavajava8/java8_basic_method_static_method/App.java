package me.whiteship.thejavajava8.java8_basic_method_static_method;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("TheJava8");
        name.add("spring");
        name.add("toby");
        name.add("dev");

        // s에 괄호는 생략 가능
        name.forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("=============================================");

        // 위의 코드를 아래와 같이 변경 가능
        name.forEach(System.out::println);
        System.out.println("=============================================");

        // 기존의 iterator 활용
        Iterator<String> iterator = name.iterator();
        while( iterator.hasNext() ){
            System.out.println( iterator.next() );
        }
        System.out.println("=============================================");

        // iterator와 비슷하지만, 쪼갤 수 있는 기능을 가지고 있는 iterator
        Spliterator<String> spliterator = name.spliterator();
        while( spliterator.tryAdvance(System.out::println) );
        System.out.println("=============================================");

        // trySplit을 사용하면 반으로 쪼갠다.
        Spliterator<String> newSpliterator = name.spliterator();
        // 기존의 newSpliterator는 반으로 나눠지고, 나머지 반은 newSpliterator2로 간다.
        Spliterator<String> newSpliterator2 = newSpliterator.trySplit();
        while( newSpliterator.tryAdvance(System.out::println) );
        System.out.println("=============================================");
        while( newSpliterator2.tryAdvance(System.out::println) );
        System.out.println("=============================================");

        // stream : 내부적으로 Spliterator를 사용하고 있음
        long k = name.stream()
                .map(String::toUpperCase)       // map -> 요소 변환
                .filter(s -> s.startsWith("S")) // filter -> 조건에 의한 필터
                .count();                       // count -> size와 동일

        System.out.println("k -> " + k);
        System.out.println("=============================================");

        List<String> list = name.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println( "list -> " + list.toString() );
        System.out.println("=============================================");

        // 조건에 의한 삭제
        name.removeIf(s -> s.startsWith("S"));
        name.forEach(System.out::println);
        System.out.println("=============================================");

        // Comparator -> 함수형 인터페이스를 이용한 정렬
        name.sort(String::compareToIgnoreCase);
        name.forEach(System.out::println);
        System.out.println("=============================================");

        // 역순 정렬
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        System.out.println("=============================================");
        // thenComparing -> 정렬 후 또 다른 조건으로 정렬하고 싶을 경우
        name.sort(compareToIgnoreCase.reversed().thenComparing(compareToIgnoreCase.reversed()));


        // Java8 이전
        // 인터페이스 생성 -> a, b, c 함수 선언
        // 인터페이스를 구현하는 추상 클래스 (abstract class) 생성 -> a, b, c 함수 구현
        // 이유 : 추상 클래스를 상속 받아 구현하는 클래스에서 a, b, c 함수 중에 원하는 것만 골라서 구현할 수 있도록 편의성 제공
        // (필요 없다면 구현 X)

        // Java8 이후
        // 인터페이스에서 기본(default) 메서드를 사용해서 a, b, c 함수를 구현해 놓고
        // 추상 클래스 없이, 인터페이스를 직접 implements하는 방식

        // ex) WebMvcConfigurer.class, WebMvcConfigurerAdapter.class
        // 자바8 이전에는 WebMvcConfigurer에서 정의하고 WebMvcConfigurerAdapter에서 구현하였으나
        // WebMvcConfigurer에서 default 메서드로 변경된 후 WebMvcConfigurerAdapter가 Deprecated되었다.
    }
}
