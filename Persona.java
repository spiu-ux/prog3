import java.util.ArrayList;
public class Persona {
    private String name;
    private Role role;
    public Location location;
    private Mood mood = Mood.CALM;
    public ArrayList<Item> inventory = new ArrayList<>();
    protected float money=250;
    protected  ArrayList<Item> hair;
    private boolean moneyHidden = false;

    public Persona(String name, Role role){
        if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Имя пустое");
    }
        this.name=name;
        this.role=role;
        this.hair = new ArrayList<>();
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

    void getItem() {
    ArrayList<Item> itemsCopy = new ArrayList<>(this.location.items);
    for (Item i : itemsCopy) {
        if (!i.isHidden || i.owner == this) {
            this.inventory.add(i);
            i.isHidden = false;
            this.location.items.remove(i); //copy
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

    void hideMoney() {
        this.moneyHidden = true;
    }
    void showMoney() {
        this.moneyHidden = false;
    }

    public float getMoney() {
        if (this.moneyHidden) {
            return 0.0f;
        }
        return this.money;
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
