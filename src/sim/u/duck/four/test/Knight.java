package sim.u.duck.four.test;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class Knight extends Charachter {

    public Knight() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
