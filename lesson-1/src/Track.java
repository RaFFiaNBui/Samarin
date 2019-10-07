public class Track extends Obstacle {

    int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public void doAction(Participant participant) {
        participant.run(distance);
    }
}
