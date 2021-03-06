public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList() {
   size = 0;
   start = null;
   end = null;
  }

  public int size() {
   return size;
  }

  //Getting node from index
  private Node getNodeFromIndex(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   Node current = start;
   for (int i = 0; i < index; i++) {
     current = current.getNext();
   }
   return current;
  }

  public boolean add(String value) {
   Node nodeToAdd = new Node(value);
   if (size() == 0) {
     start = nodeToAdd;
   }
   else {
     nodeToAdd.setPrev(end);
     end.setNext(nodeToAdd);
   }
   size++;
   end = nodeToAdd;
   return true;
  }

  public void add(int index, String value) {
   Node nodeToAdd = new Node(value);
   //If outside range
   if (index < 0 || index > size()) {
     throw new IndexOutOfBoundsException();
   }
   //If at end
   else if (index == size()) {
     if (size() == 0) {
       start = nodeToAdd;
     }
     else {
       nodeToAdd.setPrev(end);
       end.setNext(nodeToAdd);
     }
     end = nodeToAdd;
   }
   //If at start
   else if (index == 0) {
     start.setPrev(nodeToAdd);
     nodeToAdd.setNext(start);
     start = nodeToAdd;
   }
   //If at middle of linked list
   else {
     Node prev = getNodeFromIndex(index - 1);
     Node next = prev.getNext();
     nodeToAdd.setPrev(prev);
     nodeToAdd.setNext(next);
     prev.setNext(nodeToAdd);
     next.setPrev(nodeToAdd);
   }
   size++;
  }

  public String get(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   Node valueHere = getNodeFromIndex(index);
   return valueHere.getData();
  }

  public String set(int index, String value) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   Node nodeToUpdate = getNodeFromIndex(index);
   String oldValue = nodeToUpdate.getData();
   nodeToUpdate.setData(value);
   return value;
  }

  public String toString() {
   if (size() == 0) {
     return "[]";
   }
   String toReturn = "[";
   Node current = start;
   for (int i = 0; i < size(); i++) {
     toReturn += current.getData();
     if (i < size() - 1) {
       toReturn += ", ";
       current = current.getNext();
     }
     else {
       toReturn += "]";
     }
   }
   return toReturn;
  }

  public String remove(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   String removedData = get(index);
   if (size() == 1) {
     start = null;
     end = null;
   }
   else if (index == 0) {
     Node toRemove = start;
     Node next = toRemove.getNext();
     next.setPrev(null);
     start = next;
   }
   else if (index == size() - 1) {
     Node toRemove = end;
     Node prev = toRemove.getPrev();
     prev.setNext(null);
     end = prev;
   }
   else {
     Node toRemove = getNodeFromIndex(index);
     Node next = toRemove.getNext();
     Node prev = toRemove.getPrev();
     next.setPrev(prev);
     prev.setNext(next);
   }
   size--;
   return removedData;
  }
 /*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
  public void extend(MyLinkedList other){
    Node otherStart = other.start;
    Node otherEnd = other.end;
    end.setNext(otherStart);
    otherStart.setPrev(end);
    end = otherEnd;
    size += other.size();
    otherStart = null;
    otherEnd = null;
    other.size = 0;
  }
}
