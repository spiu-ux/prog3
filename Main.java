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
    Persona invalid = null;
    try {
        // n
        invalid = new Persona("", Role.GUEST);
    }   
    catch (IllegalArgumentException e) {
    System.out.println("Неверное имя: " + e.getMessage());
    invalid = new Persona("Неизвестный", Role.GUEST);
    System.out.println("Создана персона: " + invalid.getName());
    }

    Location barn=new Location("Barn");
    //n
    Room bedroom1 = new Room("Bedroom Elize", RoomType.BEDROOM);
    bedroom1.buildWindow();
    bedroom1.enterPerson(eliz);


    Room bedroom2=new Room("Bedroom Georgeanna",RoomType.CHILDREN_ROOM);
    bedroom2.buildWindow();
    bedroom2.enterPerson(georgeanna);

    Room bedroom3 = new Room("Bedroom Jane", RoomType.BEDROOM);
    bedroom3.buildWindow();
    bedroom3.enterPerson(jane);

    
    //diff
    Room kitchen=new Room("Kitchen",RoomType.KITCHEN);
    kitchen.buildWindow();
    kitchen.enterPerson(invalid);

    
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
    Item sampleEgg = new Egg();
    if (eliz.inventory.contains(sampleEgg)){
    try {
        eliz.sell(economk, sampleEgg);
            System.out.println("Продали одно яйцо");
        } catch (InsufficientFundsException e) {
            System.out.println("Экономка не может купить яйцо: " + e.getMessage());
        }
        } else {
            System.out.println("У Элизы нет яиц");
        }
    eliz.setMood(Mood.HAPPY);

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
    System.out.println("Деньги Элизы после того как спрятала: " + eliz.getMoney());
    //System.out.println("Что видит Дейн "+ jane.inventory);
    
    georgeanna.getItem(flower);
    georgeanna.brushHair(flower);
    georgeanna.getItem(feather);
    georgeanna.brushHair(feather);
    georgeanna.setMood(Mood.HAPPY);
    System.out.println("Предметов в волосах у Джорджианны: " + georgeanna.hair.size());
    System.out.println("Настроение Джоржианны: " + georgeanna.getMood());


    bessy.setMood(Mood.ANGRY);
    bessy.moveTo(bedroom3); 
    //System.out.println("Настроение Джейн до крика Бесси: " + jane.getMood());
    bessy.speak("Джейн убери комнату Джорджианны!");
    //System.out.println("Настроение Джейн после крика Бесси: " + jane.getMood());
    jane.moveTo(bedroom2);
    int peopleCount = bedroom2.countPeople();
    System.out.println("В детской: " + peopleCount + " человека");
    float dirtBefore = bedroom2.getDirtiness();
    System.out.println("Грязь до уборки: " + String.format("%.2f", dirtBefore));
    jane.cleanUp();
    float dirtAfter = bedroom2.getDirtiness();
    System.out.println("Грязь после уборки: " + String.format("%.2f", dirtAfter));
    jane.getItem(book);
    book.open(jane);
    System.out.println("Настроение Джейн до прочтения книги: "+jane.getMood());
    book.read(jane);
    jane.breath();
    jane.lookAround();
    book.close(jane);
    System.out.println("Настроение Джейн: "+jane.getMood());
    jane.getItem(bread);
    jane.feedBirds(bread);
    dron.eat();
    dron.fly();
    }
}