public class Test {
    public static void main(String[] args) {

        //создаем массив участников

        Human human1 = new Human("Сергей", 100, 1.5);
        Cat cat = new Cat("Васька", 150, 1.7);
        Robot robot = new Robot("Робот001", 80, 0.3);
        Team team = new Team(human1, cat, robot);

        //создаем массив припятствий
        Wall wall = new Wall(0.2);
        Track track = new Track(110);
        Course course = new Course(wall, track);

        course.doAction(team);



    }

}
