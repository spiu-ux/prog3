import java.util.ArrayList;
import java.util.Objects;
public class Persona {
    private String name;
    private Role role;
    private Location location;
    private Mood mood = Mood.CALM;
    private ArrayList<Task> tasks;
    private float money=0;

    public Persona(String name, Role role, Location location){
        this.name=name;
        this.role=role;
        this.location=location;
    }
    public void feedBirds(){

    }
    public void sell(){

    }
    public void brushHair(){

    }
    public void breath(){

    }
    public String getName(){
        return name;
    }
    public Mood getMood(){
        return mood;
    }
    public Mood setMood(Mood mood){
        this.mood=mood;
    }
}
