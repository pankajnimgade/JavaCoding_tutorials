package sim.u.duck.four.test;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class TestDriveCharacters {

    public static void main(String[] args){

        Charachter king = new King();
        king.fight();

        Charachter queen = new Queen();
        queen.fight();
        queen.setWeaponBehavior(new BowAndArrowBehavior());
        queen.fight();
        queen.setWeaponBehavior(new AxeBehavior());
        queen.fight();
    }
}
