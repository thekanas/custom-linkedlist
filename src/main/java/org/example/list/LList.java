package org.example.list;

import java.util.Collection;
import java.util.Comparator;

/**
 * Необходимо написать свою реализацию коллекции на выбор LinkedList или ArrayList(можно оба варианта).
 * Должны быть основные методы add, get, remove, addAll, остальное на ваше усмотрение
 * Плюс написать реализацию сортировки пузырьком с флагом, который прекращает сортировку, если коллекция уже отсортирована.
 * Задание с *: На тему дженериков. Для этих коллекций сделать конструктор который будет принимать другую коллекцию в качестве параметров и инициализироваться с элементами из этой коллекции.
 * Вторая часть - сделать метод сортировки статическим, этот метод также будет принимать какую-то коллекцию и сортировать ее. (Аналогия Collections.sort()).
 * Т.е подумать на тему какое ключевое слово(extends или super) будет лучше применить для этих двух задач.
 */
public class LList<T> {

    private final Node<T> head = new Node<>(null, null, null);
    private final Node<T> tail = new Node<>(null, null, null);
    private int size = 0;

    public LList() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    public LList(Collection<? extends T> collection) {
        head.setNext(tail);
        tail.setPrev(head);
        addAll(collection);
    }

    public void add(T value) {
        Node<T> current = new Node<>(tail, tail.getPrev(), value);
        tail.getPrev().setNext(current);
        tail.setPrev(current);
        size++;
    }

    public T get(int index) {
        if(index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public T remove(int index) {
        Node<T> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        size--;
        return current.getValue();
    }

    public void addAll(Collection<? extends T> collection) {
        for (T val : collection) {
            add(val);
        }
    }

    public void sort(Comparator<T> comparator) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < this.size - 1; j++) {
                if (comparator.compare(this.get(j), this.get(j + 1)) > 0) {
                    swap(this.getNode(j), this.getNode(j + 1));
                    flag = true;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    private void swap(Node<T> t1, Node<T> t2) {
        T temp = t1.getValue();
        t1.setValue(t2.getValue());
        t2.setValue(temp);
    }

    private Node<T> getNode(int index) {
        Node<T> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
}
