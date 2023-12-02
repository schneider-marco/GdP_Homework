package hero;

public class Item {
    private final String name;
    private final int dmgPoints;
    private final int ID;
    static int classCount = 0;
    public Item(String name, int dmgPoints) {

        this.name = name;

        this.ID = classCount;
        classCount++;

        if (dmgPoints <= 100 && dmgPoints >= 0){
            this.dmgPoints = dmgPoints;
        } else {
            this.dmgPoints = (int) (Math.random() * 100);
        }
    }

    public String getName(){
        return this.name;
    }

    public int getDmgPoints(){
        return this.dmgPoints;
    }

    public int getID(){
        return this.ID;
    }

    public void printInfo(){
        System.out.println("Item '" + this.name + "' (ID: " + this.ID + "): +" + this.dmgPoints + " D");
    }
}
