package sim.u.duck.three.test;

/**
 * Created by Pankaj Nimgade on 31-01-2016.
 */
public class FlyNoWay implements FlyBehavior {

    public String TAG_CLASS_NAME = "FlyNoWings";

    public FlyNoWay() {
    }

    @Override
    public void fly() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " do not fly with this method " + name);
    }
}
