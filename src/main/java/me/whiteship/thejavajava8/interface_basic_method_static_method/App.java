package me.whiteship.thejavajava8.interface_basic_method_static_method;

public class App {

    public static void main(String[] args) {
        // 2-6.
        Foo foo = new DefaultFoo("jaeoh");
        foo.printName();
        foo.printNameUpperCase();

        // 5-2.
        Foo.printAnything();
    }
}
