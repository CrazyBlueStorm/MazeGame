
public class FootPrint extends Game{
	public static void Foot(String s) {
		if (s.equals("b")) {
			if (player.turns == 0) {
				System.out.println("已撤回到最初位置,无法继续后撤.");
			}
			else {
				player.FP2 = player.FP1;
				player.FP1 = player.turns;
				player.turns = player.turns -1;
				player.Footprint[0][player.turns] = player.PX;
				player.Footprint[1][player.turns] = player.PY;
			}
		}
		else {
			player.FP2 = player.FP1;
			player.FP1 = player.turns;
			player.turns = player.turns+1;
			if (player.turns >= player.Footprint.length) player.Extends();
			player.Footprint[0][player.turns] = player.PX;
			player.Footprint[1][player.turns] = player.PY;
		}
	}
}
