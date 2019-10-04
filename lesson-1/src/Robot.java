public class Robot  implements Wall, Treadmill{

    private String name;
    private int maxDistanceRobot = 50;
    private double maxHeightRobot = 0.5;

    //создаем конструктор
    public Robot(String name, int maxDistanceRobot, double maxHeightRobot) {
        this.name = name;
        this.maxDistanceRobot = maxDistanceRobot;
        this.maxHeightRobot = maxHeightRobot;
    }

    //робот умеет прыгать и бегать
    public void isRun () {
        System.out.println(this.name + " бежит");
    }
    public void isJump () {
        System.out.println(this.name + " прыгает");
    }

    //перегружаем методы преодоления припятсвий
    @Override
    public void run (int distance) {
        if (maxDistanceRobot > distance) {
            System.out.println(this.name + " пробежал");
        } else {
            System.out.println(this.name + " не пробежал");
        }
    }
    @Override
    public void jump (double height) {
        if (maxHeightRobot > height) {
            System.out.println(this.name + " перепрыгнул");
        } else {
            System.out.println(this.name + " не перепрыгнул");
        }
    }
}
