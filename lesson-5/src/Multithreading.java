import java.lang.reflect.Array;

public class Multithreading implements Runnable{

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        inCourse();
        twoThreads();
    }

    //переопределяем метод run() интерфейса Runnable
    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    //общий метод наполнения массива еденицами
    private static void arrayTo1() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    //метод расчета одним потоком
    private static void inCourse () {
        arrayTo1();
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы метода inCourse - " + (System.currentTimeMillis() - a));
    }

    //метод расчета в 2 потока
    private static void twoThreads () {
        arrayTo1();
        long a = System.currentTimeMillis();
        //Деление масиива на 2 части
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        //обход массивов 2 потоками
        new Thread(new Multithreading()).start();
        new Thread(new Multithreading()).start();

        //обратная склейка массива
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Время работы метода twoThreads - " + (System.currentTimeMillis() - a));
    }
}
