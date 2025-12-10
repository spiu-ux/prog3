package items;

public class Seeds extends Item implements BirdFood{
    int nutrition=10;
    public Seeds(){
        super("Seeds");
        super.cost=17.0f;
    }
    public int getNutrition(){
        return nutrition;
    }
}