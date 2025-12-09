import birds.*;
import exceptions.*;
import items.*;
import pers.*;
import place.*;

public class Main{
    public static void main(String[] args){
    Persona jane=new Persona("Jane",Role.MAID);
    Persona eliz =new Persona("Eliz",Role.COMMERSANT);
    Persona georgeanna =new Persona("Georgeanna",Role.TENANT);
    Persona economk=new Persona("Economy", Role.ECONOMY);
    Persona bessy=new Persona("Bessy",Role.TENANT);
    try {
        // n
        Persona invalid = new Persona("", Role.MAID);
    }   
    catch (IllegalArgumentException e) {
    System.out.println("Неверное имя: " + e.getMessage());
    }
    Location barn=new Location("Barn");

    Item egg1 = new Egg();
    Item egg2 = new Egg();
    //n
    System.out.println(egg1.equals(egg2)); 

    Location barn1 = new Location("Barn");
    Location barn2 = new Location("Barn");
    System.out.println(barn1.equals(barn2));
    
    Room bedroom1=new Room("Bedroom Elize");
    bedroom1.buildWindow();
    bedroom1.enterPerson(eliz);


    Room bedroom2=new Room("Bedjkhgjgfroom Georgeanna");
    bedroom2.buildWindow();
    bedroom2.enterPerson(georgeanna);

    Room bedroom3=new Room("Bedroom Jane");
    bedroom3.buildWindow();
    bedroom3.enterPerson(jane);

    
    //diff
    Room kitchen=new Room("Kitchen");
    kitchen.buildWindow();

    
    Chicken tyi=new Chicken();
    Chicken jir=new Chicken();
    Bullfinch dron=new Bullfinch();
    tyi.setLocation(barn);
    jir.setLocation(barn);
    barn.birds.add(jir);
    barn.birds.add(tyi);
    dron.sitOnWindow(bedroom2.window);

    Jewerly feather=new Jewerly("feather");
    Jewerly flower=new Jewerly("flower");
    Book book=new Book("Jane Heir");
    Bread bread=new Bread();
    Seeds seeds=new Seeds();


    eliz.getItem(seeds);
    eliz.moveTo(barn);
    eliz.feedBirds(seeds);
    tyi.eat();
    tyi.fly(barn);
    jir.eat();
    tyi.layEggs();
    jir.layEggs();
    eliz.lookAround();
    eliz.getItem();
    try {
        eliz.sell(economk, (Item[]) eliz.inventory.toArray());
    }   
    // ?
    catch (InsufficientFundsException e) {
    System.out.println("Ошибка: " + e.getMessage());
    }
    eliz.setMood(Mood.HAPPY);

    System.out.println("Комната: " + bedroom3.getName());
    System.out.println("После продажи:");
    System.out.println("Деньги Элизы: " + eliz.getMoney());
    System.out.println("Яиц у Элизы: " + eliz.inventory.size());
    System.out.println("Предметов у экономки: " + economk.inventory.size());
    System.out.println("Настроение Элизы: " + eliz.getMood());

    eliz.moveTo(bedroom1);
    eliz.hideMoney();
    //jane.moveTo(bedroom1);
    //jane.lookAround();
    //jane.getItem();
    System.out.println("Деньги Элизы: " + eliz.getMoney());
    //System.out.println("Что видит Дейн "+ jane.inventory);
    
    georgeanna.getItem(flower);
    georgeanna.brushHair(flower);
    georgeanna.getItem(feather);
    georgeanna.brushHair(feather);
    georgeanna.setMood(Mood.HAPPY);
    System.out.println("Предметов в волосах: " + georgeanna.hair.size());
    System.out.println("Настроение Элизы: " + georgeanna.getMood());


    bessy.setMood(Mood.ANGRY);
    bessy.moveTo(kitchen); 
    bessy.speak("Джейн убери комнату!");
    jane.cleanUp();
    jane.moveTo(bedroom2);
    jane.getItem(book);
    book.open();
    book.read(jane);
    System.out.println("Настроение Джейн: "+jane.getMood());
    jane.breath();
    jane.lookAround();
    book.close();
    System.out.println("Настроение Джейн: "+jane.getMood());
    jane.getItem(bread);
    jane.feedBirds(bread);
    dron.eat();
    dron.fly();
    }
}