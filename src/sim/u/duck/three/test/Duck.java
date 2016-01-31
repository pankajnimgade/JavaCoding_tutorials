package sim.u.duck.three.test;

/**
 * Created by Pankaj Nimgade on 27-01-2016.
 */
public class Duck {

    public String TAG_CLASS_NAME = "Duck";

    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void swim() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }


}
