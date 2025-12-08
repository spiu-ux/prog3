class Seeds extends Item implements BirdFood{
    int nutrition=10;
    Seeds(){
        super("Seeds");
        super.cost=17.0f;
    }
    public int getNutrition(){
        return nutrition;
    }
}