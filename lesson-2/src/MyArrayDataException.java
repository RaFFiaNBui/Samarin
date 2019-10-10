public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j) {
        super("MyArrayDataException: Некорректный ввод числа в ячейке " + "[" + i + "]" + "[" + j + "]");
    }
}
