package list.linkedlist.implementation;

public class Main {
    public static void main(String args[]){
        LinkedList numbers = new LinkedList();
        numbers.addFirst(30);
        numbers.addFirst(20);
        numbers.addFirst(10);
        numbers.addLast(40);
        numbers.addLast(50);
        numbers.addLast(60);
        numbers.add(1, 15);
        System.out.println(numbers.removeFirst());
        System.out.println(numbers.remove(0));
        System.out.println(numbers.removeLast());
        System.out.println(numbers.size());
        System.out.println(numbers.get(2));
        System.out.println(numbers.indexOf(30));
//        System.out.print(numbers.node(3));
        System.out.println(numbers);
    }
}
