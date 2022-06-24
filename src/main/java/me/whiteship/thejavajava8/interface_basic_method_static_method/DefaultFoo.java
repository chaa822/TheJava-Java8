package me.whiteship.thejavajava8.interface_basic_method_static_method;

public class DefaultFoo implements Foo {

    // 1-2. printName method 구현
    @Override
    public void printName(){
        System.out.println(this.name);
    }

    // 2-4.
    // 파라미터로 name을 받는다고 가정
    String name;
    public DefaultFoo(String name){
        this.name = name;
    }
    // 2-5.
    // getName 메서드 구현
    @Override
    public String getName() {
        return this.name;
    }

    // 2-8.
    // 구현하는 클래스에서 재정의할 수도 있다.
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
