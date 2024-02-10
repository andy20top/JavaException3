package Task4;

import java.util.List;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super(String.format("В ячейке [%s][%s] не число", i, j));
    }

    public MyArrayDataException(List<Point2d> list) {
        super(String.format("В ячейках %s не число", list));
    }

}
