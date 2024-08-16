import java.util.Scanner;

public class LinearQueue {
  // declare max length , pointers and queue 
  static String[] queue; 
  static int maxLength = 0; 
  static int frontPointer = 0 ; 
  static int endPointer  = -1 ; 


  //define method to create the queue

  public static void create(){ 
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the maximum size of the queue you want");
    maxLength = scanner.nextInt(); 
    queue = new String[maxLength];
  }

  //define method to enqueue

  public static void enqueue(){ 
    Scanner scanner = new Scanner(System.in);
    if(endPointer != queue.length - 1){ 
      System.out.println("Enter the value of string you want to enter \n");
      String value = scanner.nextLine();
      queue[endPointer + 1 ] = value ;
      endPointer += 1 ; 
      System.out.println("Added " + value + " the queue is now " + java.util.Arrays.toString(queue) );
    }else { 
      System.out.println("Sorry the queue is already full ( As it is a linear queue so no more added )");
    }
  }

  //define method to rearange the queue after dequeing a value

  public static void rearrange(){ 
    while(frontPointer != 0){ 
      for(int i = 0 ; i < queue.length ; i++){ 
        queue[i] = queue[i + 1];        
      }
      frontPointer -= 1 ; 
      endPointer -= 1 ; 
      queue[queue.length - 1] = "";
    }
  }

  //defining the method to dequeue an element from the queue

  public static void dequeue(){ 
    queue[frontPointer] = "";
    frontPointer += 1; 
    rearrange();
    System.out.println("You dequeued an element, the queue is now " + java.util.Arrays.toString(queue));

  }

  //now the main program 

  public static void main(String[] args){ 
    //call the create function to set queue size when the program starts
    create();

    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("Enter the task you want to perform \n" +
                " 1 for enqueue \n" + //
                " 2 for dequeue \n" + //
                " 3 for leaving / exit \n" + //
                "");
      int userChoice = scanner.nextInt();
      if (userChoice == 1){ 
        enqueue();
      }else if(userChoice == 2) {
        dequeue();
      }else if(userChoice == 3) {
        break;
      }else { 
        System.out.println("You chose "  + userChoice + " please choose a valid choice");
      }

    }
    scanner.close();


  }


  
}
