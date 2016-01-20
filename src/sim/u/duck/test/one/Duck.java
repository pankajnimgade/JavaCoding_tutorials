package sim.u.duck.test.one;

/**
 * Created by Pankaj Nimgade on 19-01-2016.
 */
public class Duck {

    public String TAG_CLASS_NAME;

    public Duck() {
        TAG_CLASS_NAME = this.getClass().getSimpleName();
    }

    public void quack() {
        System.out.println(TAG_CLASS_NAME + " quack");

    }

    public void swim() {
        System.out.println("" + TAG_CLASS_NAME);

    }

    public void display() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println("" + TAG_CLASS_NAME);
    }


}
