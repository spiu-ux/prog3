class Chicken extends Bird{
    Chicken(){
        super(Size.BIG);
        super.singText = "Bawk-bawk!";
    }
    
    void layEggs(){
        int eggCount=(int)(Math.random()*4+1);                 
        for (int i = 0; i < eggCount; i++) {
            this.location.items.add(new Egg());
        }
    }
    @Override
    void eat(){
        super.eat();
        layEggs();
    }


}