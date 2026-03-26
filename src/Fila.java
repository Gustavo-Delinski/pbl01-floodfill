class Queue<T> {

    Node<T> first;
    Node<T> top;
    int size;

    public Queue() {
        first = null;
        top = null;
        size = 0;
    }

    public void enqueue(T e) {
        Node<T> novo = new Node<>(e);

        if (isEmpty()) {
            first = novo;
            top = novo;
        } else {
            top.next = novo;
            top = novo;
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        T valor = first.element;
        first = first.next;
        size--;

        if (isEmpty()) {
            top = null;
        }

        return valor;
    }

    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        return first.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        top = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> atual = first;

        for (int i = 0; i < size; i++) {
            array[i] = atual.element;
            atual = atual.next;
        }

        return array;
    }

    public String toString() {
        String s = "";
        Node<T> atual = first;

        while (atual != null) {
            s += atual.element + " ";
            atual = atual.next;
        }

        return s;
    }
}