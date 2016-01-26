package sim.u.duck.two.test;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        TAG_CLASS_NAME = "DecoyDuck";
    }

    @Override
    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }
}
