package pers;
import birds.*;
import exceptions.*;
import interf.*;
import items.*;
import java.util.ArrayList;
import java.util.List;
import place.*;

public class Persona implements Audible,Watcher{
    private String name;
    private Role role;
    public Location location;
    private Mood mood = Mood.CALM;
    public final List<Item> inventory = new ArrayList<>();
    protected float money=250f;
    public final ArrayList<Item> hair = new ArrayList<>();
    private boolean moneyHidden = false;
    private boolean isReading = false;

    public Persona(String name, Role role){
        if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Имя пустое");
    }
        this.name=name;
        this.role=role;
    }
    private boolean hasItems(Item... items) {
        for (Item i: items) {
            if (!this.inventory.contains(i)) { 
                return false;
            }
        }
        return true;
    }
    public void feedBirds(BirdFood food){
        if (!hasItems((Item) food)) {return;}
        for (Bird p: location.birds) {
            p.eat(food.getNutrition());
        }
        inventory.remove(food);
    }

    public void sell(Persona buyer, Item... items) throws InsufficientFundsException {
        if(buyer.mood==Mood.ANGRY || !hasItems(items)){
            return;
        }
        float totalCost = 0;
            for (Item i : items) totalCost += i.cost;
                if (buyer.money < totalCost) {
                    throw new InsufficientFundsException(totalCost, buyer.money);
                }
                buyer.money-=totalCost;
                this.money+=totalCost; 
                for (Item i: items) {
                    this.inventory.remove(i);
                    buyer.inventory.add(i);
                }

    }
    public void brushHair(){
        List<Item> hairCopy = new ArrayList<>(this.hair);
        for (Item item : hairCopy) {
            this.hair.remove(item);
            this.inventory.add(item);//copy
        }
    }
    public void brushHair(Item... items){ 
        if (!hasItems(items)) return;
        for (Item item: items) {
            this.inventory.remove(item);
            this.hair.add(item);            
        }
    }
    public void breath(){
        if (location instanceof Room room) {
            if (room.hasWindow) { 
                room.window.isFrozen=false;
            }
        }    
    }
    public String getName(){
        return name;
    }
    public Mood getMood(){
        return mood;
    }
    public void setMood(Mood mood){
        this.mood=mood;
    }
    public void getItem(Item item){
        inventory.add(item);        
        item.owner=this;
    }
    public void getItem() {
    ArrayList<Item> itemsCopy = new ArrayList<>(this.location.items);
    for (Item i : itemsCopy) {
        if (!i.isHidden || i.owner == this) {
            this.inventory.add(i);
            i.isHidden = false;
            this.location.items.remove(i); //copy
        }
    }
}
    @Override
    public void lookAround() {
        for (Item i: this.location.items) {
            if (!i.isHidden || i.owner == this) {
                System.out.println("- " + i.getName());
        }
    }
            if (location instanceof Room room) {
                if (room.hasWindow) { 
                    if (room.window.isFrozen) {return;}
                    switch (Location.season) {
                        case WINTER -> setMood(Mood.SAD);
                        case SPRING -> setMood(Mood.CALM);
                        case SUMMER ->setMood(Mood.HAPPY);
                        case AUTUMN -> setMood(Mood.CONFUSED);
                }
            }
        }
   }
    public void hide(Item item) {
        this.inventory.remove(item);
        item.owner = this;
        this.location.items.add(item);
        item.isHidden = true;
    }
   public void cleanUp(){
    if (location instanceof Room room){
        room.cleanRoom(this.role);
        }
   }
   public void moveTo(Location location){
        if (this.isReading){
            return;
        }
        if (this.location != null) {
            this.location.exitPerson(this);
        }
        this.location=location;
        location.enterPerson(this);
   }
   @Override
    public void speak(String text) {
        if (location != null) {
            location.transferSound(new Sound(this, text));
        }
    }
   @Override
    public void hear(Audible source, String text) {
        if (this != source) {
            this.setMood(Mood.CONFUSED);
        }
    }
    public void hideMoney() {
        this.moneyHidden = true;
    }
    public void showMoney() {
        this.moneyHidden = false;
    }

    public float getMoney() {
        if (this.moneyHidden) {
            return 0.0f;
        }
        return this.money;
    }
    public void startReading(){
        this.isReading=true;
    }
    public void stopReading(){
        this.isReading=false;
    }

    @Override
    public String toString() {
        return "Persona: " + name + ", " + role + ", " + mood + ", деньги: " + money;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;          
        if (obj == null) return false;         
        if (getClass() != obj.getClass())      
            return false;
        Persona p = (Persona) obj;             
        return name.equals(p.name) &&         
           role == p.role &&
           mood == p.mood &&
           money == p.money;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + role.hashCode() + mood.hashCode() + Float.floatToIntBits(money);
    }

}
