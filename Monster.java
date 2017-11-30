
public class Monster extends Game{
	int PX = 1;
	int PY = 1;
	int Money;
	public Monster(int r, int c){
		while ((PX == 1 && PY == 10)||(PX == r-2 && PY == c-2))
		{
			PX = (int)(Math.random()*(r-3))+1;
			PY = (int)(Math.random()*(c-3))+1;
		}
		Money = (int)(Math.random()*100)+300;
	}
	public static void AutoMove() {
		int n = 0;
		int [][] monster = new int[2][500];
		for (int i = 1; i < 29; i++)
			for (int j = 1; j < 29; j++)
				if (map[i][j] == 4) {
					int t;
					int d = 0;
					boolean m = true;
					while (m) {
						t = (int)(Math.random()*4)+1;
						switch (t) {
						case 1 : if ((map[i-1][j] == 0)||(map[i-1][j] == 2)||(map[i-1][j] == 3)) {
							map[i][j] = 0;
							map[i-1][j] = 4;
							m = false;
						}
						else d = d + 1;
						break;
						case 2 : if ((map[i+1][j] == 0)||(map[i+1][j] == 2)||(map[i+1][j] == 3)) {
							map[i][j] = 0;
							map[i+1][j] = 4;
							m = false;
						}
						else d = d + 1;
						break;
						case 3 : if ((map[i][j-1] == 0)||(map[i][j-1] == 2)||(map[i][j-1] == 3)) {
							map[i][j] = 0;
							map[i][j-1] = 4;
							m = false;
						}
						else d = d + 1;
						break;
						case 4 :if ((map[i][j+1] == 0)||(map[i][j+1] == 2)||(map[i][j+1] == 3)) {
							map[i][j] = 0;
							map[i][j+1] = 4;
							m = false;
						}
						else d = d + 1;
						break;
						default : break;
						}
						if (d == 4) m = false;
					}
				}
		}
	public static void Get(int m) {
		for (int i = m; i < Nm; i++)
			monster[i]= monster[i+1];
		Nm = Nm - 1;
	}
}