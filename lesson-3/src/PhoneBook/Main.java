package PhoneBook;

public class Main {
    public static void main(String[] args) {

        //создаем телефонный справочник
        PhoneBook phoneBook = new PhoneBook();

        //добавляем контакты
        System.out.println("Добавление контактов:");
        phoneBook.add("Иванов", 111);
        phoneBook.add("Петров", 222);
        phoneBook.add("Сидоров", 333);
        phoneBook.add("Иванов", 444);

        //ищем контакты по фамилии
        System.out.println("Поиск котактов по фамилии:");
        phoneBook.get("Иванов");
        phoneBook.get("Сидоров");
        phoneBook.get("Петров");
        phoneBook.get("Смирнов");
    }
}
