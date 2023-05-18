package linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node<E> head;
    private int numNodes;

    // constructors
    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    // add methods
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        numNodes++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(numNodes, e);
    }

    // Phương thức xóa
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        if (index == 0) {
            E data = head.data;
            head = head.next;
            numNodes--;
            return data;
        } else {
            Node<E> prev = getNode(index - 1);
            E data = prev.next.data;
            prev.next = prev.next.next;
            numNodes--;
            return data;
        }
    }

    public boolean remove(Object e) {
        Node<E> prev = null;
        Node<E> curr = head;
        while (curr != null) {
            if (curr.data.equals(e)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                numNodes--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        Node<E> curr = head;
        while (curr != null) {
            newList.addLast(curr.data);
            curr = curr.next;
        }
        return newList;
    }

    public boolean contains(E o) {
        Node<E> curr = head;
        while (curr != null) {
            if (curr.data.equals(o)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node<E> curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data.equals(o)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        // do nothing, since this implementation does not use arrays
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public E getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    // helper methods
    private Node<E> getNode(int index) {
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // inner class for Node
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", numNodes=" + numNodes +
                '}';
    }
}
