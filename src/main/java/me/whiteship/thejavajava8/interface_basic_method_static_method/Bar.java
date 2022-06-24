package me.whiteship.thejavajava8.interface_basic_method_static_method;

public interface Bar {

    // 4-1.
    // Foo 인터페이스를 상속받은 Bar 인터페이스에서 Foo가 제공하는 기본 메서드를 제공하고 싶지 않을 경우
    // Bar 인터페이스에서 다시 추상 메서드로 선언한다.
    // 이렇게 하면 Bar를 구현한 클래스에서 구현해야한다.
//    void printNameUpperCase();

    // 4-2.
    // Foo 인터페이스에도 default가 있고 Bar에도 default가 있는 경우, 구현하는 인터페이스에서 Foo, Bar를 둘 다 implements하게 되면
    // 논리적으로 둘 중에 어떤 것을 사용해야할지 모르기 때문에 애매한 상황이 발생하여 컴파일 오류가 발생
    default void printNameUpperCase(){
        System.out.println("BAR");
    }
}
