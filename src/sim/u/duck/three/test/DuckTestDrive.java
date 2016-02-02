package sim.u.duck.three.test;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 01-02-2016.
 *
 */
public class DuckTestDrive {

    public static void main(String[] args){
        Duck duck = new MallardDuck();
        duck.display();
        duck.swim();
        duck.performFly();
        duck.performQuack();
        System.out.println();

        ArrayList<Category> categories = new ArrayList<>();
        Response response = new Response();
        for (int i = 0; i < 5; i++) {
            Category category = new Category();
            category.setId("0"+i);
            category.setName("Some_name_"+i);
            categories.add(category);
        }
        response.setCategories(categories);

//        System.out.println(""+(new Gson()).toJson(response));
    }



}
class Response {
    ArrayList<Category> categories;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}

class Category{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
