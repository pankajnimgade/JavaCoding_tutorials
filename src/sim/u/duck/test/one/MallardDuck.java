package sim.u.duck.test.one;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
            TAG_CLASS_NAME = "MallardDuck";
    }

    @Override
    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }
}
