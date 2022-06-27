package me.whiteship.thejavajava8.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {

        // 1.
        // Function : String을 받아서 String을 내보냄 -> Function<String, String>
        Function<String, String> fnHi = (s) -> "hi" + s;
        System.out.println( fnHi.apply("TheJava8") );

        // Input과 Ouput이 같은 경우, String을 하나로 줄일 수 있음 -> UnaryOperator<String>
        UnaryOperator<String> hi = (s) -> "hi " + s;
        System.out.println( hi.apply("TheJava8") );

        // 2.
        // 1의 hi를 Greeting 클래스를 이용해 생성 -> 메서드가 static이어야 한다.
        UnaryOperator<String> hi2 = Greeting:: hi;
        System.out.println( hi2.apply("TheJava8") );

        // 3.
        // 스태틱 메서드가 아닌, 인스턴스 메서드를 이용해 생성할 경우 다음과 같이 작성
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println( hello.apply("TheJava8") );

        // 4.
        // Supplier를 이용해 greeting 객체를 가져오는 함수 생성
        // 주의 : newGreeting이 Greeting 클래스의 객체가 아니다.
        // .get() 함수를 이용해 객체 생성을 해줘야 한다.
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting2 = newGreeting.get();

        // 5.
        // String name을 파라미터로 받는 생성자
        // 5번의 Function과 4번의 Supplier는 똑같이 'Greeting::new'라는 키워드를 사용하지만
        // 호출되는 생성자는 서로 다르다.
        Function<String, Greeting> greeting3 = Greeting::new;
        Greeting theJava8 = greeting3.apply("TheJava8");
        System.out.println( theJava8.getName() );

        // 파라미터가 없는 생성자
        Supplier<Greeting> greeting4 = Greeting::new;

        // 6.
        // 기존의 sort 정의 방식
        String[] names = {"TheJava8", "spring", "dev"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        // Comparator도 FunctionalInterface로 변경되어 다음과 같이 변경 가능
        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
