package Equipement;


public class Quiver extends Equipement {
    private int arrowCount;
    private int arrowMax;

    public Quiver(String name, int arrowCount,int arrowMax) {
        super("Quiver");
        this.arrowCount = arrowCount;
        this.arrowMax = 35;
    }

    public boolean isEmpty(){
        return arrowCount == 0;
    }

    public boolean isFull(){
        return arrowCount == arrowMax;
    }

    public int spaceAvailableInQuiver(){
        return arrowMax - arrowCount;
    }

    public boolean shootArrow(){
       if(isEmpty()){
            System.out.println("No arrows left!");
            return false;
        } else {
            arrowCount--;
            System.out.println("Arrow shot! Arrows left: " + arrowCount);
            return true;
       }
    }

    public int addArrow(int amount){
        if(isFull()){
            System.out.println("Quiver is full!");
            return 0;
        }

        int spaceleft = spaceAvailableInQuiver();
        int addedArrows = Math.min(amount, spaceleft);
        arrowCount += addedArrows;
        System.out.println(addedArrows + " arrows added. Total arrows: " + arrowCount);
        return addedArrows;

    }

}
