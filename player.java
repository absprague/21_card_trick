import java.util.Scanner;

public class Player {
  private card = null;

  public static int indicateColumn(){
    Scanner input = new Scanner(System.in);
    System.out.print("Please indicate column: \n");
    String column = input.next();
    System.out.println(column);

    return Integer.parseInt(column);
  }

  public static void pickCard(){
    //card = new Card();
  }

  public static void main (String[] args) {
    indicateColumn();
  }
}
