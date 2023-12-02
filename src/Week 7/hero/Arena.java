package hero;

public class Arena {
    public Hero fight(Hero hero1, Hero hero2) {

        if (hero1.equals(hero2)) {
            System.out.println("Man kann sich nicht selber angreifen");
            return null;
        }

        System.out.println("Die Stats der Duellanten sind wie folgt:");
        System.out.println(hero1.getName() + "-> HP: " + hero1.getHp() + " DMG: " + hero1.getEquippedDamage());
        System.out.println(hero2.getName() + "-> HP: " + hero2.getHp() + " DMG: " + hero2.getEquippedDamage());
        System.out.println();


        Hero winner = null;
        int attacker;
        int hero1LP = hero1.getHp();
        int hero2LP = hero2.getHp();
        int round = 1;

        while(true) {
            System.out.println("Es beginnt Runde " + round + "!");
            double rand = Math.random();
//          Angreifer greift zuerst an
            if (rand >= 0.5) {
                System.out.println(hero1.getName() + " greift " + hero2.getName() + " an!");
                attacker = 1;

                if (hero2LP <= hero1.getEquippedDamage()) {
                    winner = hero1;
                    break;
                } else {
                    hero2LP = hero2LP - hero1.getEquippedDamage();
                    System.out.println(hero2.getName() + " verbleiben noch " + hero2LP + " Leben!");
                }
            } else {
                attacker = 2;
                System.out.println(hero2.getName() + " greift " + hero1.getName() + " an!");
                if (hero1LP <= hero2.getEquippedDamage()) {
                    winner = hero2;
                    break;
                } else {
                    hero1LP = hero1LP - hero2.getEquippedDamage();
                    System.out.println(hero1.getName() + " verbleiben noch " + hero1LP + " Leben!");
                }
            }

//          Verteidiger greift als Nächstes an
            if (attacker == 1) {
                System.out.println(hero2.getName() + " greift " + hero1.getName() + " an!");
                if (hero1LP <= hero2.getEquippedDamage()) {
                    winner = hero2;
                    break;
                } else {
                    hero1LP = hero1LP - hero2.getEquippedDamage();
                    System.out.println(hero1.getName() + " verbleiben noch " + hero1LP + " Leben!");
                }
            } else {
                System.out.println(hero1.getName() + " greift " + hero2.getName() + " an!");
                if (hero2LP <= hero1.getEquippedDamage()) {
                    winner = hero1;
                    break;
                } else {
                    hero2LP = hero2LP - hero1.getEquippedDamage();
                    System.out.println(hero2.getName() + " verbleiben noch " + hero2LP + " Leben!");
                }
            }
            System.out.println();
            round++;
        }
        return winner;
    }
}
