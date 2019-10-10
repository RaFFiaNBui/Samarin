public class Main {

    public static void main(String[] args) {

        String [][] arr1 = new String[1][4]; //ловим ошибку размера массива
        String [][] arr2 = new String[4][3];//ловим ошибку размера массива
        String [][] arr3 = {{"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}}; //правильный массив
        String [][] arr4 = {{"1","1","1","t"}, {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}}; //ловим ошибку заполнения

        //находим суммы каждого массива
        summ(arr1);
        summ(arr2);
        summ(arr3);
        summ(arr4);
    }

    //метод обработки возможных исключений MySizeArrayException и MyArrayDataException
    private static void summ (String [][] arr) {
       try {
            summArr(arr);
        } catch (MyArraySizeException size) {
            System.out.println(size.getMessage());
        } catch (MyArrayDataException data) {
            System.out.println(data.getMessage());
        }
    }

    //метод суммирования элементов массива
    private static void summArr (String [][] arr) throws MyArrayDataException, MyArraySizeException {
        //ставим исключения на размер первого поля массива
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        //ставим исключение на второе поле массива
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }
        //суммируем элементы во временную переменную summ
        int summ = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                // ставим исключение на невозможность перевода элемента в тип integer
                try {
                    summ += Integer.parseInt(arr[i][j]); // перевод элемента в  integer
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        System.out.println("Сумма мэлементов массива = " +summ); // выводим результат суммы
    }
}
