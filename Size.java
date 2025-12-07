public enum Size{
    TINY(120),
    SMALL(90),
    NORMAL(60),
    BIG(10),
    HUGE(0);
    private final int flyTime;
    Size(int flyTime){
        this.flyTime=flyTime;
    }
    public int getFlyTime(){
        return flyTime;
    }
}