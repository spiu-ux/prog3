package items;
import pers.*;

public class Book extends Item{
    protected boolean isOpen=false;

    public Book(String name){
        super("Book: " + name);
        super.cost=80.0F;
    }
    //?
    public void open(Persona reader){
        this.isOpen=true;
        reader.startReading();
    }
    public void close(Persona reader){
        this.isOpen=false;
        reader.stopReading();
    }
    public void read(Persona reader){
        if(this.isOpen){
            reader.setMood(Mood.CALM);
        } 
    }

}