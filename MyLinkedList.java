public class MyLinkedList<E> {

    private Node head=null;
    private Node tail =null;
    private int size;

    public MyLinkedList(E element) {
        head = new Node<>(element);
    }

    public class Node<E>{
        private Node<E> next;
        private E element;

        public Node(E element){
            this.element=element;
        }

        public E getElement(){
            return this.element;
        }
    }

    public void printList(){
        Node temp =head;
        while (temp != null){
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
    public Node get(int index){
        Node temp = head;
        for (int i=0 ; i<index ; i++){
            temp = temp.next;
        }
        return temp;
    }


    public void addFirst(E e){
        Node<E> newNode =new Node<>(e);
        newNode.next=head;
        head = newNode;
        size++;
        if (tail==null){
            tail = head;
        }

    }

    public void addLast(E e){
        Node<E> newNode = new Node<>(e);

        if (tail == null){
            head =tail =newNode;
        }else {
            tail.next=newNode;
            tail=tail.next;
        }

        size++;
    }

    public void add(int index , E e){
        if (index==0)addFirst(e);
        else if (index >= size)addLast(e);
        else {
            Node<E> current =head;
            for (int i=1 ; i< index ; i++)
                current=current.next;
            Node<E>temp =current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst(){
        if (size == 0)return null;
        else {
            Node<E> temp =head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    public E removeLast(){
        if (size == 0) return null;
        else if (size ==1){
            Node<E> temp =head;
            head = tail = null;
            size =0 ;
            return temp.element;
        }else {
            Node<E> current =head;
            for (int i = 0; i<size-2 ; i++)
                current = current.next;
            Node<E> temp =tail;
            tail =current;
            tail.next = null;
            size--;
            return temp.element;

        }
    }

    public E remove(int index){
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size -1) return removeLast();
        else {
            Node<E> previous =head;

            for (int i = 1; i<index ; i++){
                previous =previous.next;
            }

            Node<E> current =previous.next;
            previous.next =current.next;
            size--;
            return current.element;
        }

    }
}
