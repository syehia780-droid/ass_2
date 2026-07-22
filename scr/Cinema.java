import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

   public static void main() {
// دي طريقة
// String num = new String();
//num ="12";
//       System.out.println(num.charAt(0)-'0');
//int n=num.charAt(0)-'0';
//       System.out.println(n);
// دي طريقة تانية بس الفكرة ان انا مكسل و نعسان اعمل واحد فيهم
//       int n=12;
//       int  c=n%10;
//       int r=n/10;
//       System.out.println(c+" "+r);


        char[][] seats = new char[5][6];
        String[] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};
        byte numService=0;
        byte numRow=0;
        byte numColumn=0;
        byte bookedSeat=0;
        byte availableSeat=30;

        for (int i = 0; i < seats.length; i++)
            Arrays.fill(seats[i], 'O');
            Menu(numService,seats,movieNames,numRow,numColumn, bookedSeat,availableSeat);

    }
    public static void Menu(byte numService, char[][] seats,String[] movieNames, byte numRow,
    byte numColumn,
    byte bookedSeat,
    byte availableSeat
     )
    {
        Scanner input = new Scanner(System.in);
        boolean nonExit = true;

        while (nonExit) {
            System.out.println("1. Display Seats\n2. Book Seat\n3. Cancel Booking\n4. Show all movies.\n5. Show number of available and booked seats\n0. Exit");
            System.out.print("please enter the number of service ");
            if(input.hasNextByte() )
            {
                numService=input.nextByte();
                if(numService>0&&numService<=5) {
                    switch (numService) {
                        case 1:
                            for (int i = 0; i < seats.length; i++) {
                                for (int j = 0; j < seats[i].length; j++)
                                    System.out.print(seats[i][j] + " ");
                                System.out.println();

                            }
                            break;
                        case 2:
                            System.out.print(" please enter the number of row and column seat ");
                            if (input.hasNextByte()) {
                                numRow = input.nextByte();
                                numColumn = input.nextByte();

                                if (numRow > 0 && numRow < 6 && numColumn > 0 && numColumn < 7) {
                                    if (seats[numRow - 1][numColumn - 1] == 'O') {
                                        System.out.println(" The booking was successful. ");
                                        seats[numRow - 1][numColumn - 1] = 'X';
                                        availableSeat--;
                                        bookedSeat++;
                                    } else if (seats[numRow - 1][numColumn - 1] == 'X')
                                        System.out.println(" Sorry ,  the seat is Booked .");
                                } else
                                    System.out.println(" outside the scope of seats .");

                            } else {

                                System.out.println("Invalid input");
                                input.next();
                            }
                            break;

                        case 3:
                            System.out.print(" please enter the number of row and column seat ");
                            if (input.hasNextByte()) {
                                numRow = input.nextByte();
                                numColumn = input.nextByte();

                                if (numRow > 0 && numRow < 6 && numColumn > 0 && numColumn < 7) {
                                    if (seats[numRow - 1][numColumn - 1] == 'X') {
                                        System.out.println(" The booking has been cancelled. ");
                                        seats[numRow - 1][numColumn - 1] = 'O';
                                        availableSeat++;
                                        bookedSeat--;
                                    } else if (seats[numRow - 1][numColumn - 1] == 'O')
                                        System.out.println(" Sorry ,  the seat is not Booked .");
                                } else
                                    System.out.println(" outside the scope of seats .");

                            } else {

                                System.out.println("Invalid input");
                                input.next();
                            }
                            break;
                        case 4:
                            for (int i = 0; i < movieNames.length; i++)
                                System.out.println(movieNames[i]);
                            break;
                        case 5:
                            System.out.println("booked seats =  " + bookedSeat);
                            System.out.println("available seats =  " + availableSeat);
                            break;

                        default:
                            System.out.println(" Goodbye ");
                            nonExit = false;
                            break;


                    }
                }
                else
                {
                    System.out.println(" outside the scope of menu  .");
                }

            }
            else
            {
                System.out.println("Invalid input");
                input.next();
            }

        }
    }
}
