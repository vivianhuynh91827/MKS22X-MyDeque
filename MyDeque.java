public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String s = "{";
    if (size == 0) return "{}";
    if (start < end) { // if the start is before the end
      for (int i = start; i < size; i++) {
        s+=data[i] + " ";
      }
    }
    else { // if the list loops around to the front
      for (int i = start; i < data.length; i ++) {
        s+=data[i] + " ";
      }
      int i = 0;
      while (i != end) {
        s+=data[i] + " ";
      }
    }
    s = s.substring(0, s.length()-2);
    s += "}";
    return s;
  }

  public void addFirst(E element) {

  }

  public void addLast(E element) {

  }

  private E[] resize() {
    E[] resized = (E[])new Object[size * 2];

  }

  // public E removeFirst(){
  //
  // }
  //
  // public E removeLast(){
  //
  // }

  public E getFirst(){
    return data[start];
  }

  public E getLast() {
    return data[end];
  }
}
