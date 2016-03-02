package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 28-02-2016.
 */
public abstract class Beverage {

    private String description = "Unknown Beverage";


    abstract float getCost();


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
