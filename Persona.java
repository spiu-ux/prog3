import java.util.ArrayList;
public class Persona {
    private String name;
    private Role role;
    private Location location;
    private Mood mood = Mood.CALM;
    public ArrayList<Item> inventory = new ArrayList<>();
    protected  float money=150;
    private ArrayList<Item> hair;

    public Persona(String name, Role role){
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
    public void sell(Persona buyer, Item... items){
        if(buyer.mood==Mood.ANGRY || !hasItems(items)){return;}

        float total_cost = 0;
        for (Item i: items) {
            total_cost += i.cost;
        }

        if (buyer.money>=total_cost){
                buyer.money-=total_cost;
                this.money+=total_cost; 
                for (Item i: items) {
                    this.inventory.remove(i);
                    buyer.inventory.add(i);
                }
        }

    }

    public void brushHair(){
        for (Item i: hair) {
            this.hair.remove(i); 
            this.inventory.add(i);            
        } 
    }

    public void brushHair(Item... items){ 
        if (!hasItems(items)) {return;}
        for (Item i: items) {
            this.inventory.remove(i);
            this.hair.add(i);            
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
    void getItem(Item item){
        inventory.add(item);        
        item.owner=this;
   }

    void getItem(){
        for (Item i: this.location.items) {
            if (!i.isHidden || i.owner == this) {
                this.inventory.add(i);
                i.isHidden = false;
                this.location.items.remove(i);
            }
        }
    }

   void lookAround() {
    for (Item i: this.location.items) {
        if (!i.isHidden || i.owner == this) {
            System.out.println("- " + i.getName());
        }
    }

        if (location instanceof Room room) {
            if (room.hasWindow) { 
                if (room.window.isFrozen) {return;}
                switch (Location.season) {
                    case WINTER: 
                        setMood(Mood.SAD);
                        break;
                    case SPRING:
                        setMood(Mood.CALM);
                        break;
                    case SUMMER:
                        setMood(Mood.HAPPY);
                        break;
                    case AUTUMN:
                        setMood(Mood.CONFUSED);
                        break;
                }
            }
        }
   }

    void hide(Item item) {
        this.inventory.remove(item);
        item.owner = this;
        this.location.items.add(item);
        item.isHidden = true;
    }

   void cleanUp(){
    if (location instanceof Room room){
        room.cleanRoom(this.role);
    }
   }

   void moveTo(Location location){
        if (this.location != null) {
            this.location.exitPerson(this);
        }
        this.location=location;
        location.enterPerson(this);
   }
   void speak(String text){
        location.transferSound(new Sound(this,text));
   }

   void hear(Sound sound){
    if (this !=sound.source()){
        System.out.println(name + " hear "+sound.text());
    }
   }

}
