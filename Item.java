class Item{
    private String name;
    private Location location;
    public boolean isHidden;
    public Persona owner;
    private float cost;

    Item(String name){
        this.name=name;
    }

    String getName(){
        return name;
    }
    void setLocation(Location location){

    }
    
}