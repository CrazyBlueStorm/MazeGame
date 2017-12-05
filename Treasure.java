
public class Treasure extends Game{
	int PX = 1;
	int PY = 1;
	int Money;
	public Treasure() {
		PX = 1;
		PY = 1;
		Money = (int)(Math.random()*100)+200;
	}
	public Treasure(int r, int c){
		while ((PX == 1 && PY == 10)||(PX == r-2 && PY == c-2))
		{
			PX = (int)(Math.random()*(r-3))+1;
			PY = (int)(Math.random()*(c-3))+1;
		}
		Money = (int)(Math.random()*100)+200;
	}
	public static void Get(int m) {
		for (int i = m; i < Nt; i++)
			treasure[i] = treasure[i+1];
		Nt = Nt - 1;
	}
	public static void Set(int x, int y) {
		treasure[Nt].PX = x;
		treasure[Nt].PY = y;
		Nt = Nt + 1;
	}
}
