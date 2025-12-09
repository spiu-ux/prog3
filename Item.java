class Item{
    private String name;
    private Location location;
    public boolean isHidden;
    public Persona owner;
    protected float cost;

    Item(String name){
        this.name=name;
    }

    String getName(){
        return name;
    }
    void setLocation(Location location){
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