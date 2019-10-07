public class Team {

    public Participant[] participants;

    public Team(Participant... participants) {
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }
}
