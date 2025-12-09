package place;

import birds.*;
import items.*;
import java.util.ArrayList;
import pers.*;

public class Location{
    private String name;
    public ArrayList<Bird> birds;
    public static Season season=Season.WINTER;
    private boolean bell=false;
    protected  ArrayList<Persona> people;
    public ArrayList<Item> items;

    public Location(String name){
        this.name=name;
        this.people = new ArrayList<>();
        this.birds=new ArrayList<>();
        this.items = new ArrayList<>();
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
            p.hear(sound);
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