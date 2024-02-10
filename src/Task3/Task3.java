package Task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
//        System.out.println(divide(4, 0));
        try {
            fileNotFound("88882.txt");
        } catch (NonExistedFileException e) {
            throw new RuntimeException(e);
        }
    }

    public static int divide(int num1, int num2) {
        if (num2 == 0) throw new DivideByZeroException();
        return num1 / num2;
    }

    public static void fileNotFound(String path) throws NonExistedFileException{
        try(FileReader fr = new FileReader(path)) {

        } catch (IOException e) {
            throw new NonExistedFileException();
        }
    }
}
