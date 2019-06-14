public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList=new MyLinkedList(10);

        myLinkedList.addLast(2);
        myLinkedList.addLast(12);
        myLinkedList.addLast(6);
        myLinkedList.addLast(4);

        myLinkedList.add(3,5);
        myLinkedList.printList();


    }
}
