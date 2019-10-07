public class Wall extends Obstacle {

    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void doAction (Participant participant) {
        participant.jump(height);
        }

}
