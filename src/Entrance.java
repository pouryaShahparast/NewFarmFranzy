import java.io.*;
import java.util.Scanner;



public class Entrance {

    public static boolean isGameRunning=true;
    public static int levelOfUser,userInitialCoins;
    public Task taskOfLevel1, taskOfLevel2, taskOfLevel3, taskOfLevel4, taskOfLevel5;

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




        initializeUserLevelAndCoins(userName);
        initializeTasks();



        //start playing  Game


        System.out.println("*****************Enter your commands here*****************");
        String input="";
        Regex regex=new Regex(taskOfLevel1);
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
            //create a file with username name
            File userFile=new File("E:\\"+userName+".txt");
            userFile.createNewFile();
            FileWriter userFileWriter=new FileWriter(userFile);
            /*file format:

              int level:
              int  coins


            */

            userFileWriter.write("1\\n\\200");
            userFileWriter.close();











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

    public void initializeTasks()
    {

        /*
initializing tasks of levels

 */


        /////////////////////////////////////////////////////////////
        //level1
        taskOfLevel1=new Task(1,50,60,400,300,200);
        taskOfLevel1.animalsAppearing.put("bear",20);
        taskOfLevel1.animalsAppearing.put("bear",35);

        taskOfLevel1.neededCommodity.put("egg",5);
        taskOfLevel1.neededCommodity.put("turkey",2);

        //level2
        taskOfLevel2=new Task(2,70,90,500,300,350);
        taskOfLevel2.animalsAppearing.put("bear",15);
        taskOfLevel2.animalsAppearing.put("bear",50);
        taskOfLevel2.animalsAppearing.put("tiger",35);

        taskOfLevel2.neededCommodity.put("egg",10);
        taskOfLevel2.neededCommodity.put("turkey",5);
        taskOfLevel2.neededCommodity.put("bread",5);
        taskOfLevel2.neededCommodity.put("cow",2);
        taskOfLevel2.neededCommodity.put("milk",2);
        //level3
        taskOfLevel3=new Task(3,90,110,600,700,400);
        taskOfLevel3.animalsAppearing.put("bear",15);
        taskOfLevel3.animalsAppearing.put("bear",70);
        taskOfLevel3.animalsAppearing.put("bear",40);
        taskOfLevel3.animalsAppearing.put("tiger",35);
        taskOfLevel3.animalsAppearing.put("tiger",5);

        taskOfLevel3.neededCommodity.put("egg",10);
        taskOfLevel3.neededCommodity.put("turkey",5);
        taskOfLevel3.neededCommodity.put("bread",5);
        taskOfLevel3.neededCommodity.put("cow",3);
        taskOfLevel3.neededCommodity.put("milk",5);
        taskOfLevel3.neededCommodity.put("icevream",5);
        //level4
        taskOfLevel4=new Task(4,110,150,800,850,500);
        taskOfLevel4.animalsAppearing.put("bear",5);
        taskOfLevel4.animalsAppearing.put("bear",70);
        taskOfLevel4.animalsAppearing.put("bear",40);
        taskOfLevel4.animalsAppearing.put("tiger",35);
        taskOfLevel4.animalsAppearing.put("tiger",90);
        taskOfLevel4.animalsAppearing.put("lion",96);

        taskOfLevel4.neededCommodity.put("egg",10);
        taskOfLevel4.neededCommodity.put("turkey",5);
        taskOfLevel4.neededCommodity.put("chicken",5);
        taskOfLevel4.neededCommodity.put("bread",5);
        taskOfLevel4.neededCommodity.put("cow",5);
        taskOfLevel4.neededCommodity.put("milk",5);
        taskOfLevel4.neededCommodity.put("icevream",5);
        taskOfLevel4.neededCommodity.put("wool",5);
        //level5
        taskOfLevel5=new Task(5,150,200,1000,850,750);
        taskOfLevel5.animalsAppearing.put("bear",5);
        taskOfLevel5.animalsAppearing.put("bear",70);
        taskOfLevel5.animalsAppearing.put("bear",40);
        taskOfLevel5.animalsAppearing.put("bear",60);
        taskOfLevel5.animalsAppearing.put("tiger",35);
        taskOfLevel5.animalsAppearing.put("tiger",90);
        taskOfLevel5.animalsAppearing.put("lion",96);
        taskOfLevel5.animalsAppearing.put("lion",105);
        taskOfLevel5.animalsAppearing.put("lion",120);

        taskOfLevel5.neededCommodity.put("egg",20);
        taskOfLevel5.neededCommodity.put("turkey",10);
        taskOfLevel5.neededCommodity.put("chicken",8);
        taskOfLevel5.neededCommodity.put("bread",5);
        taskOfLevel5.neededCommodity.put("cow",5);
        taskOfLevel5.neededCommodity.put("milk",5);
        taskOfLevel5.neededCommodity.put("icevream",5);
        taskOfLevel5.neededCommodity.put("wool",5);
        taskOfLevel5.neededCommodity.put("flour",10);
        taskOfLevel5.neededCommodity.put("feather",10);



///////////////////////////////////////////////////////////////////////////////////









    }
    public void initializeUserLevelAndCoins(String userName)
    {
        Scanner scanner;
        File userFile=new File("E:\\"+userName+".txt");

        try {
            scanner=new Scanner(userFile);
            FileReader fileReader=new FileReader(userFile);
            levelOfUser=scanner.nextInt();
            userInitialCoins=scanner.nextInt();

            System.out.println(userName+"  you are at level "+levelOfUser+" and you have "+userInitialCoins+" coins");




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }








    }



}




