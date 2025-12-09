package interf;
public interface Audible {
    void speak(String text);
    void hear(Audible source, String text);
}