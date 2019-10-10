public class Main {

    public static void main(String[] args) {

        String [][] arr1 = new String[4][4];
        String [][] arr2 = {{"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}};

        summ(arr2);
    }

    private static void summ (String [][] arr) {
       try {
            summArr(arr);
        } catch (MyArraySizeException size) {
            System.out.println(size.getMessage());
            size.printStackTrace();
        } /*catch (MyArrayDataException data) {
            System.out.println("Ошибка " + data);
        }*/
    }

    private static void summArr (String [][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int k = 0; k < arr.length; k++) {
            if (arr[k].length !=4) {
                throw new MyArraySizeException();
            }
        }
        int summ = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                summ += Integer.parseInt(arr[i][j]);
            }
        }
            System.out.println("Сумма мэлементов массива = " +summ);

    }
/*
    private static String [][] arrToStr (int x, int y ) {
        String [][] arr = new String[x][y];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.toString();
            }
        }
    }*/
}
