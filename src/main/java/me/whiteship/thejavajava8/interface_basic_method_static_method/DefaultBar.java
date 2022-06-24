package me.whiteship.thejavajava8.interface_basic_method_static_method;

public class DefaultBar implements Foo, Bar{

    String name;

    public DefaultBar(String name){
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    // 4-3.
    // 4-2와 같은 이야기지만 구현하는 클래스에서 Foo, Bar 인터페스를 모두 구현할 경우
    // 논리적으로 둘 중에 어떤 것을 사용해야할지 모르기 때문에 애매한 상황이 발생하여 컴파일 오류가 발생
    // 이렇게 충돌하는 경우에는 직접 Override를 해야 한다.
    @Override
    public void printNameUpperCase() {
        System.out.println("BAR");
    }
}
