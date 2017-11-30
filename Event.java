
public class Event extends Game{
	public static void go(String s) {
		if (s.equals("h")) Help();
		if ((s.equals("w"))||(s.equals("s"))||(s.equals("a"))||(s.equals("d"))) SetPosition(s);
		if (s.equals("b")) Back();
		if (s.equals("p")) Test.TestTreasure(player.PX,player.PY);
		if (s.equals("q") || s.equals("x")) Users.Stop();
	}
	public static void SetPosition(String s) {
		if (s.equals("w")) {
			if (Test.TestMap(player.PX-1,player.PY)) {
				player.PX = player.PX - 1;
			}
		}
		if (s.equals("s")) {
			if (Test.TestMap(player.PX+1,player.PY)) {
				player.PX = player.PX + 1;
			}
		}
		if (s.equals("a")) {
			if (Test.TestMap(player.PX,player.PY-1)) {
				player.PY = player.PY - 1;
			}
		}
		if (s.equals("d")) {
			if (Test.TestMap(player.PX,player.PY+1)) {
				player.PY =player.PY + 1;
			}
		}
		if (s.equals("p")) {
			if (Test.TestTreasure(player.PX+1,player.PY)) {
				map[player.PX+1][player.PY] = 0;
				player.Treasure = player.Treasure + 1;
			}
			if (Test.TestTreasure(player.PX-1,player.PY)) {
				map[player.PX-1][player.PY] = 0;
				player.Treasure = player.Treasure + 1;
			}
			if (Test.TestTreasure(player.PX,player.PY+1)) {
				map[player.PX][player.PY+1] = 0;
				player.Treasure = player.Treasure + 1;
			}
			if (Test.TestTreasure(player.PX,player.PY-1)) {
				map[player.PX][player.PY-1] = 0;
				player.Treasure = player.Treasure + 1;
			}
		}
	}
	public static void Help() {
		System.out.printf("\n");
		System.out.println("游戏目标:到达右下角的终点,走出迷宫");
		System.out.println();
		System.out.println("地图符号标识:");
		System.out.println("  ▓    墙");
		System.out.println("  ♀    人物");
		System.out.println("  ※        终点");
		System.out.println("  ·    脚印");
		System.out.println("  ¤    怪物");
		System.out.println("  ￥      宝物");
		System.out.printf("\n");
		System.out.println("游戏指令介绍:");
		System.out.println("  h,帮助:显示帮助界面");
		System.out.println("  w,北:向上走");
		System.out.println("  s,南:向下走");
		System.out.println("  a,西:向左走");
		System.out.println("  d,东:向右走");
		System.out.println("  k,攻击:杀死人物周围的怪物");
		System.out.println("  p,捡取:捡起人物周围的宝物");
		System.out.println("  c,查看:查看人物的信息");
		System.out.println("  b,后退:退后到前一步你的位置");
		System.out.println("  q,退出:放弃这次的游戏并退出");
		System.out.println("  x,结束:和退出相同");
		System.out.printf("\n\n");
	}
}
