package me.whiteship.thejavajava8.date_datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

	public static void main(String[] args) throws InterruptedException {

		// 날짜/시간 관련 클래스
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat();

		// 작명이 잘 되어 있지 않다. -> 사실상 타임스탬프
		long time = date.getTime();
		System.out.println(date);
		System.out.println(time);

		// 시간 변경이 가능하다 (mutable하다)
		// 따라서 멀티 쓰레드 환경에서 사용하기 부적합하다.
		Thread.sleep(1000 * 3);
		Date after3Seconds = new Date();
		System.out.println(after3Seconds);
		after3Seconds.setTime(time);
		System.out.println(after3Seconds);

		// 버그가 발생한 여지가 많다.
		// 다음 코드에서 month의 경우 0부터 1월로 시작하기 때문에 실제 월 수에서 1을 빼주거나, 상수(ex: Calendar.JULY)를 써줘야 한다.
		// 또한 type safe하지 않으므로, 음수가 들어가 오류가 발생할 수도 있다.
		Calendar theJavaBirthDay = new GregorianCalendar(1982, 6, 15);
		Calendar theJava8BirthDay = new GregorianCalendar(1982, Calendar.JULY, 15);

		// 위와 같은 이유로 Joda-Time이라는 라이브러리를 사용했다.
		// 이것이 Java8로 들어오면서 JSR이라는 표준으로 들어오게 되었다.
		// 디자인 철학 :
		// clear (명확성) : date.getTime()을 했을 때 long이 나오는거 같이 헷갈리게 하는것이 없다.
		// Fluent (유려함) : 메소드 체이닝 같은..
		// Imuutable (불변성) : 날짜를 조작했을 때, 상태 값이 변하는 것이 아니라 새로운 인스턴스를 반환한다.
		// Extensible (확장성) : 다른 캘린더 시스템을 제공하고, 스스로 제작할 수 있다.

		// 인류용 시간(human time)과 기계용 시간(machine time)으로 나눌 수 있다.
		// 인류용 시간 : 우리가 인지할 수 있는 연, 월, 일, 시, 분, 초를 사용
		// 기계용 시간 : EPOCK (1970년 1월 1일 0시 0분 0초)부터 현재까지의 타임스탬프를 표현
	}
}
