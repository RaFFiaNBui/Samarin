import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Words {
    public static void main(String[] args) {
        //создаем коллекцию
        ArrayList<String> words = new ArrayList<>();
        words.add("Один");
        words.add("Два");
        words.add("Три");
        words.add("Четыре");
        words.add("Два");
        words.add("Один");
        words.add("Один");
        words.add("Четыре");
        words.add("Два");
        words.add("Один");
        words.add("Три");
        words.add("Три");
        words.add("Два");
        words.add("Четыре");
        words.add("Один");
        // запускаем метод поиска ключевых слов и их повторений
        getWords(words);
    }
    //метод поиска ключевых слов и их повторений
    private static void getWords (ArrayList<String> words) {
        // создаем новую коллекцию, куда будем ложить уникальные слова и количество их повторений
        HashMap <String, Integer> repeat = new HashMap<>();
        for(String i : words){
            //инициализируем счетчик повторений
            Integer number = repeat.get(i);
            //записываем уникальные слова в качестве ключей, а повторения в качестве значений
            repeat.put(i, number == null ? 1 : number +1);
        }
        //выводим в консоль ключевые слова
        System.out.println("Список уникальных слов:");
        for (Map.Entry<String, Integer> o : repeat.entrySet()){
            System.out.println(o.getKey());
        }
        //выводим в консоль количество повторений каждого уникального слова
        System.out.println("Количество повторений:");
        for (Map.Entry<String, Integer> o : repeat.entrySet()){
            System.out.println(o.getKey() + " - " + o.getValue());
        }
    }
}
