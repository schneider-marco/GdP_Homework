package hero;

public class Hero {

    private String name;
    private int hp;
    private int dmg;

    public Hero(String name, int hp, int dmg){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
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
