package me.whiteship.thejavajava8;

public class Foo {

    public static void main(String[] args) {

        /*
         * 함수를 First class object로 사용할 수 있다.
         * 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
         */

        // 1.
        // 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello");
                System.out.println("Rambda");
            }
        };
        runSomething.doIt();

        // 2.
        // 1번 코드를 rambda 표현식으로 변경 가능. 단, doIt안의 코드가 한 줄 일 경우에만
        RunSomething runSomething2 = () -> System.out.println("hello");
        runSomething2.doIt();


    }
}
