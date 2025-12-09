package birds;
import place.*;

public abstract class Bird{
    private Size size;
    protected Location location;
    private int flyTime;
    protected  String singText;

    public Bird(Size size){
        this.size=size;
        this.flyTime=size.getFlyTime();
    }
    public void fly(){
        if (flyTime==0){
            System.out.println("Bird can't fly");
            return;
        }
        flyTime-=10;
        int food=(int)(Math.random()*3);
        switch (food) {
            case 0 : 
                System.out.println("Bird couldn't find any food"); 
                break;
            case 1 : 
                eat();
                System.out.println("Bird found some food"); 
                break;
            case 2 : 
                eat();
                System.out.println("Bird found a lot of food");
                break;
        }
    }

    public void fly(Location location){
        if (flyTime==0){
            System.out.println("Bird can't fly");
            return;
        }
        flyTime-=10;
        sing();
    } 

    public void sing() {
        location.transferSound(new Sound(this,singText));
    }
    public void eat(){
        flyTime=size.getFlyTime();
    }

    public void eat(int nutrition) {
        flyTime = Math.min(flyTime+nutrition, size.getFlyTime());
    }

    public void setLocation(Location location) {
    this.location = location;
}
}