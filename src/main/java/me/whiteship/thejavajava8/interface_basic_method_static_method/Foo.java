package me.whiteship.thejavajava8.interface_basic_method_static_method;

public interface Foo {

    // 1-1.
    // printName 메서드 정의
    void printName();

    // 2-1.
    // 인터페이스에 새로운 메서드를 추가할 경우, 인터페이스를 구현한 모든 클래스에서 오류가 발생한다.
    // why? -> 이 추상 메서드를 구현하지 않았기 때문에
//    void printNameUpperCase();

    // 2-2.
    // 이럴 경우, default 키워드를 이용해 오류를 발생 시키지 않고 추가할 수 있다.
    // printNameUpperCase 메서드 정의
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    // 2-3.
    // getName 메서드 정의
    String getName();

    // 2-7.
    // 인터페이스에서 제공하는 default 기능이 모든 구현체에서 정상적으로 동작하리라는 보장이 없다. (어떻게 구현했는지 모르기 때문에)
    // 따라서 오류 방지를 위해 최소한의 노력으로 아래와 같이 메서드에 @ImplSpec을 이용해 문서화를 진행해야한다.
    /**
     * @ImplSpec 이 구현체는 getName()으로 가져온 문자를 대문자로 출력한다.
     */


    // 3-1.
    // Object가 제공하는 기능은 기본 메소드로 제공할 수 없다
//    default String toString(){} // error

    // 3-2.
    // 추상 메서드로 선언하는 것은 가능
    String toString();


    // 5-1.
    // 유틸리티나 헬퍼 메서드를 제공하고 싶은 경우
    // static 키워드를 사용하여 메서드를 제공할 수 있다.
    static void printAnything(){
        System.out.println("Foo");
    }
}
