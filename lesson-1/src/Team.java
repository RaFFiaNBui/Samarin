public class Team {

    public Participant[] participants;

    //конструктор
    public Team(Participant... participants) {
        this.participants = participants;
    }

    //геттер участников
    public Participant[] getParticipants() {
        return participants;
    }
}
