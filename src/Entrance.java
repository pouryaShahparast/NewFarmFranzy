import java.io.*;
import java.util.Scanner;



public class Entrance {

    public static boolean isGameRunning=true;




    public Entrance()
    {
        System.out.println(ConsoleColors.YELLOW+"*******************Welcome to the project******************\n\n"+ConsoleColors.RESET);

    }
    public void menu()
    {
        System.out.println(ConsoleColors.RED+"1-LOG IN\n2-SIGNUP\n"+ConsoleColors.RESET);
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        if(input==1)
            logIn();
        if(input==2)
            signUp();
        else
            System.out.println("wrong input");
        menu();

    }
    public void logIn() {
        System.out.println("logging in........Enter your USERNAME ");

        Scanner scanner = new Scanner(System.in);
        String userName ="";
        userName= scanner.nextLine();

        if (!checkIfUserExists(userName)) {
            System.out.println(ConsoleColors.RED + "you are not in the list ,please sign up first" + ConsoleColors.RESET);
            menu();
            return;

        }
        System.out.println("Enter your password ");
        String password="";
        password=scanner.nextLine();
        if(!checkIfPasswordIsCorrect(userName,password))
        {
            logIn();
            return;
        }




        //

        //start playing  Game
        System.out.println("*****************Enter your commands here*****************");
        String input="";
        Regex regex=new Regex();
        while(isGameRunning)
        {
            input=scanner.nextLine();
            regex.matcher(input);
        }





        //




    }
    public void signUp()
    {

        String userName="",password="";
        System.out.println("Enter USERNAME");
        Scanner scanner=new Scanner(System.in);
        userName=scanner.nextLine();
        if(checkIfUserExists(userName))
        {
            System.out.println(ConsoleColors.RED+"Already Taken"+ConsoleColors.RESET);
            signUp();

        }


        File userNameAndPasswords=new File("E:\\password.txt");
        if(!userNameAndPasswords.exists())
        {

            try {
                userNameAndPasswords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        scanner=null;

        try {
            scanner=new Scanner(userNameAndPasswords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter=new FileWriter(userNameAndPasswords,true);
            scanner=new Scanner(System.in);
            System.out.println("Enter your password (only digits)");
            password=scanner.nextLine();
            fileWriter.write(userName+"\n"+password+"\n");
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



        logIn();


    }

    public boolean checkIfUserExists(String userName)
    {
        File userNameAndPasswords=new File("E:\\password.txt");
        if(!userNameAndPasswords.exists())
        {

            try {
                userNameAndPasswords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("problem in creating");
            }

        }
        Scanner scanner=null;

        try {
            scanner=new Scanner(userNameAndPasswords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp1="";
        while(scanner.hasNextLine())
        {
            temp1=scanner.nextLine();
            if(temp1.equals(userName))
            {
                return true;
            }





        }


        return false;





    }
    public boolean checkIfPasswordIsCorrect(String userName,String password)
    {
        File userNameAndPasswords=new File("E:\\password.txt");
        if(!userNameAndPasswords.exists())
        {

            try {
                userNameAndPasswords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Scanner scanner=null;

        try {
            scanner=new Scanner(userNameAndPasswords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String temp1="";
        while(scanner.hasNextLine())
        {
            temp1=scanner.nextLine();
            if(temp1.equals(userName))
            {
                temp1=scanner.nextLine();
                if(temp1.equals(password))
                {
                    return true;
                }



            }

        }
        System.out.println(ConsoleColors.RED+"Wrong"+ConsoleColors.RESET);
        return false;





    }

}




