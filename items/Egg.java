package items;
public class Egg extends Item{
    public Egg(){
        super("Egg");
        super.cost=15.0F;
    }
    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}