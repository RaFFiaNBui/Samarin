import java.sql.SQLOutput;

public class Course {

    public Obstacle[] obstacles;
    private boolean succes; //показатель успешности прохождения испытаний

    //конструктор
    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    // метод прохождения испытания
    public void doAction(Team team) {
        succes = true;
        for (Participant participant: team.getParticipants()){
            for(Obstacle obstacle: obstacles){
                obstacle.doAction(participant);
                if(!participant.isReady()){
                    succes = false;
                    break;
                }
            }
        }
        if (succes){
            System.out.println("Команда прошла испытание");
        } else {
            System.out.println("Команда не прошла испытание");
        }
    }
}
