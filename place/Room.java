package place;
import birds.*;
import pers.*;

public class Room extends Location{
    public Window window;
    private float dirtiness;
    public boolean hasWindow = false;

    public class Window{
        public boolean isFrozen = Location.season == Season.WINTER;
        public Bullfinch bullfinch;
    }

    public Room(String name){
        super(name);
    }
    float getDirtiness() {
        return this.dirtiness;
    }
    int countPeople(){
        return people.size();
    }
    
    public void cleanRoom(Role role){
        switch (role) {
            case MAID:  
                 dirtiness=Math.max(dirtiness-0.8f, 0f);
                break;
            case GUEST:
                 dirtiness=Math.max(dirtiness-0.2f, 0f);
                break;
            default:
                 dirtiness=Math.max(dirtiness-0.4f, 0f);
                 break;
        }
        
    }

    @Override
    public void enterPerson(Persona p){
        people.add(p);
        dirtiness = Math.min(dirtiness+0.5f,1f);
    }

    public void buildWindow(){
        this.window = new Window();
        this.hasWindow = true;
    }
}