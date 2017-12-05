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
		if (order[0].equals("-mode")==false) Error();
		else {
			mode = order[1];
			if (mode.equals("sandbox")) {
				if ((order[2].substring(0,4).equals("-map")==false)||(n>4)) Error();
				difficulty = getInt(order[2].substring(4));
				if ((difficulty == 0)||(difficulty > 4)) {
					System.out.println("层数选择超出范围，游戏结束");
					System.exit(0);
				}
				else map = Map.Getmap(difficulty);
			}
			else if (mode.equals("random")) {
				if ((order[2].equals("-r")==false)||(order[4].equals("-c")==false)||(n>6)) Error();
				r = getInt(order[3].substring(0));
				c = getInt(order[5].substring(0));
				if ((r<3)||(c<3)) {
					System.out.println("迷宫过小，游戏结束");
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
				System.out.println("未知模式命令，游戏结束");
				System.exit(0);
			}
			System.out.println("你已选择 "+mode+" 模式");
			System.out.printf("\n\n");
		}
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
		System.exit(0);
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
				if (pmap[i][j]== 1) System.out.print("▓");
				if (pmap[i][j]== 2) System.out.print("♀");
				if (pmap[i][j]== 3) System.out.print("·");
				if (pmap[i][j]== 4) System.out.print("¤");
				if (pmap[i][j]== 5) System.out.print("※");
				if (pmap[i][j]== 6) System.out.print("￥");
			}
			System.out.println();
		}
		System.out.println("抱歉，你死了.");
		System.out.println("游戏结束,以下是你的战绩:");
		Player.Property();
		System.exit(0);
	}
	public static void LevelUp(int t) {
		switch (t) {
		case 0: {
			System.out.println("很久很久以前,村子里来了一个魔王,他四处吃人,百姓们整天活在恐惧之中.");
			System.out.println("直到有一天,你出现了.根据预言,你是会杀死魔王带来光明的勇者.");
			System.out.println("踏上征程吧!");
		}
		case 1: {
			if (mode.equals("story")) System.out.println("恭喜,你已成功通过第一关.");
			System.out.println();
			System.out.println("欢迎来到第二关.在这一关中,魔王召唤出了许多爪牙来阻止你,小心别被他们攻击到.");
			key = false;
		}break;
		case 2: {
			if (mode.equals("story")) System.out.println("恭喜,你已成功通过第二关.");
			System.out.println();
			System.out.println("欢迎来到第三关.在这一关中,你发现了魔王的宝藏,收集他们可以增加你的分数.");
			key = false;
		}break;
		case 3: {
			if (mode.equals("story")) System.out.println("恭喜,你已成功通过第三关.");
			System.out.println();
			System.out.println("欢迎来到第四关.这将是游戏的最后一关，魔王施法让手下的爪牙们动了起来,你现在得一边收集宝藏一边对付会移动的怪物了.");
			key = false;
		}break;
		case 4: {
			if (mode.equals("story")) System.out.println("恭喜,你已成功通过第四关.");
			System.out.println();
			System.out.println("你走出了魔王的迷宫并消灭了魔王,你是真正的勇者!");
			Win();
		}break;
		default:  break;
		}
	}
	public static void Stop() {
			System.out.printf("\n\n");
			System.out.println("游戏结束,以下是你的战绩:");
			Player.Property();
			System.exit(0);
	}
	public static void Wall() {
		System.out.println("对不起,此处有墙.");
		permission = false;
	}
	public static void EvenNumber() {
		System.out.println("输入地图宽和长需为奇数,游戏结束.");
		System.exit(0);
	}
}
