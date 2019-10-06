public class Wall {

    String name;
    private double height;

    public Wall(String name, double height) {
        this.name = name;
        this.height = height;
    }

    //создаем метод преодоления припятсвия
    public void jump (String name, double maxHeight) {
        if (maxHeight > this.height) {
            System.out.println(name + " перепрыгнул");
        } else {
            System.out.println(name + " не смог перепрыгнуть");
        }
    }
}
