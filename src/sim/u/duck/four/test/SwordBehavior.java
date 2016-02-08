package sim.u.duck.four.test;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class SwordBehavior implements WeaponBehavior {

    private static final String TAG_CLASS_NAME = "SwordBehavior";

    @Override
    public void useWeapon() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " fight " + name);
    }
}
