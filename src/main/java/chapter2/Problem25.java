package chapter2;

import chapter2.aux.Node;

public class Problem25 {
    public static Node<Integer> sum(Node<Integer> number1, Node<Integer> number2) {
        if (number1 == null || number1.getNext() == null || 
            number2 == null || number2.getNext() == null) {

            throw new IllegalArgumentException("Invalid numbers!");
        }
        
        Node<Integer> p1 = number1.getNext();
        Node<Integer> p2 = number2.getNext();
        Node<Integer> sumSentinel = new Node<>(null);
        Node<Integer> node = sumSentinel;
        int carryOver = 0;
        int sum, digit;
        
        while ((p1 != null) || (p2 != null)) {
            sum = carryOver +
                  (p1 == null ? 0 : p1.getValue()) +
                  (p2 == null ? 0 : p2.getValue());
            digit = sum % 10;
            carryOver = sum / 10;
            node.setNext(new Node<>(digit));
            node = node.getNext();
            p1 = (p1 == null ? null : p1.getNext());
            p2 = (p2 == null ? null : p2.getNext());
        }
               
        if (carryOver > 0) {
            node.setNext(new Node<>(carryOver));
        }
        
        return sumSentinel;               
    }
}