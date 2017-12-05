
public class Monster extends Game{
	int PX = 1;
	int PY = 1;
	int Money;
	public Monster() {
		PX = 1;
		PY = 1;
		Money = (int)(Math.random()*100)+300;
	}
	public Monster(int r, int c){
		while ((PX == 1 && PY == 10)||(PX == r-2 && PY == c-2))
		{
			PX = (int)(Math.random()*(r-3))+1;
			PY = (int)(Math.random()*(c-3))+1;
		}
		Money = (int)(Math.random()*100)+300;
	}
	public static void AutoMove() {
		for (int i = 0; i < Nm; i++) {
			int t;
			int d = 0;
			boolean [] size = new boolean[4];
			for (int l = 0; l < 4; l++) size[l] = true;
			boolean m = true;
			int j = monster[i].PX;
			int k = monster[i].PY;
			while (m&&(size[0]||size[1]||size[2]||size[3])) {
				t = (int)(Math.random()*4);
				switch (t) {
				case 0 : if ((map[j-1][k] == 0)||(map[j-1][k] == 2)||(map[j-1][k] == 3)||(map[j-1][k] == 6)) {
						monster[i].PX = monster[i].PX-1;
						m = false;
					}
					else size[t] = false;
				break;
				case 1 :if ((map[j+1][k] == 0)||(map[j+1][k] == 2)||(map[j+1][k] == 3)||(map[j+1][k] == 6)) {
						monster[i].PX = monster[i].PX+1;
						m = false;
					}
					else size[t] = false;
				break;
				case 2 : if ((map[j][k-1] == 0)||(map[j][k-1] == 2)||(map[j][k-1] == 3)||(map[j][k-1] == 6)) {
						monster[i].PY = monster[i].PY-1;
						m = false;
					}
					else size[t] = false;
				break;
				case 3 : if ((map[j][k+1] == 0)||(map[j][k+1] == 2)||(map[j][k+1] == 3)||(map[j][k+1] == 6)) {
						monster[i].PY = monster[i].PY+1;
						m = false;
					}
					else size[t] = false;
				break;
				default : break;
				}
			}
		}
	}
	public static void Get(int m) {
		for (int i = m; i < Nm; i++)
			monster[i]= monster[i+1];
		Nm = Nm - 1;
	}
	
	public static void Set(int x, int y) {
		monster[Nm].PX = x;
		monster[Nm].PY = y;
		Nm = Nm + 1;
	}
}