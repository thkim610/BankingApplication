import java.util.*;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("���ڸ� �Է��ϼ���.> ");
		System.out.println("���ڸ� �Է��ϼ���.> ");
//		int a = sc.nextInt(); // ������ �Է¹޴� ��� (nextInt();)
//		System.out.println("value = "+a);
		
		char b = sc.next().charAt(0); //���ڸ� �Է¹޴� ��� (String ���ڿ����� ù��° ���ڸ��� �����ؼ� ���)
		System.out.println("value = "+b);
	}

}
