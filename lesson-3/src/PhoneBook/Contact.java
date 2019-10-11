package PhoneBook;
import java.util.ArrayList;

public class Contact {

    //создаем переменную имени контакта
    private String name;
    //создаем переменную коллекции номеров контакта
    ArrayList<Integer> phones;

    //конструктор
    public Contact(String name) {
        this.name = name;
        this.phones = new ArrayList<>();
    }

    //метод добавления номера телефона к контакту
    public void addNumber (Integer number) {
        this.phones.add(number);
    }

    //метод вывода информации о контакте
    public void info (String name){
        System.out.println(this.name + " - " + this.phones);
    }
}
