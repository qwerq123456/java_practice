import java.util.*;

class Node <E> {
    E data;
    Node<E> next;
    public Node (E node) {
        this.data = node;
        this.next = null;
    }
}
public class GudgleList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public GudgleList() {
        this.size = 0;
        this.head = null;
    }
    public void add (E e){
        addLast(e);
    }
    public void add(int index, E e){
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = new Node<>(e);
        if(index == 0) {
            node.next = head;
            head = node;
        } else if(index == size()) {
            tail = node;
        } else {
            Node<E> front = head;
            Node<E> back;
            for(int i = 0; i<index-1; i++) {
                front = front.next;
            }
            back = front.next.next;
            front.next = node;
            node.next = back;
        }
        size++;
    }
//    public boolean addAll(Collection<? extends E> c) {
//
//    }
//    public boolean addAll(int index, Collection<? extends E> c){
//
//    }
    public void addFirst(E e){
        Node<E> node = new Node<>(e); // why it needs <>?
        if(head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }
    public void addLast(E data) {
        Node<E> node = new Node(data);
        if(head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }
    public void clear(){
        head = null;
        size = 0;
    }
//    public Object clone() {
//
//    }
    public boolean contains(E e) {
        Node<E> temp = head;
        while(head != null) {
            if(head.data.equals(e)) return true;
            head = head.next;
        }
        return false;
    }
//    public Iterator<E> descendingIterator() {
//
//    }
    public E element() {
        return getFirst();
    }
    public E get(int index) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) return head.data;
        Node<E> temp = head;
        for(int i = 0; i<index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public E getFirst() {
        if(size == 0) throw new NoSuchElementException();
        return head.data;
    }
    public E getLast () {
        if(size == 0) throw new NoSuchElementException();
        return tail.data;
    }
    public int indexOf(E e) {
        Node<E> temp = head;
        if(temp.data.equals(e)) return 0;
        for(int i = 1; i < size; i++) {
            temp = temp.next;
            if(temp.data.equals(e)) return i;
        }
        return -1;
    }
    public int lastIndexOf (E e) {
        Node<E> temp = head;
        int index = -1;
        if(temp.data.equals(e)) index = 0;
        for(int i = 1; i < size; i++) {
            temp = temp.next;
            if(temp.data.equals(e)) index = i;
        }
        return index;
    }
//    public ListIterator<E> listIterator (int index) {
//
//    }
    public boolean offer(E e) {
        addLast(e);
        return true;
    }
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
    public E peek() {
        return getFirst();
    }
    public E peekFirst() {
        return getFirst();
    }
    public E peekLast () {
        return getLast();
    }
    public E poll () {
        return removeFirst();
    }
    public E pollFirst() {
        return removeFirst();
    }
    public E pollLast () {
        return removeLast();
    }
    public E pop() {
        return removeLast();
    }
    public void push(E e) {
        addFirst(e);
    }
    public E remove() {
        if(size == 0) throw new NoSuchElementException();
        Node<E> e = head;
        head = head.next;
        size--;
        return e.data;
    }
    public E remove(int index) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            return remove();
        } else if(index == size()) {
            return removeLast();
        } else {
            Node<E> front = head;
            Node<E> back;
            Node<E> e;
            for(int i = 0; i<index-1; i++) {
                front = front.next;
            }
            back = front.next.next;
            e = front.next;
            front.next = back;
            size --;
            return e.data;
        }
    }
    public boolean remove(E e) {
        if(size == 0) return false;

        if(head.data.equals(e)) {
            remove();
            return true;
        }

        Node<E> node = head;
        for(int i = 1; i< size; i++ ) {
            node = node.next;
            if(node.data.equals(e)) {
                remove(i);
                return true;
            }
        }

        return false;
    }
    public E removeFirst() {
        return remove();
    }
    public boolean removeFirstOccurrence(E e){
        return remove(e);
    }
    public E removeLast() {
        if(size == 0) throw new NoSuchElementException();
        Node<E> node = head;
        for(int i = 0; i< size-1; i++) {
            node = node.next;
        }
        tail = node;
        node = tail.next;
        tail.next = null;
        return node.data;
    }
//    public boolean removeLastOccurrence(Object o) {
//        // sibal 이거 존나 골때리네
//    }
    public E set(int index, E e) {
        E temp;
        Node<E> node = head;
        for(int i = 0; i < size-1; i++) {
            node = node.next;
        }
        temp = node.data;
        node.data = e;
        return temp;
    }
    public int size(){
        return size;
    }
//    public Spliterator<E> spliterator () {
//
//    }
//    public Object[] toArray () {
//
//    }
//    public E[] toArray (E[] a) {
//        E[] EArr = new E[size];
//
//    }
}
