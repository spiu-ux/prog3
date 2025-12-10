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
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == this.getClass();
    }
}