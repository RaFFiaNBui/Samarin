public class Test {
    public static void main(String[] args) {

        //создаем массив участников
        Object [] arr = new Object[3];
        arr[0] = new Human("Сергей", 100, 1.5);
        arr[1] = new Cat("Барсик", 150, 1.7);
        arr[2] = new Robot("Робот1", 50, 0.3);

        //создаем массив припятствий
        Object[] arr2 = new Object[6];
        arr2[0] = new Wall("Стена 1", 0.2);
        arr2[1] = new Treadmill("Дорожка 1", 70);
        arr2[2] = new Wall("Стена 2", 1.6);
        arr2[3] = new Treadmill("Дорожка 2", 120);
        arr2[4] = new Wall("Стена 3", 1.8);
        arr2[5] = new Treadmill("Дорожка 3", 170);
    }
}
