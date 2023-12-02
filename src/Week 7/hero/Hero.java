package hero;

public class Hero {

    private String name;
    private final int hp;
    private final int dmg;
    private Item[] itemInv = new Item[6];

    public Hero(String name, int hp, int dmg){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
    }

    public Hero(String name, int hp, int dmg, int itemInvSize){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.itemInv = new Item[itemInvSize];
    }

    public void attackEquipped(Hero hero) {
        System.out.println(this.getName() + " greift an!");
        System.out.println("Hero '" + hero.getName()  + "': " + hero.getHp() + "H - " + this.getEquippedDamage() + "H -> " + (hero.getHp()-this.getEquippedDamage()) + "H");
    }

    public boolean insertItem(Item item){
        for (int i = 0; i < itemInv.length; i++){
            if (itemInv[i] == null){
                itemInv[i] = item;
                return true;
            }
        }
        return false;
    }

    public void printEquipment(){
        System.out.println("Equipment for Hero '" + this.name + "':");
        for (int i = 0; i < itemInv.length; i++) {
            if (itemInv[i] == null){
                return;
            }
            System.out.println("* Item '" + itemInv[i].getName() + "' (ID: " + itemInv[i].getID() + "): +" + itemInv[i].getDmgPoints() + " D");
        }
    }

    public int getEquippedDamage(){
        int totalDmg = this.getDmg();

        for (int i = 0; i < itemInv.length; i++) {
            if (itemInv[i] == null){
                continue;
            }
            totalDmg = totalDmg + itemInv[i].getDmgPoints();
        }
        return totalDmg;
    }

    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public int getDmg(){
        return this.dmg;
    }

    public boolean setName(String name){
        if (!name.isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public void printInfo(){
        System.out.println("Hero '" + this.name + "' H: " + this.hp + " D: " + this.dmg);
    }

}
