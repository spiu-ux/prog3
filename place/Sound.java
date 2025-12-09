package place;
public record Sound(
    Object source,
    String text
){
    public Object source(){
        return source;
    }
    public String text(){
        return text;
    }
}