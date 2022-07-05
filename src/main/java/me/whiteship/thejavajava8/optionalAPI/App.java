package me.whiteship.thejavajava8.optionalAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

	public static void main(String[] args) {

		// Optional의 활용

		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "onlineClass boot", true));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		// spring으로 시작하는 첫번째 데이터를 가져올 경우
		// intellij에서는 자동으로 Optional 변수로 변환해준다. (있을 수도 있고 없을 수도 있기 때문)
		Optional<OnlineClass> optional = springClasses.stream()
				.filter(c -> c.getTitle().startsWith("onlineClass"))
				.findFirst();

		// Optional의 null check (Java11 이상부터는 isEmpty도 가능)
		boolean present = optional.isPresent();
		System.out.println(present);

		OnlineClass onlineClass = optional.get();
		System.out.println(onlineClass.getTitle());	// onlineClass Boot 출력

		// 아래와 같이 jpa로 찾으면 데이터가 없기 때문에
		// isPresent := false이고, get := null이기 때문에 오류가 발생한다.
		Optional<OnlineClass> optional2 = springClasses.stream()
				.filter(c -> c.getTitle().startsWith("jpa"))
				.findFirst();

		// error : No value present
//		OnlineClass onlineClass2 = optional2.get();
//		System.out.println(onlineClass2.getTitle());

		// 위의 코드를 아래와 같이 예외처리한다.
		if( optional2.isPresent() ){
			OnlineClass onlineClass2 = optional2.get();
			System.out.println(onlineClass2.getTitle());
		}
		// 위의 코드를 대신하여 ifPresent를 사용하여 조금 더 간결하게 처리할 수 있다.
		optional2.ifPresent(c -> {
			System.out.println(c.getTitle());
		});

		// 코드 흐름상 OnlineClass를 반드시 변수로 정의해야하는 경우 orElse를 사용하여 null체크를 겸하여 간결하게 처리할 수 있다.
		// 코드 해석 -> 데이터가 없으면 OnlineClass 인스턴스를 생성한다.
		// 주의 : (데이터가 있어도) orElse안의 메서드는 무조건 실행된다.
		OnlineClass onlineClass2 = optional.orElse(createNewClasses());
		System.out.println(onlineClass2.getTitle());

		// orElse안의 함수가 무조건 실행되는 것이 문제가 된다면 orElseGet을 사용하면 된다.
		// 람다 익스프레션
//		OnlineClass onlineClass3 = optional.orElseGet(() -> createNewClasses());
		// 메소드 레퍼런스
		OnlineClass onlineClass3 = optional.orElseGet(App::createNewClasses);
		System.out.println(onlineClass3.getTitle());

		// 없을 때 오류를 발생하고 싶다면 orElseThrow를 사용한다.
		// NoSuchElementException
//		OnlineClass onlineClass4 = optional2.orElseThrow();
		// CustomException : 람다 표현식
//		OnlineClass onlineClass4 = optional2.orElseThrow(() -> {
//			return new IllegalArgumentException();
//		});
		// CustomException : 메소드 레퍼런스
//		OnlineClass onlineClass4 = optional2.orElseThrow(IllegalArgumentException::new);
//		System.out.println(onlineClass4.getTitle());

		// Optional의 filter : 있다는 가정하에 실행되며, 결과는 Optional이다.
		Optional<OnlineClass> onlineClass5 = optional.filter(c -> !c.isClosed());
		System.out.println(onlineClass5.isEmpty()); // true

		// Optional의 map : filter와 마찬가지로 결과는 Optional이다.
		// 람다 표현식
//		Optional<Integer> integer = optional.map(c -> c.getId());
		// 메소드 레퍼런스
		Optional<Integer> integer = optional.map(OnlineClass::getId);
		System.out.println(integer.isPresent());

		// 만약에 메소드 레퍼런스를 사용해 Progress를 가져온다면 Optional<Optional<Progress>>가 된다.
		Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
		Optional<Progress> progressOptional = progress.orElse(Optional.empty());
		// 위와 같이 코드가 쓸데없이 복잡해지는데, 이를 간결하게 바꿀 수 있다.
		Optional<Progress> progressOptional2 = optional.flatMap(OnlineClass::getProgress);

		// stream에서의 map은 input, output이 1:1매핑이고
		// flatMap은 리스트 안의 리스트를 컨테이터 형태로 끄집어낼 때 사용하여 input은 하나지만 output이 여러개 일 때 사용한다.
	}

	private static OnlineClass createNewClasses() {
		System.out.println("creating new online Class");
		return new OnlineClass(10, "new Class", false);
	}
}
