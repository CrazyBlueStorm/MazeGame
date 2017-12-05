
public class Event extends Game{
	public static void go(String s) {
		if (s.equals("h")) Help();
		if ((s.equals("w"))||(s.equals("s"))||(s.equals("a"))||(s.equals("d"))) SetPosition(s);
		if (s.equals("p")) Test.TestTreasure(player.PX,player.PY);
		if (s.equals("k")) Test.TestMonster(player.PX,player.PY);
		if (s.equals("b")) Back();
		if (s.equals("c")) {
			permission = false;
			player.Property();
		}
		if (s.equals("q") || s.equals("x")) Users.Stop();
	}
	public static void SetPosition(String s) {
		if (s.equals("w")) {
			if (Test.TestMap(player.PX-1,player.PY)) {
				player.PX = player.PX - 1;
				player.Pace = player.Pace + 1;
				player.Point = player.Point - 10;
			}
			else Users.Wall();
		}
		else if (s.equals("s")) {
			if (Test.TestMap(player.PX+1,player.PY)) {
				player.PX = player.PX + 1;
				player.Pace = player.Pace + 1;
				player.Point = player.Point - 10;
			}
			else Users.Wall();
		}
		else if (s.equals("a")) {
			if (Test.TestMap(player.PX,player.PY-1)) {
				player.PY = player.PY - 1;
				player.Pace = player.Pace + 1;
				player.Point = player.Point - 10;
			}
			else Users.Wall();
		}
		else if (s.equals("d")) {
			if (Test.TestMap(player.PX,player.PY+1)) {
				player.PY =player.PY + 1;
				player.Pace = player.Pace + 1;
				player.Point = player.Point - 10;
			}
			else Users.Wall();
		}
	}
	public static void Back() {
		if(player.turns > 0) {
		player.PX = player.Footprint[0][player.turns-1];
		player.PY = player.Footprint[1][player.turns-1];
		}
		player.Pace = player.Pace - 1;
		player.Point = player.Point - 10;
	}
	public static void Help() {
		System.out.printf("\n");
		System.out.println("��ϷĿ��:�������½ǵ��յ�,�߳��Թ�");
		System.out.println();
		System.out.println("��ͼ���ű�ʶ:");
		System.out.println("  ��    ǽ");
		System.out.println("  ��    ����");
		System.out.println("  ��    �յ�");
		System.out.println("  ��    ��ӡ");
		System.out.println("  ��    ����");
		System.out.println("  ��    ����");
		System.out.printf("\n");
		System.out.println("��Ϸָ�����:");
		System.out.println("  h,����:��ʾ��������");
		System.out.println("  w,��:������");
		System.out.println("  s,��:������");
		System.out.println("  a,��:������");
		System.out.println("  d,��:������");
		System.out.println("  k,����:ɱ��������Χ�Ĺ���");
		System.out.println("  p,��ȡ:����������Χ�ı���");
		System.out.println("  c,�鿴:�鿴�������Ϣ");
		System.out.println("  b,����:�˺�ǰһ�����λ��");
		System.out.println("  q,�˳�:������ε���Ϸ���˳�");
		System.out.println("  x,����:���˳���ͬ");
		System.out.printf("\n\n");
		permission = false;
	}
}
