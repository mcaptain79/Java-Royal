package javaroyal;

import java.util.*;

public class JavaRoyal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player p1 = new Player("player1");
        Player p2 = new Player("player2");
        Player p;
        ShowList s = new ShowList();
        boolean b = true;
        p = p1;
        while (b) {
            if (p == p1) {
                System.out.println("player1 role");
            } else {
                System.out.println("player2 role");
            }
            s.show();
            String option;
            String defenceAdd;
            option = sc.nextLine();
            switch (option) {
                case "1":
                    defenceAdd = sc.nextLine();
                    String[] str = defenceAdd.split(" ");
                    String type = str[0];
                    int x = Integer.valueOf(str[1]);
                    int y = Integer.valueOf(str[2]);
                    if (type.equals("T")) {
                        p.addToop106(new Toop106(), x, y);
                    }
                    if (type.equals("B")) {
                        p.addBomb(new Bomb(), x, y);
                    }
                    if (type.equals("S")) {
                        p.addS300(new S300(), x, y);
                    }
                    break;
                case "2":
                    p.showMap();
                    break;
                case "3":
                    p.showRemaining();
                    break;
                case "4":
                    if (p == p1) {
                        p1.titanAttack(p2);
                    } else {
                        p2.titanAttack(p1);
                    }
                    break;
                case "5":
                    System.out.println(p.getMoney());
                    break;
                case "6":
                    if (p == p1) {
                        p2.showMap();
                    } else {
                        p1.showMap();
                    }
                    break;
                case "7":
                    String input2 = sc.nextLine();
                    String[] split2 = input2.split(" ");
                    int a = Integer.valueOf(split2[1]);
                    if (split2[0].equals("S")) {
                        p.addSoldier(a);
                    }
                    if (split2[0].equals("T")) {
                        p.addTank(a);
                    }
                    if (split2[0].equals("F")) {
                        p.addF22(a);
                    }
                    break;
                case "8":
                    String input = sc.nextLine();
                    String[] split = input.split(" ");
                    x = Integer.valueOf(split[0]);
                    y = Integer.valueOf(split[1]);
                    p.heal(x, y);
                    break;
                case "9":
                    if (p == p1) {
                        p = p2;
                    } else {
                        p = p1;
                    }
                    break;
                default:
                    System.err.println(":(");
                    break;
            }
            if (p1.getWinTimes() == 3 || p2.getWinTimes() == 3) {
                b = false;
            }
        }
        if (p1.getWinTimes() == 3) {
            System.out.println("player1 won");
        } else {
            System.out.println("player2 won");
        }

    }

}
