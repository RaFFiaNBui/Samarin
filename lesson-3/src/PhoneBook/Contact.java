package PhoneBook;
import java.util.ArrayList;

class Contact {

    //создаем переменную имени контакта
    private String name;
    //создаем переменную коллекции номеров контакта
    private ArrayList<Integer> phones;

    //конструктор
    Contact(String name) {
        this.name = name;
        this.phones = new ArrayList<>();
    }

    //метод добавления номера телефона к контакту
    void addNumber (Integer number) {
        this.phones.add(number);
    }

    //метод вывода информации о контакте
    void info (){
        System.out.println(this.name + " - " + this.phones);
    }
}
