package items;

public class Bread extends Item implements BirdFood{
    int nutrition=20;
    public Bread(){
        super("Bread");
        super.cost=20.0f;
    }
    public int getNutrition(){
        return nutrition;
    }
}