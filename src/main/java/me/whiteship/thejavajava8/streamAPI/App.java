package me.whiteship.thejavajava8.streamAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("##spring으로 시작하는 수업");
        springClasses.stream()
                .filter(c -> c.getTitle().startsWith("spring"))
                .forEach(c -> System.out.println(c.getId()));
        System.out.println();

        System.out.println("##close 되지 않은 수업");
        springClasses.stream()
                .filter(c -> !c.isClosed())
                .forEach(c -> System.out.println(c.getId()));

        // 메서드 레퍼런스 & 인터페이스의 스태틱 메서드를 활용
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(c -> System.out.println(c.getId()));
        System.out.println();

        System.out.println("##수업 이름만 모아서 스트림 만들기");
        // 기본적인 사용
        springClasses.stream()
                .map(c -> c.getTitle())
                .forEach(s -> System.out.println(s));

        System.out.println();

        // 역시나 메소드 레퍼런스를 사용해 다음과 같이 변경할 수 있다.
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);
        System.out.println();


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> theJava8Events = new ArrayList<>();
        theJava8Events.add(springClasses);
        theJava8Events.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // flatMap : 특수한 형태의 map 오퍼레이터 -> list를 .stream() 사용하여 여러개의 OnlineClass 클래스로 flating
        theJava8Events.stream()
                .flatMap(list -> list.stream()) // 이 다음 오퍼레이터 부터는 OnlineClass로 들어온다.
                .forEach(c -> System.out.println(c.getId()));

        // 메소드 레퍼런스 사용
        theJava8Events.stream()
                .map(Collection::stream)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // iterate : 10부터 시작해서 1씩 증가하는 stream -> 무제한 (무한루프)
        // iterate는 중개형 오퍼레이터이기 때문에, 종료형 오퍼레이터가 있어야 실행된다.
        Stream.iterate(10, i -> i + 1)
                .skip(10)           // 앞에 10개는 건너 뜀
                .limit(10)     // 10개만
                .forEach(System.out::println);
        System.out.println();

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(c -> c.getTitle().contains("Test"));
        System.out.println( test );
        System.out.println();

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(c -> c.getTitle().contains("spring"))
                .map(c -> c.getTitle())
                .collect(Collectors.toList());
        spring.forEach(System.out::println);
        System.out.println();

        // 메소드 레퍼런스 사용
        List<String> spring2 = springClasses.stream()
                .filter(c -> c.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring2.forEach(System.out::println);
        System.out.println();

        // filter와 map의 순서를 바꿀 경우, 타입이 변경된다.
        List<String> spring3 = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(s -> s.contains("spring"))
                .collect(Collectors.toList());
        spring3.forEach(System.out::println);
    }
}
