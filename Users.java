import java.util.Scanner;

public class Users extends Game{
	public static void Initialization(String[] order) {
		int n = order.length;
		int r = 31;
		int c = 31;
		if (n == 0) {
			System.out.println("初始化参数为零，游戏结束");
			System.exit(0);
		}
		mode = order[0].substring(6);
		if (mode.equals("SandBox")) {
			difficulty = getInt(order[1].substring(5));
			if ((difficulty == 0)||(difficulty > 4)) {
				System.out.println("层数选择超出范围，游戏结束");
				System.exit(0);
			}
			else map = Map.Getmap(difficulty);
		}
		else if (mode.equals("Random")) {
			r = getInt(order[4].substring(0));
			c = getInt(order[6].substring(0));
			if ((r<3)||(c<3)) {
				System.out.println("迷宫过小，游戏结束");
				System.exit(0);
			}
			map = Map.Random(r,c);
		}
		else if (mode.equals("Story")) map = Map.Getmap(1);
		else {
			System.out.println("未知模式命令，游戏结束");
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
		System.out.println("你已选择 "+mode+" 模式");
		System.out.printf("\n\n");
	}
	public static void Welcome() {
		Scanner input = new Scanner(System.in);
		System.out.println("         欢迎来到迷宫游戏！");
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println();
		System.out.println("输入任意字符开始游戏...");
		String s = input.next();
	}
	public static String getName() {
		Scanner input = new Scanner(System.in);
		System.out.println("请为你的人物选择名字: ");
		String s = input.next();
		return s;
	}
	public static int getInt(String s) {
		int l = s.length();
		int n = 0;
		for (int i = 0; i < l; i++) {
			if ((s.charAt(i)>='0')&&(s.charAt(i)<='9')==false) {
				System.out.println("非法输入,游戏结束.");
				System.exit(0);
			}
		n = ((int)(s.charAt(i))-48)*(int)(Math.pow(10, l-i-1)) + n;
		}
		return n;
	}
	public static void Error() {
		System.out.println("参数输入错误,游戏结束.");
	}
	public static String IandO() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入指令(输入'h'以获得帮助): "); 
		String s = input.next();
		while (true) {
			if (s.equals("a") || s.equals("s") || s.equals("d") || s.equals("w") || s.equals("h") || s.equals("k") || s.equals("p") || s.equals("c") || s.equals("b") || s.equals("q") || s.equals("x")) return s;
			else {
				System.out.println("非法输入!");
				System.out.print("请输入指令(输入'h'以获得帮助): ");
				s = input.next();
			}
		}
	}
	public static void Win() {
		System.out.println("恭喜，你赢了!");
		Player.Property();
		System.exit(0);
	}
	public static void Die() {
		System.out.println("抱歉，你死了.");
		System.out.println("游戏结束,以下是你的战绩:");
		Player.Property();
		System.exit(0);
	}
	public static void LevelUp(int t) {
		switch (t) {
		case 1: {
			System.out.println("恭喜,你已成功通过第一关.");
			System.out.println();
			System.out.println("欢迎来到第二关.在这一关中,魔王召唤出了许多爪牙来阻止你,小心别被他们攻击到.");
		}
		case 2: {
			System.out.println("恭喜,你已成功通过第二关.");
			System.out.println();
			System.out.println("欢迎来到第三关.在这一关中,你发现了魔王的宝藏,收集他们可以增加你的分数.");
		}
		case 3: {
			System.out.println("恭喜,你已成功通过第三关.");
			System.out.println();
			System.out.println("欢迎来到第四关.这将是游戏的最后一关，魔王施法让手下的爪牙们动了起来,你现在得一边收集宝藏一边对付会移动的怪物了.");
		}
		case 4: {
			System.out.println("恭喜,你已成功通过第四关.");
			System.out.println();
			System.out.println("你走出了魔王的迷宫并消灭了魔王,你是真正的勇者!");
		}
		default:  break;
		}
	}
	public static void Stop() {
			System.out.printf("\n\n");
			System.out.println("游戏结束,以下是你的战绩:");
			Player.Property();
			System.exit(0);
	}
}
