package birds;
import items.*;

public class Chicken extends Bird{
    public Chicken(){
        super(Size.BIG);
        super.singText = "Bawk-bawk!";
    }
    
    public void layEggs(){
        int eggCount=(int)(Math.random()*4+1);                 
        for (int i = 0; i < eggCount; i++) {
            this.location.items.add(new Egg());
        }
    }
    @Override
    public void eat(){
        super.eat();
        layEggs();
    }


}