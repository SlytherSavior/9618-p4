import java.util.Scanner;

public class LinearQueue {
  // declare max length , pointers and queue 
  static String[] queue; 
  static int maxLength = 0; 
  static int frontPointer = 0 ; 
  static int endPointer  = -1 ; 

  public static void create(){ 
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the maximum size of the queue you want");
    maxLength = scanner.nextInt(); 
    queue = new String[maxLength];
  }

  public static void enqueue(){ 
    Scanner scanner = new Scanner(System.in);
    if(endPointer != queue.length - 1){ 
      System.out.println("Enter the value of string you want to enter \n");
      String value = scanner.nextLine();
      queue[endPointer + 1 ] = value ;
      endPointer += 1 ; 
      System.out.println("Added " + value + " the queue is now " + queue );
    }else { 
      System.out.println("Sorry the queue is already full ( As it is a linear queue so no more added )");
    }
  }





  
}
