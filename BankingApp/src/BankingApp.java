import java.util.*;

class BankAccount{
	int balance; //�ܾ�
	int previousTransaction; // �����ŷ�
	String customerName; // ���̸�
	String customerId; // �� ���̵�
	
//	public BankAccount(String cName, String cId) {
//		customerName = cName;
//		customerId = cId;
//	}
	void Userinfo() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���.>");
		customerName = sc1.next();
		System.out.println("���� ���̵� �Է��ϼ���.>");
		customerId = sc1.next();
	}
	
	//����
	void deposit(int amount) { //�Ű�����: �ݾ�
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	//���
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	//���� �ŷ�����
	void getPreviouTransaction() {
		if(previousTransaction > 0) {
			System.out.println("����: "+previousTransaction+"��");
		}
		else if(previousTransaction < 0) {
			System.out.println("���: "+Math.abs(previousTransaction)+"��"); //������ previousTransaction���� ���밪���� ��ȯ.
		}
		else {
			System.out.println("���� �ŷ������� �����ϴ�.");
		}
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
				System.out.println("=========����========");
				System.out.println("�����Ͻ� �ݾ��� �Է��ϼ���.");
				System.out.println("====================");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println(amount+"���� �ԱݵǾ����ϴ�.");
				System.out.println("\n");
				break;
			
			case '2':
				System.out.println("=========���========");
				System.out.println("����Ͻ� �ݾ��� �Է��ϼ���.");
				System.out.println("====================");
				int amount2 = sc.nextInt();
				withdraw(amount2);
				System.out.println(amount2+"���� ��ݵǾ����ϴ�.");
				System.out.println("\n");
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
				System.out.println(customerName+"���� �ܾ��� "+balance+"�� �Դϴ�.");
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
public class BankingApp {

	public static void main(String[] args) {
		BankAccount b = new BankAccount(); 
		b.Userinfo();
		b.showMenu();
		

	}

}
