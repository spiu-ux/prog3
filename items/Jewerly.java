package items;
import pers.*;

public class Jewerly extends Item{

    public Jewerly(String name) {
        super("Jewerly: "+name);
        super.cost=250.0F;
    }
    
    public void wear(Persona person){
        person.setMood(Mood.HAPPY);
    }
    
}