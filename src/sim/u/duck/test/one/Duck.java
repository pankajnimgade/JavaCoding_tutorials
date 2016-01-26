package sim.u.duck.test.one;

/**
 * Created by Pankaj Nimgade on 19-01-2016.
 *
 * If you add fly behavior to the Duck super class all subclasses will inherit that behavior
 * even if the class should not have flying behavior (example RubberDuck, DecoyDuck)
 */
public class Duck {

    public String TAG_CLASS_NAME = "Duck";

    public Duck() {
    }


    public void quack() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

    public void swim() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);

    }

    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

    public void fly() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

}
