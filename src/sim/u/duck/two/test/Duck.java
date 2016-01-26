package sim.u.duck.two.test;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 *
 * This is, like, the dumbest idea you've come up with. Can you say "duplicate code"?
 * if you thought having to override a few method was bad, How are you gonna feel when
 * you need to make little change to the flying behavior... in all 48 of flying Duck subclasses
 */
public class Duck {

    public String TAG_CLASS_NAME = "Duck";

    public Duck() {
    }

    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }

    public void swim() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println(TAG_CLASS_NAME + " " + name);
    }


}
