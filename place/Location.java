package place;

import birds.*;
import interf.*;
import items.*;
import java.util.ArrayList;
import pers.*;

public class Location implements Audible{
    private String name;
    public ArrayList<Bird> birds = new ArrayList<>();
    public static Season season=Season.WINTER;
    private boolean bell=false;
    protected  ArrayList<Persona> people = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();

    public Location(String name){
        this.name=name;
    }

    public void enterPerson(Persona p){
        people.add(p);
        if (this.bell) {
            this.transferSound(new Sound(this, "bell ringing in " + this.name));
        }
    }

    public void exitPerson(Persona p){
        people.remove(p);
    }

    public void transferSound(Sound sound){
        for (Persona p: people){
            p.hear(sound.source(), sound.text());
        }
    }

    public String getName(){
        return name;
    }

    public void addBell(){
        this.bell=true;
    }

    @Override
    public String toString() {
        return "Location: " + name;
    }
    @Override
    public void speak(String text){

    }
    @Override
    public void hear(Audible source, String text){
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location loc = (Location) obj;
        return name.equals(loc.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}