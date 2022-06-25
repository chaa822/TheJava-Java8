package me.whiteship.thejavajava8.lambda_expression;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        Foo foo = new Foo();
        foo.run();
    }

    private void run(){

        // 1.
        // effective final
        // final 키워드를 생략할 수 있는 경우 : 이 변수가 사실상 final인 경우 (변경되지 않음)
        int baseNumber = 10;

        // 2.
        // 로컬 클래스
        class localClass {
            void printNumber(){
                System.out.println(baseNumber);
            }
        }

        // 3.
        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 4.
        // 로컬 클래스와 익명 클래스는
        // 쉐도잉 (로컬 클래스 or 익명 클래스 안의 변수가 외부의 변수보다 우선시 됨 - ex: baseNumber)이 되지만
        // 람다는 쉐도잉이 되지 않는다 -> 람다 함수의 범위와 run 함수의 범위가 같다.
        // 따라서

        // 5.
        // 람다
        IntConsumer printInt = (i) -> {
//            int baseNumber = 11; // Variable baseNumber is already defined in the scope.
            System.out.println(i + baseNumber);
        };
        printInt.accept(10);

        // effective final인 baseNumber 변수를 변경하려할 경우, 컴파일 오류
//        baseNumber++;   // Variable used in lambda expression should be final or effectively final
    }
}
