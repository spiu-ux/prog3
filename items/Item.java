package items;
import pers.*;
import place.*;

public class Item{
    private String name;
    private Location location;
    public boolean isHidden;
    public Persona owner;
    public float cost;

    public Item(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setLocation(Location location){
        if (this.location != null) {
            location.items.remove(this);
        }
        this.location = location;
        location.items.add(this);
    }

    @Override
    public String toString() {
        return "Item: " + name + ", стоимость: " + cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return name.equals(item.name) &&
            cost == item.cost;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Float.floatToIntBits(cost);
    } 
}