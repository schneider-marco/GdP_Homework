package hero;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){

        Hero hero1 = new Hero("Gertrude", 200, 50);
        Hero gandalf = new Hero("Gandalf", 200, 31);

        Item item1 = new Item("Eisenschwert", 7);
        Item item2 = new Item("Juckpulver", 1);

        hero1.insertItem(item1);
        hero1.insertItem(item2);

//        hero1.attackEquipped(gandalf);

        Arena sandkasten = new Arena();
        Hero winner = sandkasten.fight(hero1, gandalf);
        if (winner != null) {
            System.out.println("Der Gewinner des Kampfes ist: " + winner.getName());
        }
    }
}
