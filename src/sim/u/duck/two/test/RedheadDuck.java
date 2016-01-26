package sim.u.duck.two.test;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class RedheadDuck extends Duck implements Flyable, Quackable{

    public RedheadDuck() {
        TAG_CLASS_NAME = "RedheadDuck";
    }

    @Override
    public void fly() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

    @Override
    public void quack() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }
}
