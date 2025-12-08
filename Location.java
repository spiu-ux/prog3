
import java.util.ArrayList;

class Location{
    private String name;
    public ArrayList<Bird> birds;
    static Season season=Season.WINTER;
    private boolean bell=false;
    protected  ArrayList<Persona> people;
    public ArrayList<Item> items;

    Location(String name){
        this.name=name;
        this.people = new ArrayList<>();
        this.birds=new ArrayList<>();
    }
    void enterPerson(Persona p){
        people.add(p);
        if (this.bell) {
            this.transferSound(new Sound(this, "bell ringing in " + this.name));
        }
    }

    void exitPerson(Persona p){
        people.remove(p);
    }

    void transferSound(Sound sound){
        for (Persona p: people){
            p.hear(sound);
        }
    }

    String getName(){
        return name;
    }

    void addBell(){
        this.bell=true;
    }
}