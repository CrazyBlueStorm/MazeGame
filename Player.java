
public class Player extends Game{
	String Name;
	int HP = 3;
	int PX = 1;
	int PY = 1;
	int Point = 3000;
	int Kill = 0;
	int Treasure = 0;
	int Pace = 0;
	int [][] Footprint = new int [2][10];
	int FP1 = -1;
	int FP2 = -1;
	int turns = 0;
	public Player(String name) {
		Name = name;
		Footprint[0][0] = 1;
		Footprint[1][0] = 1;
	}
	public static void Property() {
		System.out.println("�������: "+player.Name);
		System.out.println("��ķ���: "+player.Point);
		System.out.println("��Ĳ���: "+player.Pace);
		System.out.println("���ɱ�Ĺ�����: "+player.Kill);
		System.out.println("���õı�����: "+player.Treasure);
		System.out.printf("\n\n");
	}
	public static void Extends() {
		int[][] t = new int [2][player.turns];
		for(int i = 0; i < player.turns; i++) {
			t[0][i] = player.Footprint[0][i];
			t[1][i] = player.Footprint[1][i];
		}
		player.Footprint = new int [2][player.turns*2];
		for (int i = 0; i< player.turns; i++) {
			player.Footprint[0][i] = t[0][i];
			player.Footprint[1][i] = t[1][i];
		}
	}
}