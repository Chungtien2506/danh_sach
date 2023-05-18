package linkedlist;

public class Main {
    public static void main(String[] args) {


    MyLinkedList<Integer> list = new MyLinkedList<>();

    // test add methods
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        System.out.println(list); // [1, 2, 3]
        list.addFirst(0);
        list.addLast(4);
        System.out.println(list); // [0, 1, 2, 3, 4]

    // test remove methods
        list.remove(0);
        list.remove(3);
        System.out.println(list); // [1, 2, 3]
        list.remove((Integer) 2);
        System.out.println(list); // [1, 3]

    // test other methods
        System.out.println(list.size()); // 2
    MyLinkedList<Integer> clone = list.clone();
        System.out.println(clone); // [1, 3]
        System.out.println(list.contains(3)); // true
        System.out.println(list.indexOf(3)); // 1
        list.add(2);
        System.out.println(list); // [1, 3, 2]
        System.out.println(list.getFirst()); // 1
        System.out.println(list.getLast()); // 2
        list.clear();
        System.out.println(list); // []
}}

