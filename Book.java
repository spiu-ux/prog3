class Book extends Item{
    protected boolean isOpen=false;

    Book(String name){
        super("Book: " + name);
        super.cost=80.0F;
    }
    //?
    void open(){
        this.isOpen=true;
    }
    void close(){
        this.isOpen=false;
    }
    void read(Persona person){
        if(this.isOpen){
            person.setMood(Mood.CALM);
        } 
    }

}