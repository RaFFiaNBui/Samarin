public class Human {

    private String name;
    private int maxDistance = 100;
    private double maxHeight = 1.8;

    //создаем конструктор
    public Human(String name, int maxDistance, double maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    //человек умеет бегать и прыгать
    public void isRun () {
        System.out.println(this.name + " бежит");
    }
    public void isJump () {
        System.out.println(this.name + " прыгает");
    }
}
