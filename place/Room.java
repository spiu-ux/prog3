package place;
import birds.*;
import items.*;
import java.util.ArrayList;
import pers.*;

public class Room extends Location{
    public Window window;
    private float dirtiness;
    public boolean hasWindow = false;
    private final RoomType type;

    public class Window{
        public boolean isFrozen = Location.season == Season.WINTER;
        public Bullfinch bullfinch;
    }
    public Room(String name, RoomType type){
        super(name);
        this.type=type;
    }
    public float getDirtiness() {
        return this.dirtiness;
    }
    public int countPeople(){
        return people.size();
    }
    public void cleanRoom(Role role){
        float cleanPower =0.4f;
        switch (role) {
            case MAID -> cleanPower=0.8f;
            case TENANT -> cleanPower=0.4f;
            case ECONOMY -> cleanPower=0.1f;
        }
        if (type==RoomType.CHILDREN_ROOM){
            cleanPower *= 0.8f;
        }
        if (type==RoomType.BEDROOM){
            cleanPower += 0.1f;
        }
        dirtiness = Math.max(dirtiness - cleanPower, 0f);
    }

    @Override
    public void enterPerson(Persona p){
        people.add(p);
        dirtiness = Math.min(dirtiness+0.5f,1f);
        switch(type){
            case BEDROOM:
                p.setMood(Mood.CALM);
                break;
            case KITCHEN:
                p.setMood(Mood.HAPPY);
                boolean hasBread = items.contains(new Bread());
                if (!hasBread && Math.random()<0.3){
                    items.add(new Bread());
                }
                break;
            case CHILDREN_ROOM:
                p.setMood(Mood.CONFUSED);
                for (Bird bird : new ArrayList<>(birds)) {
                   bird.fly();
                }
                break;
        }
    }
    public void buildWindow(){
        this.window = new Window();
        this.hasWindow = true;
    }
}