class Stack<T> {

    Node<T> top;
    int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T e) {
        Node<T> novo = new Node<>(e);
        novo.next = top;
        top = novo;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }

        T valor = top.element;
        top = top.next;
        size--;
        return valor;
    }

    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return top.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> atual = top;

        for (int i = 0; i < size; i++) {
            array[i] = atual.element;
            atual = atual.next;
        }

        return array;
    }

    public String toString() {
        String s = "";
        Node<T> atual = top;

        while (atual != null) {
            s += atual.element + " ";
            atual = atual.next;
        }

        return s;
    }
}