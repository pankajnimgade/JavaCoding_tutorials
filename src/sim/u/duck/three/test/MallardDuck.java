package sim.u.duck.three.test;

/**
 * Created by Pankaj Nimgade on 01-02-2016.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
        TAG_CLASS_NAME = "MallardDuck";
    }

    @Override
    public void swim() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

    @Override
    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }
}
