import java.util.Scanner;

public class Game {
	static int Nt = 0;
	static int Nm = 0;
	static boolean permission = true;
	static Player player;
	static Monster[] monster;
	static Treasure[] treasure;
	static int [][] map;
	static int difficulty = 1;
	static String mode;
	static boolean key = true;
	public static void main(String[] args) {
		Users.Initialization(args);
		Scanner input = new Scanner(System.in);
		Users.Welcome();
		player = new Player(Users.getName());
		if (mode.equals("Story")) Story();
		if (mode.equals("SandBox")) SandBox();
		if (mode.equals("Random")) Random();
	}
	public static void Story() {
		if (difficulty == 1) {
			System.out.println("�ܾúܾ���ǰ,����������һ��ħ��,���Ĵ�����,������������ڿ־�֮��.");
			System.out.println("ֱ����һ��,�������.����Ԥ��,���ǻ�ɱ��ħ����������������.");
			System.out.println("̤�����̰�!");
			System.out.printf("\n\n");
		}
		while (difficulty < 5) {
			map = Map.Getmap(difficulty);
			while (key) {
				if (permission) Map.Print();
				String order = Users.IandO();
				Event.go(order);
			}
			Users.LevelUp(difficulty);
			difficulty = difficulty + 1;
		}
		Users.Stop();
	}
	public static void SandBox() {
		
	}
	public static void Random() {
		
	}
}
