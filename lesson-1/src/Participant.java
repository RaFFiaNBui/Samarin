public interface Participant {

    //шаблоны методов пробежки и прыжков
    void run(int distance);
    void jump (double height);
    //возможность участника пройти испытание
    boolean isReady();
}
