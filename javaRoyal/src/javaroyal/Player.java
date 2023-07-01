package javaroyal;

import java.util.*;

/**
 * a class by which presents a single player
 *
 * @author acer
 */
public class Player {

    private String name;
    private int money;
    private String[][] map;
    private int winTimes;
    private int loseTimes;
    private ArrayList<Soldier> soldiers;
    private ArrayList<Tank> tanks;
    private ArrayList<F22> f22s;
    private ArrayList<Toop106> toop106s;
    private ArrayList<S300> s300s;
    private ArrayList<Bomb> bombs;
    private HeadQuarter hq;
    
    //constructor
    public Player(String name) {
        this.name = name;
        //lose and win time at first are zero
        winTimes = 0;//number of times we won initialized to zero
        loseTimes = 0;//and also lose times
        //starting moneyis 1000
        money = 3000;
        //we should initialize map at first
        map = new String[3][];
        map[0] = new String[3];
        map[1] = new String[3];
        map[2] = new String[3];
        map[0][0] = "empty";
        map[0][1] = "empty";
        map[0][2] = "empty";
        map[1][0] = "empty";
        hq = new HeadQuarter();
        map[1][1] = "hq " + hq.getMaxHealth();
        map[1][2] = "empty";
        map[2][0] = "empty";
        map[2][1] = "empty";
        map[2][2] = "empty";
        //newing arraylists
        soldiers = new ArrayList<>();
        tanks = new ArrayList<>();
        f22s = new ArrayList<>();
        toop106s = new ArrayList<>();
        s300s = new ArrayList<>();
        bombs = new ArrayList<>();
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(int winTimes) {
        this.winTimes = winTimes;
    }

    public int getLoseTimes() {
        return loseTimes;
    }

    public void setLoseTimes(int loseTimes) {
        this.loseTimes = loseTimes;
    }

    public String[][] getMap() {
        return map;
    }

    //methods
    //number of items
    //f22
    public int f22Num() {
        return f22s.size();
    }

    //soldier
    public int soldierNum() {
        return soldiers.size();
    }

    //tanks
    public int tankNum() {
        return tanks.size();
    }

    //showing map
    public void showMap() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(map[i][j] + "      ");
            }
            System.out.println("");
        }
    }

    //adding defenders
    //adding toop106
    public void addToop106(Toop106 t, int i, int j) {
        if (this.map[i][j].equals("empty")) {
            if (this.money >= t.getCost()) {
                toop106s.add(t);
                this.money -= t.getCost();
                this.map[i][j] = "T " + t.getHealth();
            } else {
                System.err.println("not enought money");
            }
        } else {
            System.err.println("its full");
        }
    }

    //adding s300
    public void addS300(S300 s, int i, int j) {
        if (this.map[i][j].equals("empty")) {
            if (this.money >= s.getCost()) {
                s300s.add(s);
                this.money -= s.getCost();
                this.map[i][j] = "S " + s.getHealth();
            } else {
                System.err.println("not enought money");
            }
        } else {
            System.err.println("its full");
        }
    }

    //adding bomb
    public void addBomb(Bomb b, int i, int j) {
        if (this.map[i][j].equals("empty")) {
            if (this.money >= b.getCost()) {
                bombs.add(b);
                this.money -= b.getCost();
                this.map[i][j] = "B " + b.getHealth();
            } else {
                System.err.println("not enought money");
            }
        } else {
            System.err.println("its full");
        }
    }

    //attacking forces
    //soldier
    public void addSoldier(int number) {
        if (this.money >= 100 * number) {
            for (int i = 0; i < number; ++i) {
                soldiers.add(new Soldier());
            }
            this.money -= 100 * number;
        } else {
            System.err.println("not enough money");
        }
    }

    //tanks
    public void addTank(int number) {
        if (this.money >= 400 * number) {
            for (int i = 0; i < number; ++i) {
                tanks.add(new Tank());
            }
            this.money -= 400 * number;
        } else {
            System.err.println("not enough money");
        }
    }

    //f22
    public void addF22(int number) {
        if (this.money >= 800 * number) {
            for (int i = 0; i < number; ++i) {
                f22s.add(new F22());
            }
            this.money -= 800 * number;
        } else {
            System.err.println("not enough money");
        }
    }

    //attacking on a single block
    /**
     * attacking a single block
     * @param p2 another player
     * @param i  x
     * @param j  y
     */
    public void attack(Player p2, int i, int j) {
        if (p2.map[i][j].equals("empty")) {
            int d = 0;
        } else {
            while (this.soldiers.size() != 0 || this.tanks.size() != 0 || this.f22s.size() != 0) {
                String[] split = p2.map[i][j].split(" ");
                String type = split[0];
                String health = split[1];
                int health2 = Integer.valueOf(health);
                int damage = 0;
                if (type.equals("T")) {
                    damage = 300;
                }
                if (type.equals("S")) {
                    damage = 500;
                }
                if (type.equals("B")) {
                    damage = 750;
                }
                int total = 0;
                for (Soldier s : soldiers) {
                    total += s.getDamage();
                }
                for (Tank t : tanks) {
                    total += t.getDamage();
                }
                for (F22 f : f22s) {
                    total += f.getDamage();
                }
                int damageTmp = damage;
                if (total >= health2) {
                    while (soldiers.size() > 0 && damageTmp > 0) {
                        for (int f = 0; f < soldiers.size(); ++f) {
                            if (damageTmp > soldiers.get(f).getHealth()) {
                                //damageTmp -= soldiers.get(f).getHealth();
                                soldiers.remove(f);
                            } else {
                                soldiers.get(f).setHealth(10 - damageTmp);
                            }
                        }
                    }
                    while (tanks.size() > 0 && damageTmp > 0) {
                        for (int f = 0;f<tanks.size();++f) {
                            if (damageTmp > tanks.get(f).getHealth()) {
                                //damageTmp -= tanks.get(f).getHealth();
                                tanks.remove(f);
                            } else {
                                tanks.get(f).setHealth(100 - damageTmp);
                            }
                        }
                    }
                    while (f22s.size() > 0 && damageTmp > 0) {
                        for (int f = 0;f<f22s.size();++f) {
                            if (damageTmp > f22s.get(f).getHealth()) {
                                //damageTmp -= f22s.get(f).getHealth();
                                f22s.remove(f);
                            } else {
                                f22s.get(f).setHealth(50 - damageTmp);
                            }
                        }
                    }
                    this.money += 1000;
                    this.winTimes += 1;
                    p2.map[i][j] = "empty";
                    return;
                } else {
                    if (soldiers.size() > 0) {
                        while (soldiers.size() > 0 && damageTmp > 0) {
                            for (int f = 0; f < soldiers.size(); ++f) {
                                if (damageTmp > soldiers.get(f).getHealth()) {
                                    //damageTmp -= soldiers.get(f).getHealth();
                                    soldiers.remove(f);
                                } else {
                                    soldiers.get(f).setHealth(10 - damageTmp);
                                }
                            }
                        }
                    }
                    if (tanks.size() > 0) {
                        while (tanks.size() > 0 && damageTmp > 0) {
                              for (int f = 0;f<tanks.size();++f) {
                            if (damageTmp > tanks.get(f).getHealth()) {
                                //damageTmp -= tanks.get(f).getHealth();
                                tanks.remove(f);
                            } else {
                                tanks.get(f).setHealth(100 - damageTmp);
                            }
                        }
                        }
                    }
                    if (f22s.size() > 0) {
                        while (f22s.size() > 0 && damageTmp > 0) {
                            for (int f = 0;f<f22s.size();++f) {
                            if (damageTmp > f22s.get(f).getHealth()) {
                                //damageTmp -= f22s.get(f).getHealth();
                                f22s.remove(f);
                            } else {
                                f22s.get(f).setHealth(50 - damageTmp);
                            }
                        }
                        }
                    }
                    p2.winTimes += 1;
                    p2.money += 500;
                    p2.map[i][j] = type + " " + (health2 - total);
                }
            }
        }
    }

    /**
     * attacking whole map
     * @param p2 another player
     */
    public void titanAttack(Player p2) {
        this.attack(p2, 0, 0);
        this.attack(p2, 0, 1);
        this.attack(p2, 0, 2);
        this.attack(p2, 1, 2);
        this.attack(p2, 2, 2);
        this.attack(p2, 2, 1);
        this.attack(p2, 2, 0);
        this.attack(p2, 1, 0);
        this.attack(p2, 1, 1);
    }

    //healing
    public void heal(int i, int j) {
        if (map[i][j].equals("empty")) {
            System.err.println("empty");
        } else {
            String[] str = map[i][j].split(" ");
            String type = str[0];
            int cost = 3000;
            int health = 3000;
            if (type.equals("T")) {
                cost = 200;
                health = 500;
            }
            if (type.equals("S")) {
                cost = 300;
                health = 500;
            }
            if (type.equals("B")) {
                cost = 100;
                health = 1000;
            }
            if (this.money >= cost) {
                map[i][j] = type + " " + health;
            } else {
                System.err.println("not enough money");
            }
        }
    }

    /**
     * showing a remaining forces
     */
    //showing remaining force
    public void showRemaining() {
        System.out.println("soldiers: " + soldiers.size() + "\ntanks: " + tanks.size() + "\nf22s: " + f22s.size());
    }

}
