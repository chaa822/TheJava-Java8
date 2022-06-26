package me.whiteship.thejavajava8.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {

        // 1.
        // UnaryOperator : String을 받아서 String을 내보냄 -> UnaryOperator<String, String>
        // Input과 Ouput이 같은 경우, String을 하나로 줄일 수 있음
        UnaryOperator<String> hi = (s) -> "hi " + s;
        System.out.println( hi.apply("jaeoh") );

        // 2.
        // 1의 hi를 Greeting 클래스를 이용하여 다음과 같이 변경할 수 있음
        // 'Class::Method'
        // 단, Method가 static이어야 한다.
        UnaryOperator<String> hi2 = Greeting:: hi;
        System.out.println( hi2.apply("jaeoh") );

        // 3.
        // 2와 같은 static method가 아닌, instance method의 경우 다음과 같이 작성할 수 있다.
        // 'Class classInstance = new Class();'
        // 'classInstance::Method'
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println( hello.apply("jaeoh") );

        // 4.
        // Supplier를 이용해 greeting 객체를 가져오는 함수 생성
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting2 = newGreeting.get();

        // 5.
        // Function과 Supplier는 똑같이 'Greeting::new'라는 키워드를 사용하지만
        // 호출되는 생성자는 서로 다르다.

        // String name을 파라미터로 받는 생성자
        Function<String, Greeting> greeting3 = Greeting::new;
        Greeting jaeoh = greeting3.apply("jaeoh");
        System.out.println( jaeoh.getName() );

        // 파라미터가 없는 생성자
        Supplier<Greeting> greeting4 = Greeting::new;

        // 6.
        // 기존의 sort 정의 방식
        String[] names = {"jaeoh", "spring", "dev"};
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
