import java.util.Scanner;

public class Student {
    public static void main()
    {
        Scanner input =new Scanner(System.in);
        String nameStudent []= new String[5];
        double grades [][]= new double[5][3];
        byte passedStudents=0;
        byte m=0;
        for(int i=0;i< grades.length;i++)
        {
            int n=0;
            System.out.print(" please enter your name : ");

            nameStudent[i]=input.nextLine();
            for(int j=0;j<grades[i].length;j++) {
                n++;
                System.out.print(" please enter your grade for subject 'Grades must be between 0 and 100.' "+n+" ");
                if(input.hasNextDouble()&& grades[i][j]>=0&&grades[i][j]<=100) {
                    grades[i][j] = input.nextDouble();
                    if (grades[i][j] >= 50)
                        m++;
                }
                else
                {
                    System.out.println("Invalid input");
                    input.next();
                }
            }
            if(m<=3&&m!=0)
                passedStudents++;
            input.nextLine();

        }
        menu(nameStudent,grades,passedStudents);

    }
    public static void menu(String nameStudent [], double grades [][],byte passedStudents)
    {
        Scanner input =new Scanner(System.in);
        boolean nonExit = true;
        while (nonExit) {
            System.out.println("1. Show All Students names.\n 2. Show all Students grades in each subject.\n 3. Search Student by name.\n 4. Count Passed Students\n 0. Exit ");
            System.out.println(" please enter the number of service from the menu ");
            byte numMenu = 0;
            if (input.hasNextByte() && numMenu >= 0 && numMenu <= 5) {

                numMenu = input.nextByte();
                switch (numMenu) {
                    case 1:
                        for (int i = 0; i < nameStudent.length; i++)
                            System.out.println(nameStudent[i]);
                        break;
                    case 2:
                        double gradesSub[][] = new double[3][5];

                        for (int i = 0; i < grades.length; i++) {
                            for (int j = 0; j < grades[i].length; j++) {
                                gradesSub[j][i] = grades[i][j];
                            }

                        }
                        int n = 0;
                        for (int i = 0; i < gradesSub.length; i++) {

                            for (int j = 0; j < gradesSub[i].length; j++) {
                                n++;

                                System.out.println("the grade of subject "+n+"="+gradesSub[i][j]);

                            }

                        }
                        break;
                    case 3:
                        String name = new String();
                        System.out.println(" please enter name ");
                        if (input.hasNext()) {
                            name = input.next();
                            boolean found = false;
                            for (int i = 0; i < nameStudent.length; i++) {
                                if (nameStudent[i] == name)
                                    found = true;
                            }
                            if (found)
                                System.out.println(" the name is found ");
                            else
                                System.out.println(" the name is found ");
                        } else {
                            System.out.println("Invalid input");
                            input.next();
                        }
                        break;
                    case 4:
                        System.out.println(" the number of Passed Students = " + passedStudents);
                        break;
                    case 0:
                        nonExit=false;
                        break;
                    default:
                        break;
                }

            } else {
                System.out.println("Invalid input");

            }
        }



    }
}
