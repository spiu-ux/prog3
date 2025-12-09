
import java.util.ArrayList;

class Room extends Location{
    Window window;
    private float dirtiness;
    boolean hasWindow = false;

    class Window{
        public boolean isFrozen = Location.season == Season.WINTER;
        public Bullfinch bullfinch;
    }

    Room(String name){
        super(name);
    }
    float getDirtiness() {
        return this.dirtiness;
    }
    int countPeople(){
        return people.size();
    }
    
    void cleanRoom(Role role){
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
    void enterPerson(Persona p){
        people.add(p);
        dirtiness = Math.min(dirtiness+0.5f,1f);
    }

    void buildWindow(){
        this.window = new Window();
        this.hasWindow = true;
    }
}