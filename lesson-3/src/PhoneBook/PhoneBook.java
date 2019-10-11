package PhoneBook;
import java.util.HashMap;

class PhoneBook {

    //создаем переменную телефонной книги
    private HashMap<String, Contact> phoneBook;

    //конструктор
    PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    //метод добавления контакта в телефонную книгу
    void add (String name, Integer number){
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
    void get (String name){
        if(phoneBook.containsKey(name)){
            Contact contact = phoneBook.get(name);
            contact.info();
        } else {
            System.out.println("Абонента '" + name + "' нет в списке");
        }
    }
}
