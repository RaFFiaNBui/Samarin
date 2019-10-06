public class Cat {

    private String name;
    private int maxDistance = 400;
    private double maxHeight = 2.7;

    //создаем конструктор
    public Cat (String name, int maxDistance, double maxHeight) {
        this.maxHeight = maxHeight;
        this.name = name;
        this.maxDistance = maxDistance;
    }

    //кот умеет бегать и прыгать
    public void isRun () {System.out.println(this.name + " бежит");}
    public void isJump () {System.out.println(this.name + " прыгает");}
}
