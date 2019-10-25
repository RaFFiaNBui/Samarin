import java.util.Arrays;

public class Multithreading {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arrayInCourse = arrayTo1(SIZE);
        timeWork(new Runnable() {
            @Override
            public void run() {
                inCourse(arrayInCourse, 0);
            }
        }, "inCourse");
        float[] arrayTwoThreads = arrayTo1(SIZE);
        timeWork(() -> twoThreads(arrayTwoThreads), "twoThreads");
        System.out.println("Массивы одинаковые - " + Arrays.equals(arrayInCourse, arrayTwoThreads));
    }

    //общий метод наполнения массива еденицами
    private static float[] arrayTo1(int size) {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        return array;
    }
    //метод расчета одним потоком
    private static void inCourse (float[] arr, int offset){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = formula(i + offset, arr[i]);
        }
    }

    //метод - формула из задания
    private static float formula(int index,float value){
        return (float)(value * Math.sin(0.2f + index / 5.0) * Math.cos(0.2f + index / 5.0) * Math.cos(0.4f + index / 2.0));
    }

    //метод расчета в 2 потока
    private static void twoThreads (float[] array) {
        //разделяем массив на 2 массива
        float[] array1 = new float[HALF];
        float[] array2 = new float[HALF];
        System.arraycopy(array, 0, array1, 0, HALF);
        System.arraycopy(array, HALF, array2, 0, HALF);

        //обходим оба массива разными потоками
        Thread thread1 = new Thread(() -> inCourse(array1,0));
        Thread thread2 = new Thread(() -> inCourse(array2, HALF));

        thread1.start();
        thread2.start();

        //склейваем 2 массива в один
        System.arraycopy(array1, 0, array, 0, HALF);
        System.arraycopy(array2, 0, array, HALF, HALF);
    }

    //метод фиксации времени работы
    private static void timeWork(Runnable action, String methodName) {
        long a = System.currentTimeMillis();
        action.run();
        System.out.println( "Время работы метода " + methodName +" " + (System.currentTimeMillis()-a) + " милисекунд");
    }
}
