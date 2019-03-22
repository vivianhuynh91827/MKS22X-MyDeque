import java.util.*;
import java.io.*;

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
      
      while (i != end + 1) {
        s+=data[i] + " ";
        i++;
      }
    }
    s = s.substring(0, s.length()-1);
    s += "}";
    return s;
  }

  public void addFirst(E element) {
    // System.out.println(element);
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
    size++;
    // System.out.println(Arrays.toString(data));
    // System.out.println("size: " +size);
    System.out.println();
    System.out.println("End: " + end);
    System.out.println("Start: " + start);
    System.out.println("Size: "+ size);
  }

  public void addLast(E element) {

  }

  private E[] resize() {
    @SuppressWarnings("unchecked")
    E[] resized = (E[])new Object[size * 2];
    int oldStart = start;
    int oldEnd = end;
    start = 0;
    end = size-1;
    // System.out.println("end: " +end);
    if (oldStart < oldEnd) { //if the start is before the end
      for (int i = 0 ; i < size; i ++) {
        resized[i] = data[oldStart+i];
      }
    }
    else {
      int cur = 0; //cur index in the new array
      for (int i = 0 ; oldStart + i < data.length; i++) {
        resized[i] = data[oldStart+i];
        cur = i;
      }
      cur++;
      int i = 0;
      while (i != oldEnd) {
        resized[cur] = data[i];
        cur++;
        i++;
      }
    }
    // System.out.println("End: " + end);
    // System.out.println("Start: " + start);
    // System.out.println("Size: "+ size);
    // System.out.println("New Length: " + resized.length);
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
    test.addFirst(1);
    test.addFirst(2);
    test.addFirst(3);
    test.addFirst(4);
    test.addFirst(5);
    test.addFirst(6);
    test.addFirst(7);
    test.addFirst(8);
    test.addFirst(9);
    test.addFirst(10);
    test.addFirst(11);
    System.out.println("hi");
    System.out.println("size: " +test.size());
    System.out.println("First: " + test.getFirst());
    System.out.println("Last: " + test.getLast());
    System.out.println(test);
  }
}
