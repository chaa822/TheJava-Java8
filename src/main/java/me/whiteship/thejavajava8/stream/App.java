package me.whiteship.thejavajava8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("TheJava8");
        name.add("spring");
        name.add("toby");
        name.add("dev");

        // stream : 연속된 데이터를 처리하는 연속된 오퍼레이터들의 모음
        // 특징 :
        // 1. 데이터를 담는 저장소가 아니다.
        // 2. 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
        // 3. 근본적으로 Functional하다. (소스를 변경하지 않는다)
        // 4. 무제한일 수도 있다.
        // 5. 중개 오퍼레이터는 근본적으로 lazy하다.
        // 6. 손쉽게 병렬 처리할 수 있다.

        // 중개형 오퍼레이터 : Stream을 리턴한다. -> map, filter ...
        // 종료형 오퍼레이터 : Stream을 리턴하지 않는다. -> count, collect, anyMath ...
        Stream<String> stringStream = name.stream().map(String::toUpperCase);

        // 근본적으로 중개형 오퍼레이터들은 종료형 오퍼레이터가 오기 전까지 실행되지 않는다. 단지, 정의했을 뿐이다.
        // 실행되기 위해선 종료형 오퍼레이터가 마지막에 반드시 존재해야한다.
        // 종료형 오퍼레이터가 존재하지 않기 때문에, map안에서 sout을 찍어도 출력되지 않는다.
        Stream<String> stringStream1 = name.stream().map(s -> {
            System.out.println(s.toUpperCase());
            return s.toUpperCase();
        });
        System.out.println("========================================================");

        // 종료형 오퍼레이터가 존재하기 때문에, 출력 된다.
        List<String> collect = name.stream()
                                    .map(s -> {
                                        System.out.println(s.toUpperCase());
                                        return s.toUpperCase();
                                    })
                                    .map(s -> {
                                        System.out.println(s);
                                        return s.toUpperCase();
                                    })
                                    .collect(Collectors.toList());
        System.out.println("========================================================");

        // parallelStream : 병렬 처리
        // Thread의 생성, 데이터 수집, Thread간의 컨텍스트 스위칭 등의 비용 때문에, 병렬 처리가 더 오래걸릴 수 있다.
        // 데이터가 정말 방대하게 큰 경우, 병렬처리를 사용한다.
        List<String> collect1 = name.parallelStream()
//                                    .map(String::toUpperCase)
                                    .map(s -> {
                                        // stream(직렬)으로 했을 때와 parallelStream(병렬)으로 했을 때 이름이 다르게 나온다.
                                        System.out.println(s + " " + Thread.currentThread().getName());
                                        return s.toUpperCase();
                                    })
                                    .collect(Collectors.toList());
        System.out.println("========================================================");
        collect1.forEach(System.out::println);
    }
}
