package sim.u.duck.test.one;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        TAG_CLASS_NAME = "RubberDuck";
    }

    @Override
    public void display() {
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }
}
