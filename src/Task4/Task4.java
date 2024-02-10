package Task4;


import java.util.ArrayList;
import java.util.List;

/**
 Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 с детализацией, в какой именно ячейке лежат неверные данные.

 2. В методе main() вызвать полученный метод, обработать возможные исключения
 MyArraySizeException и MyArrayDataException и вывести результат расчета
 (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task4 {
    static String[][] arr = new String[][] {
            {"1", "ar", "1.5"},
            {"1", "1.5", "a"},
            {"1", ".", "1"}
    };

    public static void main(String[] args) {
        System.out.println(sum2dV2(arr));
    }

    public static double sum2d(String[][] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != arr[i].length) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                if (!isNum(arr[i][j])) throw new MyArrayDataException(i, j);
                sum += Double.parseDouble(arr[i][j]);
            }
        }
        return sum;
    }

    private static boolean isNum(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

//        return str.matches("[//d]");
    }

    public static double sum2dV2(String[][] arr) {
        double sum = 0;
        List<Point2d> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr.length != arr[i].length) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                if (!isNum(arr[i][j])) list.add(new Point2d(i, j));
                else sum += Double.parseDouble(arr[i][j]);
            }
        }
        if (!list.isEmpty()) throw new MyArrayDataException(list);
        return sum;
    }
}