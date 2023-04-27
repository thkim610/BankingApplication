import java.util.*;

class BankAccount{
	int balance = 0; //잔액
	int previousTransaction; // 이전거래
	String customerName; // 고객이름
	String customerId; // 고객 아이디
	
//	public BankAccount(String cName, String cId) {
//		customerName = cName;
//		customerId = cId;
//	}
	void Userinfo() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("이름을 입력하세요.>");
		customerName = sc1.next();
		System.out.println("계좌 아이디를 입력하세요.>");
		customerId = sc1.next();
	}
	
	//예금
	void deposit(int amount) { //매개변수: 금액
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//출금
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	//이전 거래내역
	void getPreviouTransaction() {
		if(previousTransaction > 0) {
			System.out.println("예금: "+previousTransaction+"원");
		}
		else if(previousTransaction < 0) {
			System.out.println("출금: "+Math.abs(previousTransaction)+"원"); //음수인 previousTransaction값을 절대값으로 변환.
		}
		else {
			System.out.println("이전 거래내역이 없습니다.");
		}
	}
	//메뉴창보기
	void viewMenu() {
		System.out.println("========은행 업무 메뉴========");
		System.out.println("1. 예금");
		System.out.println("2. 출금");
		System.out.println("3. 이전 거래내역");
		System.out.println("4. 잔액 확인");
		System.out.println("5. 종료");
		System.out.println("=========================");
		
	}
	//메뉴 선택
	void showMenu() {
		
		char option = '\0';
		
		Scanner sc = new Scanner(System.in);
		System.out.println(customerName+"님, TH은행에 오신 걸 환영합니다.");
		System.out.println(customerName+"님의 계좌아이디는 "+customerId+" 입니다.");

		
		do {
			viewMenu();
			System.out.println("어떤 업무를 보시겠습니까? > ");
			
			option = sc.next().charAt(0);
			System.out.println("\n");
			switch (option) {
			case '1':
				int amount;
				do {
					System.out.println("=========예금========");
					System.out.println("예금하실 금액을 입력하세요.");
					System.out.println("====================");
					amount = sc.nextInt();
					if(amount > 0) {
						deposit(amount);
						System.out.println(amount+"원이 입금되었습니다.");
						System.out.println("\n");
					}else if(amount == 0) {
						System.out.println("입금할 금액이 없습니다. 다시 입력해주세요.");
					}
					else {
						System.out.println("잘못된 금액을 입력하셨습니다. 다시입력해주세요.");
						}
					}while(amount <= 0);
				break;
			
			case '2':
				int amount2;
				do {
					System.out.println("=========출금========");
					System.out.println("출금하실 금액을 입력하세요.");
					System.out.println("====================");
					amount2 = sc.nextInt();
					if(amount2 > 0) {
						withdraw(amount2);
						System.out.println(amount2+"원이 출금되었습니다.");
						System.out.println("\n");
					}else if(amount2 == 0) {
						System.out.println("출금할 금액이 없습니다. 다시 입력해주세요.");
					}else {
						System.out.println("잘못된 금액을 입력하셨습니다. 다시입력해주세요.");
						}
					}while(amount2 <= 0);
				break;
				
			case '3':
				System.out.println("=======이전 거래내역======");
				System.out.println("이전 거래내역입니다.");
				getPreviouTransaction();
				System.out.println("=====================");
				System.out.println("\n");
				break;
			
			case '4':
				System.out.println("=======잔액 확인======");
				System.out.println(customerName+"님의 잔액은 "+balance+"원 입니다.");
				System.out.println("===================");
				System.out.println("\n");
				break;
			
			case '5':
				break;

			default:
				System.out.println("유효하지 않은 값을 입력하였습니다.");
				System.out.println("다시 입력해주세요.");
				viewMenu();
				
				break;
			}
		}while(option != '5');
		System.out.println(customerName+"님, TH은행을 이용해 주셔서 감사합니다 :)");	
	}
}
public class BankingApp {

	public static void main(String[] args) {
		BankAccount b = new BankAccount(); 
		b.Userinfo();
		b.showMenu();
		

	}

}
