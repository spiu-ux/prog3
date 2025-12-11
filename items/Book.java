package items;
import pers.*;

public class Book extends Item{
    protected boolean isOpen=false;

    public Book(String name){
        super("Book: " + name);
        super.cost=80.0F;
    }
    //?
    public void open(){
        this.isOpen=true;
    }
    public void close(){
        this.isOpen=false;
    }
    public void read(Persona person){
        if(this.isOpen){
            person.setMood(Mood.CALM);
        } 
    }

}