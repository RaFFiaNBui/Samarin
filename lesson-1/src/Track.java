public class Track extends Obstacle {

    int distance;

    //конструктор
    public Track(int distance) {
        this.distance = distance;
    }

    // переопределяем метод прохождения дистанции
    @Override
    public void doAction(Participant participant) {
        participant.run(distance);
    }
}
