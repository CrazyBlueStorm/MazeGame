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
		if (order[0].equals("-mode")==false) Error();
		else {
			mode = order[1];
			if (mode.equals("sandbox")) {
				if ((order[2].substring(0,4).equals("-map")==false)||(n>4)) Error();
				difficulty = getInt(order[2].substring(4));
				if ((difficulty == 0)||(difficulty > 4)) {
					System.out.println("����ѡ�񳬳���Χ����Ϸ����");
					System.exit(0);
				}
				else map = Map.Getmap(difficulty);
			}
			else if (mode.equals("random")) {
				if ((order[2].equals("-r")==false)||(order[4].equals("-c")==false)||(n>6)) Error();
				r = getInt(order[3].substring(0));
				c = getInt(order[5].substring(0));
				if ((r<3)||(c<3)) {
					System.out.println("�Թ���С����Ϸ����");
					System.exit(0);
				}
				if ((r%2 != 1)||(c%2 != 1)) EvenNumber();
				map = new int [r][c];
				map = Map.Random(r,c);
				for (int i = 0;i < (r/10)*(c/10)+1; i++) {
					monster[i] = new Monster(r,c);
					int x = (int)(Math.random()*r);
					int y = (int)(Math.random()*c);
					while ((map[x][y] == 1)||(x == 1 && y == 1)||(x == r-2 && y == c-2)){
						x = (int)(Math.random()*r);
						y = (int)(Math.random()*c);
					}
					monster[i].Set(x,y);
				}
				for (int i = 0;i < (r/10)*(c/10)+1; i++) {
					treasure[i] = new Treasure(r,c);
					int x = (int)(Math.random()*r);
					int y = (int)(Math.random()*c);
					while ((map[x][y] == 1)||(x == 1 && y == 1)||(x == r-2 && y == c-2)){
						x = (int)(Math.random()*r);
						y = (int)(Math.random()*c);
					}
					treasure[i].Set(x,y);
				}
				map[r-2][c-2] = 5;
			}
			else if (mode.equals("story")) {
				if (n>2) Error();
				map = Map.Getmap(1);
			}
			else {
				System.out.println("δ֪ģʽ�����Ϸ����");
				System.exit(0);
			}
			System.out.println("����ѡ�� "+mode+" ģʽ");
			System.out.printf("\n\n");
		}
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
		System.exit(0);
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
		int[][] pmap = new int [map.length][map[0].length];
		for (int i = 0; i < pmap.length; i++) 
			for (int j = 0; j < pmap[0].length; j++) 
			if ((map[i][j] == 0)||(map[i][j] == 1)||(map[i][j] == 5)) pmap[i][j] = map[i][j];
		for (int i = 0; i < Nt; i++) pmap[treasure[i].PX][treasure[i].PY] = 6;
		pmap[player.PX][player.PY] = 2;
		for (int i = 0; i < Nm; i++) pmap[monster[i].PX][monster[i].PY] = 4;
		for (int i = 0; i < pmap.length; i++) {
			for (int j = 0; j < pmap[0].length; j++) {
				if (pmap[i][j]== 0) System.out.print("  ");
				if (pmap[i][j]== 1) System.out.print("��");
				if (pmap[i][j]== 2) System.out.print("��");
				if (pmap[i][j]== 3) System.out.print("��");
				if (pmap[i][j]== 4) System.out.print("��");
				if (pmap[i][j]== 5) System.out.print("��");
				if (pmap[i][j]== 6) System.out.print("��");
			}
			System.out.println();
		}
		System.out.println("��Ǹ��������.");
		System.out.println("��Ϸ����,���������ս��:");
		Player.Property();
		System.exit(0);
	}
	public static void LevelUp(int t) {
		switch (t) {
		case 0: {
			System.out.println("�ܾúܾ���ǰ,����������һ��ħ��,���Ĵ�����,������������ڿ־�֮��.");
			System.out.println("ֱ����һ��,�������.����Ԥ��,���ǻ�ɱ��ħ����������������.");
			System.out.println("̤�����̰�!");
		}
		case 1: {
			if (mode.equals("story")) System.out.println("��ϲ,���ѳɹ�ͨ����һ��.");
			System.out.println();
			System.out.println("��ӭ�����ڶ���.����һ����,ħ���ٻ��������צ������ֹ��,С�ı����ǹ�����.");
			key = false;
		}break;
		case 2: {
			if (mode.equals("story")) System.out.println("��ϲ,���ѳɹ�ͨ���ڶ���.");
			System.out.println();
			System.out.println("��ӭ����������.����һ����,�㷢����ħ���ı���,�ռ����ǿ���������ķ���.");
			key = false;
		}break;
		case 3: {
			if (mode.equals("story")) System.out.println("��ϲ,���ѳɹ�ͨ��������.");
			System.out.println();
			System.out.println("��ӭ�������Ĺ�.�⽫����Ϸ�����һ�أ�ħ��ʩ�������µ�צ���Ƕ�������,�����ڵ�һ���ռ�����һ�߶Ը����ƶ��Ĺ�����.");
			key = false;
		}break;
		case 4: {
			if (mode.equals("story")) System.out.println("��ϲ,���ѳɹ�ͨ�����Ĺ�.");
			System.out.println();
			System.out.println("���߳���ħ�����Թ���������ħ��,��������������!");
			Win();
		}break;
		default:  break;
		}
	}
	public static void Stop() {
			System.out.printf("\n\n");
			System.out.println("��Ϸ����,���������ս��:");
			Player.Property();
			System.exit(0);
	}
	public static void Wall() {
		System.out.println("�Բ���,�˴���ǽ.");
		permission = false;
	}
	public static void EvenNumber() {
		System.out.println("�����ͼ��ͳ���Ϊ����,��Ϸ����.");
		System.exit(0);
	}
}
