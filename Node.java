public class Node {
  private String data;
  private Node next,prev;

  public Node(String value) {
    data = value;
    prev = null;
    next = null;
  }
  //write get/set methods for all three instance variables.
  //get methods
  public String getData() {
    return data;
  }
  public Node getPrev() {
    return prev;
  }
  public Node getNext() {
    return next;
  }
  //set methods
  public String setData(String newData) {
    String oldData = data;
    data = newData;
    return data;
  }
  public Node setPrev(Node prevNode) {
    Node oldPrev = prev;
    prev = prevNode;
    return oldPrev;
  }
  public Node setNext(Node nextNode) {
    Node oldNext = next;
    next = nextNode;
    return oldNext;
  }
}
