public class Cat implements Wall, Treadmill {

    private String name;
    private int maxDistanceCat = 400;
    private double maxHeightCat = 2.7;

    //создаем конструктор
    public Cat (String name, int maxDistanceCat, double maxHeightCat) {
        this.maxHeightCat = maxHeightCat;
        this.name = name;
        this.maxDistanceCat = maxDistanceCat;
    }

    //кот умеет бегать и прыгать
    public void isRun () {
        System.out.println(this.name + " бежит");
    }
    public void isJump () {
        System.out.println(this.name + " прыгает");
    }

    //перегружаем методы преодоления припятсвий
    @Override
    public void run (int distance) {
        if (maxDistanceCat > distance) {
            System.out.println(this.name + " пробежал");
        } else {
            System.out.println(this.name + " не смог пробежать");
        }
    }
    @Override
    public void jump (double height) {
        if (maxHeightCat > height) {
            System.out.println(this.name + "перепрыгнул ");
        } else {
            System.out.println(this.name + " не смог перепрыгнуть");
        }
    }
}
