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
    // System.out.println(Arrays.toString(data));
    if (size == 0) return "{}";
    if (start <= end) { // if the start is before the end
      for (int i = start; i <= end; i++) {
        s+=data[i] + " ";
      }
    }
    else { // if the list loops around to the front
      for (int i = start; i < data.length; i ++) {
        s+=data[i] + " ";//go to the end of the array
      }
      int i = 0;

      while (i <= end) { //add elements from beginning of array to end
        s+=data[i] + " ";
        i++;
      }
    }
    s = s.substring(0, s.length()-1); //remove extra space
    s += "}"; //close lise
    // System.out.println();
    // System.out.println("First: " + getFirst());
    // System.out.println("Last : " + getLast());
    return s;
  }

  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException();
    }
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
    if (size == 0) {
      end = start;
    }
    size++;
    // System.out.println(Arrays.toString(data));
    // System.out.println("size: " +size);
    // System.out.println();
    // System.out.println("End: " + end);
    // System.out.println("Start: " + start);
    // System.out.println("Size: "+ size);
  }

  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException();
    }
    //if end is at the end of the array and there is space in the beginning of the array
    if (end == data.length -1 && data[0] == null) {
      end = 0;
      data[end] = element;
    }
    // if end is last in the array  and there is not spaces in the beginning
    // of if end is in the middle of the array and there is not space after
    // resize and add element
    else if ((end == data.length - 1 && data [0] != null) || (data[end + 1] != null)) {
      data = resize();
      end = size;
      data[end]= element;
    }
    // if end is in the middle of the array and there is space
    else {
      end++;
      data[end] = element;
    }
    size++;
  }

  private E[] resize() {
    @SuppressWarnings("unchecked")
    E[] resized = (E[])new Object[size * 2]; //create new array
    int oldStart = start; //store start and end for the original data
    int oldEnd = end;
    start = 0; //new start and end values in resized array
    end = size-1;
    // System.out.println("end: " +end);
    if (oldStart <= oldEnd) { //if the start is before the end
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
      while (i <= oldEnd) {
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

  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E value = data[start];
    data[start] = null;
    size--;
    if (size ==0 || size == 1) {
      start = end;
    }
    else if (start == data.length-1) {
      start = 0;
    }
    else {
      start ++;
    }
    return value;
  }

  // public E removeLast(){
  //
  // if (size == 0) {
  //   throw new NoSuchElementException("deque is empty");
  // }
  // }

  public E getFirst(){
    return data[start];
  }

  public E getLast() {
    return data[end];
  }

  public static void main(String[] args) {
    try {
      MyDeque<Integer> test = new MyDeque<>();
      test.addFirst(1);
      System.out.println(test);
      test.addFirst(2);
      System.out.println(test);
      test.addFirst(3);
      System.out.println(test);
      test.addFirst(4);
      System.out.println(test);
      test.addFirst(5);
      System.out.println(test);
      test.addFirst(6);
      System.out.println(test);
      test.addFirst(7);
      System.out.println(test);
      test.addFirst(8);
      System.out.println(test);
      // test.addFirst(9);
      // test.addFirst(10);
      // // test.addFirst(11);
      test.addLast(0);
      System.out.println(test);
      test.addLast(-1);
      System.out.println(test);
      test.addLast(-2);
      System.out.println(test);
      test.addLast(-3);
      System.out.println(test);
      test.addLast(-4);
      System.out.println(test);
      test.addLast(-5);
      System.out.println(test);
      test.addFirst(null);
      // System.out.println();
      // System.out.println("size: " +test.size());
      // System.out.println("First: " + test.getFirst());
      // System.out.println("Last: " + test.getLast());
      // System.out.println(test);
    }
    catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  }
}
