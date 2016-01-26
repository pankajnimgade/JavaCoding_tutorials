package sim.u.duck.two.test;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class MallardDuck extends Duck implements Flyable, Quackable {

    public MallardDuck() {
        TAG_CLASS_NAME = "MallardDuck";
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
