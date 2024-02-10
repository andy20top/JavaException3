package Task4;

public class MyArraySizeException extends IllegalArgumentException {
    public MyArraySizeException() {
        super("Массив должен быть 3х3");
    }
}
