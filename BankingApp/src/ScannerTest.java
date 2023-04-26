import java.util.*;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자를 입력하세요.> ");
		System.out.println("문자를 입력하세요.> ");
//		int a = sc.nextInt(); // 정수를 입력받는 방법 (nextInt();)
//		System.out.println("value = "+a);
		
		char b = sc.next().charAt(0); //문자를 입력받는 방법 (String 문자열에서 첫번째 문자만을 추출해서 출력)
		System.out.println("value = "+b);
	}

}
