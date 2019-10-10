public class Wall extends Obstacle {

    private double height;

    //конструктор
    public Wall(double height) {
        this.height = height;
    }

    //переопределяем метод прохождения припятствия
    @Override
    public void doAction (Participant participant) {
        participant.jump(height);
        }

}
