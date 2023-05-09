
	import java.text.DecimalFormat;
	import java.util.*;

	// �߸� �Է� �� ����ó��

	class BankingAccount{
		static long balance; //�ܾ�
		long previousTransaction; // �����ŷ�
		String customerName; // ���̸�
		String customerId; // �� ���̵�
		
		void Userinfo() {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("�̸��� �Է��ϼ���.>");
			customerName = sc1.next();
			System.out.println("���� ���̵� �Է��ϼ���.>");
			customerId = sc1.next();
		}
		//�ܾ� ����
		void balanceSave() {
			if(balance >= 0) {
				balance = balance;
			}else {
				balance = 0;
			}
		}
		
		//����
		void deposit(long amount) { //�Ű�����: �ݾ�
			if(amount != 0) {
				balance = balance + amount;
				previousTransaction = amount;
				balanceSave();	
			}
		}
		
		//���
		void withdraw(long amount) {
			if(amount != 0) {
				balance = balance - amount;
					if(balance >= 0) {
						previousTransaction = -amount;
						System.out.println(comma(amount)+"���� ��ݵǾ����ϴ�.");
						System.out.println("\n");
						balanceSave();
					}else {
						System.out.println("�ܾ��� �����Ͽ� ����� �� �����ϴ�.");
						balance = balance + amount; // ����ϱ� �� �ܾ����� �ǵ���.
						balanceSave();
				}
			}
		}
		//���� �ŷ�����
		void getPreviouTransaction() {
			if(previousTransaction > 0) {
				System.out.println("����: "+comma(previousTransaction)+"��");
			}
			else if(previousTransaction < 0) {
				System.out.println("���: "+comma(Math.abs(previousTransaction))+"��"); //������ previousTransaction���� ���밪���� ��ȯ.
			}
			else {
				System.out.println("���� �ŷ������� �����ϴ�.");
			}
		}
		
		//õ���� ���б�ȣ(,) �Է�
		String comma(long amount) {
			DecimalFormat df = new DecimalFormat("###,###");
			String amount_str = df.format(amount);
			return amount_str;
		}
		
		//�޴�â����
		void viewMenu() {
			System.out.println("========���� ���� �޴�========");
			System.out.println("1. ����");
			System.out.println("2. ���");
			System.out.println("3. ���� �ŷ�����");
			System.out.println("4. �ܾ� Ȯ��");
			System.out.println("5. ����");
			System.out.println("=========================");
			
		}
		// �޴��Է� �����ε�
		
		
		//�޴� ����
		void showMenu() {
			
			char option = '\0';
			
			Scanner sc = new Scanner(System.in);
			System.out.println(customerName+"��, TH���࿡ ���� �� ȯ���մϴ�.");
			System.out.println(customerName+"���� ���¾��̵�� "+customerId+" �Դϴ�.");

			
			do {
				viewMenu();
				System.out.println("� ������ ���ðڽ��ϱ�? > ");
				
				option = sc.next().charAt(0);
				System.out.println("\n");
				switch (option) {
				case '1':
					long amount;
					do {
						System.out.println("=========����========");
						System.out.println("�����Ͻ� �ݾ��� �Է��ϼ���.");
						System.out.println("====================");
						amount = sc.nextLong();
						if(amount > 0) {
							deposit(amount);
							System.out.println(comma(amount)+"���� �ԱݵǾ����ϴ�.");
							System.out.println("\n");
						}else if(amount == 0) {
							System.out.println("�Ա��� �ݾ��� �����ϴ�. �ٽ� �Է����ּ���.");
						}
						else {
							System.out.println("�߸��� �ݾ��� �Է��ϼ̽��ϴ�. �ٽ��Է����ּ���.");
							}
						}while(amount <= 0);
					break;
				
				case '2':
					long amount2;
					do {
						System.out.println("=========���========");
						System.out.println("����Ͻ� �ݾ��� �Է��ϼ���.");
						System.out.println("====================");
						amount2 = sc.nextLong();
						if(amount2 > 0) {
							withdraw(amount2);
						}else if(amount2 == 0) {
							System.out.println("����� �ݾ��� �����ϴ�. �ٽ� �Է����ּ���.");
						}else {
							System.out.println("�߸��� �ݾ��� �Է��ϼ̽��ϴ�. �ٽ��Է����ּ���.");
							}
						}while(amount2 <= 0);
					break;
					
				case '3':
					System.out.println("=======���� �ŷ�����======");
					System.out.println("���� �ŷ������Դϴ�.");
					getPreviouTransaction();
					System.out.println("=====================");
					System.out.println("\n");
					break;
				
				case '4':
					System.out.println("=======�ܾ� Ȯ��======");
					System.out.println(customerName+"���� �ܾ��� "+comma(balance)+"�� �Դϴ�.");
					System.out.println("===================");
					System.out.println("\n");
					break;
				
				case '5':
					break;

				default:
					System.out.println("��ȿ���� ���� ���� �Է��Ͽ����ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					viewMenu();
					
					break;
				}
			}while(option != '5');
			System.out.println(customerName+"��, TH������ �̿��� �ּż� �����մϴ� :)");	
		}
	}

