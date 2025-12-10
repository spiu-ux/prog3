package birds;
import place.*;


public class Bullfinch extends Bird{
    private Room.Window window;

    public Bullfinch() {
        super(Size.TINY);
        super.singText = "Chirp-chirp!";
    }
    
    public void sitOnWindow(Room.Window window){
        if (window.bullfinch == null){
            this.window=window;
            window.bullfinch=this;
        }
    }

    @Override
    public void fly(Location location){
        super.fly(location);

        if (this.window != null) {
            ((Room) (this.location)).window.bullfinch = null;
            this.window = null;
        }

        if (location instanceof Room room) {
            if (room.hasWindow) { 
                if (room.window.bullfinch != null) {return;}
                this.window = room.window; 
                room.window.bullfinch = this;
            }
        }

        
    }
}