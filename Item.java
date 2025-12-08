class Item{
    protected String name;
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
    
}