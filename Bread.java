class Bread extends Item implements BirdFood{
    int nutrition=20;
    Bread(){
        super("Bread");
        super.cost=20.0f;
    }
    public int getNutrition(){
        return nutrition;
    }
}