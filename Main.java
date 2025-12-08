import java.util.ArrayList;
class Main{
    public static void main(String[] args){
    Persona jane=new Persona("Jane",Role.MAID);
    Persona eliz =new Persona("Eliz",Role.COMMERSANT);
    Persona georgeanna =new Persona("Georgeanna",Role.TENANT);
    Persona economk=new Persona("Economy", Role.ECONOMY);
    Location barn=new Location("Barn");
    
    Location house = new Location("Gatshed");
    Room bedroom1=new Room("Bedroom Jane");
    bedroom1.buildWindow();
    bedroom1.enterPerson(eliz);


    Room bedroom2=new Room("Bedroom Georgeanna");
    bedroom2.buildWindow();
    bedroom2.enterPerson(georgeanna);

    Room bedroom3=new Room("Bedroom Jane");
    bedroom3.buildWindow();
    bedroom3.enterPerson(jane);;

    
    Chicken tyi=new Chicken();
    Chicken jir=new Chicken();
    Bullfinch dron=new Bullfinch();
    tyi.getLocation();
    jir.getLocation();
    barn.birds.add(jir);
    barn.birds.add(tyi);
    dron.sitOnWindow(bedroom3.window);

    Jewerly feather=new Jewerly("feather");
    Jewerly flower=new Jewerly("flower");
    Book book=new Book("Jane Heir");
    Bread bread=new Bread();
    Seeds seeds=new Seeds();

    eliz.moveTo(barn);
    eliz.feedBirds(seeds);
    tyi.eat();
    jir.eat();
    tyi.layEggs();
    jir.layEggs();
    eliz.lookAround();
    eliz.getItem();
    eliz.sell(economk,eliz.inventory.toArray(new Item[0]));
    System.out.println("После продажи:");
    System.out.println("Деньги Элизы: " + eliz.money);
    System.out.println("Яиц у Элизы: " + eliz.inventory.size());
    System.out.println("Предметов у экономки: " + economk.inventory.size());

    
    }
}