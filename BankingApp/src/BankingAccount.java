
	import java.text.DecimalFormat;
	import java.util.*;

	// 잘못 입력 시 예외처리

	class BankingAccount{
		static long balance; //잔액
		long previousTransaction; // 이전거래
		String customerName; // 고객이름
		String customerId; // 고객 아이디
		
		void Userinfo() {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("이름을 입력하세요.>");
			customerName = sc1.next();
			System.out.println("계좌 아이디를 입력하세요.>");
			customerId = sc1.next();
		}
		//잔액 저장
		void balanceSave() {
			if(balance >= 0) {
				balance = balance;
			}else {
				balance = 0;
			}
		}
		
		//예금
		void deposit(long amount) { //매개변수: 금액
			if(amount != 0) {
				balance = balance + amount;
				previousTransaction = amount;
				balanceSave();	
			}
		}
		
		//출금
		void withdraw(long amount) {
			if(amount != 0) {
				balance = balance - amount;
					if(balance >= 0) {
						previousTransaction = -amount;
						System.out.println(comma(amount)+"원이 출금되었습니다.");
						System.out.println("\n");
						balanceSave();
					}else {
						System.out.println("잔액이 부족하여 출금할 수 없습니다.");
						balance = balance + amount; // 출금하기 전 잔액으로 되돌림.
						balanceSave();
				}
			}
		}
		//이전 거래내역
		void getPreviouTransaction() {
			if(previousTransaction > 0) {
				System.out.println("예금: "+comma(previousTransaction)+"원");
			}
			else if(previousTransaction < 0) {
				System.out.println("출금: "+comma(Math.abs(previousTransaction))+"원"); //음수인 previousTransaction값을 절대값으로 변환.
			}
			else {
				System.out.println("이전 거래내역이 없습니다.");
			}
		}
		
		//천단위 구분기호(,) 입력
		String comma(long amount) {
			DecimalFormat df = new DecimalFormat("###,###");
			String amount_str = df.format(amount);
			return amount_str;
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
		// 메뉴입력 오버로딩
		
		
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
					long amount;
					do {
						System.out.println("=========예금========");
						System.out.println("예금하실 금액을 입력하세요.");
						System.out.println("====================");
						amount = sc.nextLong();
						if(amount > 0) {
							deposit(amount);
							System.out.println(comma(amount)+"원이 입금되었습니다.");
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
					long amount2;
					do {
						System.out.println("=========출금========");
						System.out.println("출금하실 금액을 입력하세요.");
						System.out.println("====================");
						amount2 = sc.nextLong();
						if(amount2 > 0) {
							withdraw(amount2);
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
					System.out.println(customerName+"님의 잔액은 "+comma(balance)+"원 입니다.");
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

