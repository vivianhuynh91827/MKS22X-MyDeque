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
    //if start is at the beginning and there is space at the end of the array
    if (start == 0 && data[data.length-1] == null) {
      start = data.length-1; //start is at the end of the array
      data[start] = element; //add element
    }
    // if the entire array is full or if there is no space behind start, resize and add element
    else if ((start == 0 && data[data.length-1] != null) || (data[start-1] != null)) {
      data = resize();
      start = data.length-1; //add element
      data[start] = element;
    }
    else { //if there is space
      start--;
      data[start] = element;
    }
  }

  public void addLast(E element) {

  }

  private E[] resize() {
    @SuppressWarnings("unchecked")
    E[] resized = (E[])new Object[size * 2];
    if (start < end) { //if the start is before the end
      for (int i = 0 ; i < size; i ++) {
        resized[i] = data[start+i];
      }
    }
    else {
      int i = 0;
      int cur = start;
      while (cur < data.length) {
        resized[i] = data[cur];
        cur++;
        i++;
      }
      cur = 0;
      while (cur != end) {
        resized[i] = data[cur];
        cur++;
        i++;
      }
    }
    System.out.println("New Length: " + resized.length);
    return resized;
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

  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<>();
    test.resize();
  }
}
