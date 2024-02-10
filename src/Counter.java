import java.io.IOException;

/**
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */
public class Counter implements AutoCloseable {
    int num = 0;
    boolean closed = false;

    public void add() throws IOException {
        if (closed) {
            throw new IOException("Ресурс закрыт");
        }
        num++;
    }

    @Override
    public void close() throws Exception {
        closed = !closed;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();

//        System.out.println(counter.num);
//        counter.add();
//        System.out.println(counter.num);
//        counter.close();
//        counter.add();
        try (counter) {
            System.out.println(counter.num);
            counter.add();
            System.out.println(counter.num);
        }
        counter.add();
    }
}
