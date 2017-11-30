import java.util.Scanner;

public class Game {
	static int Nt = 0;
	static int Nm = 0;
	static boolean permission = true;
	static Player player;
	static Monster[] monster = new Monster[20];
	static Treasure[] treasure = new Treasure[20];
	static int [][] map;
	static int difficulty = 1;
	static String mode;
	static boolean key = true;
	public static void main(String[] args) {
		Users.Initialization(args);
		Scanner input = new Scanner(System.in);
		player = new Player(Users.getName());
		if (mode.equals("story")) Story();
		if (mode.equals("sandBox")) SandBox();
		if (mode.equals("random")) Random();
	}
	public static void Story() {
		if (difficulty == 1) {
			System.out.println("很久很久以前,村子里来了一个魔王,他四处吃人,百姓们整天活在恐惧之中.");
			System.out.println("直到有一天,你出现了.根据预言,你是会杀死魔王带来光明的勇者.");
			System.out.println("踏上征程吧!");
			System.out.printf("\n\n");
		}
		while (difficulty < 5) {
			map = Map.Getmap(difficulty);
			key = true;
			player.PX = 1;
			player.PY = 1;
			while (key) {
				if (permission) Map.Print();
				String order = Users.IandO();
				Event.go(order);
				if ((player.PX == map.length-2)&&(player.PY == map[0].length-2))Users.LevelUp(difficulty);
			}
			difficulty = difficulty + 1;
		}
		Users.Stop();
	}
	public static void SandBox() {
		
	}
	public static void Random() {
		while (key) {
			if (permission) Map.Print();
			String order = Users.IandO();
			Event.go(order);
		}
	}
}
