import java.util.Scanner;

public class Users extends Game{
	public static void Initialization(String[] order) {
		int n = order.length;
		int r = 31;
		int c = 31;
		if (n == 0) {
			System.out.println("��ʼ������Ϊ�㣬��Ϸ����");
			System.exit(0);
		}
		mode = order[0].substring(6);
		if (mode.equals("SandBox")) {
			difficulty = getInt(order[1].substring(5));
			if ((difficulty == 0)||(difficulty > 4)) {
				System.out.println("����ѡ�񳬳���Χ����Ϸ����");
				System.exit(0);
			}
			else map = Map.Getmap(difficulty);
		}
		else if (mode.equals("Random")) {
			r = getInt(order[4].substring(0));
			c = getInt(order[6].substring(0));
			if ((r<3)||(c<3)) {
				System.out.println("�Թ���С����Ϸ����");
				System.exit(0);
			}
			map = Map.Random(r,c);
		}
		else if (mode.equals("Story")) map = Map.Getmap(1);
		else {
			System.out.println("δ֪ģʽ�����Ϸ����");
			System.exit(0);
		}
		for (int i = 0;i < (r/10)*(c/10)+1; i++) {
			monster[i] = new Monster(r,c);
			Nm = Nm + 1;
		}
		for (int i = 0;i < (r/10)*(c/10)+1; i++) {
			treasure[i] = new Treasure(r,c);
			Nt = Nt + 1;
		}
		System.out.println("����ѡ�� "+mode+" ģʽ");
		System.out.printf("\n\n");
	}
	public static void Welcome() {
		Scanner input = new Scanner(System.in);
		System.out.println("         ��ӭ�����Թ���Ϸ��");
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println();
		System.out.println("���������ַ���ʼ��Ϸ...");
		String s = input.next();
	}
	public static String getName() {
		Scanner input = new Scanner(System.in);
		System.out.println("��Ϊ�������ѡ������: ");
		String s = input.next();
		return s;
	}
	public static int getInt(String s) {
		int l = s.length();
		int n = 0;
		for (int i = 0; i < l; i++) {
			if ((s.charAt(i)>='0')&&(s.charAt(i)<='9')==false) {
				System.out.println("�Ƿ�����,��Ϸ����.");
				System.exit(0);
			}
		n = ((int)(s.charAt(i))-48)*(int)(Math.pow(10, l-i-1)) + n;
		}
		return n;
	}
	public static void Error() {
		System.out.println("�����������,��Ϸ����.");
	}
	public static String IandO() {
		Scanner input = new Scanner(System.in);
		System.out.print("������ָ��(����'h'�Ի�ð���): "); 
		String s = input.next();
		while (true) {
			if (s.equals("a") || s.equals("s") || s.equals("d") || s.equals("w") || s.equals("h") || s.equals("k") || s.equals("p") || s.equals("c") || s.equals("b") || s.equals("q") || s.equals("x")) return s;
			else {
				System.out.println("�Ƿ�����!");
				System.out.print("������ָ��(����'h'�Ի�ð���): ");
				s = input.next();
			}
		}
	}
	public static void Win() {
		System.out.println("��ϲ����Ӯ��!");
		Player.Property();
		System.exit(0);
	}
	public static void Die() {
		System.out.println("��Ǹ��������.");
		System.out.println("��Ϸ����,���������ս��:");
		Player.Property();
		System.exit(0);
	}
	public static void LevelUp(int t) {
		switch (t) {
		case 1: {
			System.out.println("��ϲ,���ѳɹ�ͨ����һ��.");
			System.out.println();
			System.out.println("��ӭ�����ڶ���.����һ����,ħ���ٻ��������צ������ֹ��,С�ı����ǹ�����.");
		}
		case 2: {
			System.out.println("��ϲ,���ѳɹ�ͨ���ڶ���.");
			System.out.println();
			System.out.println("��ӭ����������.����һ����,�㷢����ħ���ı���,�ռ����ǿ���������ķ���.");
		}
		case 3: {
			System.out.println("��ϲ,���ѳɹ�ͨ��������.");
			System.out.println();
			System.out.println("��ӭ�������Ĺ�.�⽫����Ϸ�����һ�أ�ħ��ʩ�������µ�צ���Ƕ�������,�����ڵ�һ���ռ�����һ�߶Ը����ƶ��Ĺ�����.");
		}
		case 4: {
			System.out.println("��ϲ,���ѳɹ�ͨ�����Ĺ�.");
			System.out.println();
			System.out.println("���߳���ħ�����Թ���������ħ��,��������������!");
		}
		default:  break;
		}
	}
	public static void Stop() {
			System.out.printf("\n\n");
			System.out.println("��Ϸ����,���������ս��:");
			Player.Property();
			System.exit(0);
	}
}
