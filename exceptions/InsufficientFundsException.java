package exceptions;
public class InsufficientFundsException extends Exception {
    private final float required;
    private final float available;

    public InsufficientFundsException(float required, float available) {
        super("Недостаточно: требуется " + required + " доступно " + available);
        this.required = required;
        this.available = available;
    }

    public float getRequired() { return required; }
    public float getAvailable() { return available; }

    @Override
    public String getMessage() {
        return "Недостаточно: требуется " + required + " доступно " + available;
    }
}