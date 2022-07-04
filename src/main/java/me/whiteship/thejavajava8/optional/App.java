package me.whiteship.thejavajava8.optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {

	public static void main(String[] args) {

		// Optional
		// Java8에서 추가된 인터페이스
		// 비어 있을 수도, 담고 있을 수도 있는 컨테이너 인스턴스의 타입

		// 등장 배경 :
		//

		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);

//		Progress 클래스 -> getProgress가 다음과 같이 되어 있을 경우
//		.
//		.
//		public Progress getProgress() {
//			return progress;
//		}
//		.
//		.

//		Progress가 null이기 때문에 NullPointerException이 발생한다.
//		Duration studyDuration = spring_boot.getProgress().getStudyDuration();
//		System.out.println(studyDuration);

//		대안으로 아래와 같이 호출하는 쪽에서 null체크를 해주면 되지만
//		이러한 null 체크를 언제든 놓칠 수 있기 때문에 NullPointerException을 에러를 보게 된다.
//		Progress progress = spring_boot.getProgress();
//		if( progress != null ){
//			System.out.println(progress.getStudyDuration());
//		}

//		아래와 같이 Progress 클래스 -> getProgress 메서드에 예외 처리를 해줘도 되지만
//		에러 처리를 강제하는 문제가 있고, 에러 발생 시 stackTrace를 담기 때문에 리소스 낭비가 발생한다.
//		public Progress getProgress() {
//			if( this.progress == null ){
//				throw new IllegalStateException();
//			}
//		}

//		Optional.of 메서드는 파라미터가 반드시 null이 아니라고 가정하므로
//		파라미터가 null일 경우 NullPointerException을 발생 시킨다.
//		public Optional<Progress> getProgress() {
//			return Optional.of(progress);	// NullPointerException
//		}

//		따라서 리턴 타입이 null일 수 있을 때 Optional.ofNullable 메서드를 사용하여 감싸준다.
//		문법적으로 제한은 없어서 메서드 파라미터/맵의 키 등 여러방법으로 사용이 가능하지만, 리턴 타입에만 사용하는 것을 권장한다.
//		public Optional<Progress> getProgress() {
//			return Optional.ofNullable(progress);
//		}


//		Optional을 리턴하는 메소드에서 null을 리턴하지 말자.
//		public Optional<Progress> getProgress() {
//			return null;
//		}


//		기본 타입으로 Option을 사용하지 말자.
//		Optional<Progress> progress;	// X
//		Optional.of(10);				// X


//		프리미티브 타입으로 지원한다.
//		OptionalInt optionalInt = OptionalInt.of(10);

	}
}
