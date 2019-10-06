public class Robot {

    private String name;
    private int maxDistance = 50;
    private double maxHeight = 0.5;

    //создаем конструктор
    public Robot(String name, int maxDistance, double maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    //робот умеет прыгать и бегать
    public void isRun () {
        System.out.println(this.name + " бежит");
    }
    public void isJump () {
        System.out.println(this.name + " прыгает");
    }
}
