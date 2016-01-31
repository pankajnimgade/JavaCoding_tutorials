package sim.u.duck.three.test;

/**
 * Created by Pankaj Nimgade on 31-01-2016.
 */
public class Quack implements QuackBehavior {

    public String TAG_CLASS_NAME = "Quack";


    public Quack() {
    }

    @Override
    public void quack() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }
}
