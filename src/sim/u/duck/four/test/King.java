package sim.u.duck.four.test;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class King extends Charachter {

    public King() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
