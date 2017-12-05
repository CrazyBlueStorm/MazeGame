
public class Test extends Game{
	public static boolean TestMap(int x, int y) {
		if (map[x][y] == 1) return false;
		else return true;
	}
	public static boolean TestTreasure(int x, int y) {
		boolean t = false;
		for (int i = 0; i < Nt; i ++) {
			if ((treasure[i].PX == x+1)&&(treasure[i].PY == y)) {
				player.Treasure = player.Treasure+1;
				player.Point = player.Point + treasure[i].Money;
				Treasure.Get(i);
				t = true;
			}
			if ((treasure[i].PX == x-1)&&(treasure[i].PY == y)) {
				player.Treasure = player.Treasure+1;
				player.Point = player.Point + treasure[i].Money;
				Treasure.Get(i);
				t = true;
			}
			if ((treasure[i].PX == x)&&(treasure[i].PY == y-1)) {
				player.Treasure = player.Treasure+1;
				player.Point = player.Point + treasure[i].Money;
				Treasure.Get(i);
				t = true;
			}
			if ((treasure[i].PX == x)&&(treasure[i].PY == y+1)) {
				player.Treasure = player.Treasure+1;
				player.Point = player.Point + treasure[i].Money;
				Treasure.Get(i);
				t = true;
			}
		}
		return t;
	}
	public static boolean TestMonster(int x, int y) {
		boolean t = false;
		for (int i = 0; i < Nm; i ++) {
			if ((monster[i].PX == x+1)&&(monster[i].PY == y)) {
				player.Kill = player.Kill+1;
				player.Point = player.Point + monster[i].Money;
				Monster.Get(i);
				t = true;
			}
			if ((monster[i].PX == x-1)&&(monster[i].PY == y)) {
				player.Kill = player.Kill+1;
				player.Point = player.Point + monster[i].Money;
				Monster.Get(i);
				t = true;
			}
			if ((monster[i].PX == x)&&(monster[i].PY == y-1)) {
				player.Kill = player.Kill+1;
				player.Point = player.Point + monster[i].Money;
				Monster.Get(i);
				t = true;
			}
			if ((monster[i].PX == x)&&(monster[i].PY == y+1)) {
				player.Kill = player.Kill+1;
				player.Point = player.Point + monster[i].Money;
				Monster.Get(i);
				t = true;
			}
		}
		return t;
	}
	public static void Testalive() {
		for(int i = 0; i < Nm; i++)
			if ((monster[i].PX == player.PX)&&(monster[i].PY == player.PY)) Users.Die();
	}
}
