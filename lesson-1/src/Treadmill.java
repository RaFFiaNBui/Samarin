public class Treadmill {

    String name;
    int distance;

    public Treadmill(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void run (String name, int maxDistance) {
        if (maxDistance > this.distance) {
            System.out.println(name + " пробежал");
        } else {
            System.out.println(name + " не смог прбежать");
        }
    }
}
