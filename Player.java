
public class Player extends Game{
	String Name;
	int HP = 3;
	int PX = 1;
	int PY = 1;
	int Point = 1000;
	int Kill = 0;
	int Treasure = 0;
	 int Pace = 0;
	public Player(String name) {
		Name = name;
	}
	public static void Property() {
		System.out.println("�������: "+player.Name);
		System.out.println("��ķ���: "+player.Point);
		System.out.println("��Ĳ���: "+player.Pace);
		System.out.println("���ɱ�Ĺ�����: "+player.Kill);
		System.out.println("���õı�����: "+player.Treasure);
		System.out.printf("\n\n");
	}
}