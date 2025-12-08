class Jewerly extends Item{

    Jewerly(String name) {
        super("Jewerly: "+name);
        super.cost=250.0F;
    }
    
    void wear(Persona person){
        person.setMood(Mood.HAPPY);
    }
    
}