
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
		System.out.println("你的名字: "+player.Name);
		System.out.println("你的分数: "+player.Point);
		System.out.println("你的步数: "+player.Pace);
		System.out.println("你击杀的怪物数: "+player.Kill);
		System.out.println("你获得的宝物数: "+player.Treasure);
		System.out.printf("\n\n");
	}
}