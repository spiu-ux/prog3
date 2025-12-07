
import java.util.ArrayList;

abstract class Location{
    private String name;
    public ArrayList<Bird> birds;
    static Season season=Season.WINTER;
    private boolean bell=false;
    private ArrayList<Persona> people;
    public ArrayList<Item> items;

    Location(String name){
        this.name=name;
    }
    void transferSounds(){

    }
    String getName(){
        return name;
    }
    void addBell(){
        this.bell=true;
    }
}