public class Human implements Wall, Treadmill {

    private String name;
    private int maxDistanceHuman = 100;
    private double maxHeightHuman = 1.8;

    //создаем конструктор
    public Human (String name, int maxDistanceHuman, double maxHeightHuman) {
        this.name = name;
        this.maxDistanceHuman = maxDistanceHuman;
        this.maxHeightHuman = maxHeightHuman;
    }

    //человек умеет бегать и прыгать
    public void isRun () {
        System.out.println(this.name + " бежит");
    }
    public void isJump () {
        System.out.println(this.name + " прыгает");
    }

    //перегружаем методы преодоления припятсвий
    @Override
    public void jump (double height) {
        if (maxHeightHuman > height) {
            System.out.println(this.name + " перепрыгнул");
        } else {
            System.out.println(this.name + " не смог перепрыгнуть");
        }
    }
    @Override
    public void run (int distance) {
        if (maxDistanceHuman > distance) {
            System.out.println(this.name + " пробежал");
        } else {
            System.out.println(this.name + " не смог прбежать");
        }
    }
}
