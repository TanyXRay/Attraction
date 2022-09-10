import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Решение задачи №1 по теме: "Коллекции Queue".
 * Реализация симулятора аттракциона.
 */
public class Main {

    public static void main(String[] args) {
        Queue<Person> personQueue = new ArrayDeque<>(generateClients());

        printQueue(personQueue);
    }

    /**
     * Метод по созданию списка.
     *
     * @return List - список из людей.
     */
    public static List<Person> generateClients() {
        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person("Julia", "Holland", 6));
        listOfPerson.add(new Person("Sarah", "Jacks", 3));
        listOfPerson.add(new Person("Alex", "Attwood", 5));
        listOfPerson.add(new Person("John", "Cantwell", 10));
        listOfPerson.add(new Person("Bruce", "Farrel", 8));
        return listOfPerson;
    }

    /**
     * Метод выводит на экран по очереди людей, у которых есть билеты на аттракцион.
     *
     * @param personQueue очередь из людей.
     */
    public static void printQueue(Queue<Person> personQueue) {
        int countOfTickets;
        while (!personQueue.isEmpty()) {
            Person p = personQueue.poll();
            countOfTickets = p.getNumberOfTickets() - 1;
            if (countOfTickets != 0) {
                System.out.println(p + " прокатил(ась)ся на аттракционе!");
                personQueue.offer(p);
                p.setNumberOfTickets(countOfTickets);
            } else {
                System.out.println("У " + p.getName() + " " + p.getSurname() + " закончились билеты!(выбывает из очереди)");
                personQueue.remove(p);
            }
        }
    }
}


