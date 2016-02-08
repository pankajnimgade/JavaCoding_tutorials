package sim.u.duck.four.test;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class Troll extends Charachter {

    public Troll() {
        weaponBehavior = new BowAndArrowBehavior();
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
