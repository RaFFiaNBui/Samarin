package PhoneBook;
import java.util.HashMap;

public class PhoneBook {

    //создаем переменную телефонной книги
    private HashMap<String, Contact> phoneBook;

    //конструктор
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    //метод добавления контакта в телефонную книгу
    public void add (String name, Integer number){
        Contact contact;
        if(phoneBook.containsKey(name)){
            contact = phoneBook.get(name);
            contact.addNumber(number);
            System.out.println("Контакт " + name + " уже есть, телефон добавлен");
        } else {
            contact = new Contact(name);
            contact.addNumber(number);
            phoneBook.put(name,contact);
            System.out.println("Контакт " + name + " добавлен");
        }
    }

    //метод поиска контакта по фамилии
    public void get (String name){
        if(phoneBook.containsKey(name)){
            Contact contact = phoneBook.get(name);
            contact.info(name);
        } else {
            System.out.println("Абонента '" + name + "' нет в списке");
        }
    }
}
