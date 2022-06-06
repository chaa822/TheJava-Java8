package me.whiteship.thejavajava8.interface_lambda;

/**
 * 추상 메서드가 딱 하나만 있으면 그게 함수형 인터페이스
 * @FunctionalInterface를 사용하여 좀 더 견고하게 사용할 수 있다.
 *   (추상 메서드가 2개 이상일 경우 오류를 노출함)
 */

@FunctionalInterface
public interface RunSomething {

    void doIt();

}