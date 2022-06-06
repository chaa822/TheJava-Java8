package me.whiteship.thejavajava8;

public class Foo2 {

    public static void main(String[] args) {

        // 입력 받은 값이 동일한 경우 결과가 같아야한다.
        RunSomething2 runSomething = (number) -> {
            return number + 10;
        };

        System.out.println( runSomething.doIt(1) );
        System.out.println( runSomething.doIt(1) );
        System.out.println( runSomething.doIt(2) );
        System.out.println( runSomething.doIt(2) );

        // 위의 코드를 아래와 같이 변경할 수 있다.
        RunSomething2 runSomething2 = (number) -> number + 10;
        System.out.println( runSomething2.doIt(1) );
        System.out.println( runSomething2.doIt(2) );

        // 함수의 바깥에 어떠한 변수를 가지고 있다면
        // 퓨어한 함수라고 보기 어렵다.
        int baseNumber = 10;
        RunSomething2 runSomething3 = new RunSomething2() {
            @Override
            public int doIt(int number) {
                // 함수의 바깥에 값은 final이라고 가정하고 사용하기 때문에 변경하려고 하면 오류가 발생함
                // baseNumber += 1;

                // 단, 참조만 하는 것은 가능
                return number + baseNumber;
            }
        };
    }
}
