import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Entrance {

    public static boolean isGameRunning=true;
    public static boolean quitGame=true;
    public static int levelOfUser,userInitialCoins;
    public Task1 taskOfLevel1, taskOfLevel2, taskOfLevel3, taskOfLevel4, taskOfLevel5;

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
        {
            LoggingToFile.logToFile("user logged in","info");
            logIn();
        }

        if(input==2)
        {
            LoggingToFile.logToFile("user signed up","info");
            signUp();
        }

        else {
            System.out.println("wrong input");
            LoggingToFile.logToFile("wrong input in menu", "warning");
            menu();
        }
    }
    public void logIn() {
        System.out.println("logging in........Enter your USERNAME ");

        Scanner scanner = new Scanner(System.in);
        String userName ="";
        userName= scanner.nextLine();

        if (!checkIfUserExists(userName)) {
            System.out.println(ConsoleColors.RED + "you are not in the list ,please sign up first" + ConsoleColors.RESET);
            LoggingToFile.logToFile("user is not in the list of usernames and passwords","warning");
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


        startPlayingGame(userName);




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
            LoggingToFile.logToFile("username has already been token","warning");
            signUp();

        }


        File userNameAndPasswords=new File("password.txt");
        if(!userNameAndPasswords.exists())
        {

            try {
                userNameAndPasswords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                LoggingToFile.logToFile("error in creating file of usernames and passwords","severe");
            }

        }
        scanner=null;

        try {
            scanner=new Scanner(userNameAndPasswords);
        } catch (FileNotFoundException e) {
            LoggingToFile.logToFile("can't find password.txt(signUp)","severe");
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter=new FileWriter(userNameAndPasswords,true);
            scanner=new Scanner(System.in);
            System.out.println("Enter your password ");
            password=scanner.nextLine();
            fileWriter.write("_"+userName+"\n"+password+"\n");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
//create a file with username name
            File userFile = new File(userName + ".txt");
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
            FileWriter userFileWriter = new FileWriter(userFile);
            /*file format:

              int level:
              int  coins


            */

            userFileWriter.write("1\\n\\200");
            userFileWriter.close();
        }
        catch (Exception e)
        {
            LoggingToFile.logToFile("problem in creating file "+userName+".txt","severe");
            e.printStackTrace();
        }

        logIn();


    }

    public boolean checkIfUserExists(String userName)
    {
        File userNameAndPasswords=new File("password.txt");
        if(!userNameAndPasswords.exists())
        {

            try {
                userNameAndPasswords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                LoggingToFile.logToFile("problem in creating password file to check if user exits","severe");

            }

        }
        Scanner scanner=null;

        try {
            scanner=new Scanner(userNameAndPasswords);
        } catch (FileNotFoundException e) {
            LoggingToFile.logToFile("file password.txt not found_(checkIfUserExists)","severe");
            e.printStackTrace();
        }
        String temp1="";
        while(scanner.hasNextLine())
        {
            temp1=scanner.nextLine();
            if(temp1.charAt(0)=='_')
            {
                temp1=temp1.substring(1);
                if(temp1.equals(userName))
                {
                    return true;
                }
            }






        }


        return false;





    }
    public boolean checkIfPasswordIsCorrect(String userName,String password)
    {
        File userNameAndPasswords=new File("password.txt");
        if(!userNameAndPasswords.exists())
        {

            try {
                userNameAndPasswords.createNewFile();
            } catch (IOException e) {
                LoggingToFile.logToFile("problem in creating password file to check if password is correct","severe");
                e.printStackTrace();
            }

        }
        Scanner scanner=null;

        try {
            scanner=new Scanner(userNameAndPasswords);
        } catch (FileNotFoundException e) {
            LoggingToFile.logToFile("file password.txt not found_(checkIfPasswordIsCorrect)","severe");
            e.printStackTrace();
        }

        String temp1="";
        while(scanner.hasNextLine())
        {
            temp1=scanner.nextLine();
            if(temp1.charAt(0)=='_') {
                temp1=temp1.substring(1);
                if (temp1.equals(userName)) {
                    temp1 = scanner.nextLine();
                    if (temp1.equals(password)) {
                        return true;
                    }


                }
            }
        }
        LoggingToFile.logToFile("password is incorrect","info");
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
        taskOfLevel1=new Task1(1,50,60,400,300,200);
        ArrayList<Integer>bearTimes1=new ArrayList<>();
        bearTimes1.add(10);
        bearTimes1.add(35);
        taskOfLevel1.animalsAppearing.put("bear",bearTimes1);

        taskOfLevel1.neededCommodity.put("egg",5);
        taskOfLevel1.neededCommodity.put("turkey",2);

        //level2
        taskOfLevel2=new Task1(2,70,90,500,300,350);

        ArrayList<Integer>bearTimes2=new ArrayList<>();
        bearTimes2.add(10);
        bearTimes2.add(35);
        ArrayList<Integer>tigerTimes2=new ArrayList<>();
        tigerTimes2.add(45);
        taskOfLevel2.animalsAppearing.put("bear",bearTimes2);
        taskOfLevel2.animalsAppearing.put("tiger",tigerTimes2);

        taskOfLevel2.neededCommodity.put("egg",10);
        taskOfLevel2.neededCommodity.put("turkey",5);
        taskOfLevel2.neededCommodity.put("bread",5);
        taskOfLevel2.neededCommodity.put("cow",2);
        taskOfLevel2.neededCommodity.put("milk",2);
        //level3
        taskOfLevel3=new Task1(3,90,110,600,700,400);
        ArrayList<Integer>bearTimes3=new ArrayList<>();
        bearTimes3.add(15);
        bearTimes3.add(40);
        bearTimes3.add(70);
        ArrayList<Integer>tigerTimes3=new ArrayList<>();
        tigerTimes3.add(5);
        tigerTimes3.add(35);
        taskOfLevel3.animalsAppearing.put("bear",bearTimes3);
        taskOfLevel3.animalsAppearing.put("tiger",tigerTimes3);

        taskOfLevel3.neededCommodity.put("egg",10);
        taskOfLevel3.neededCommodity.put("turkey",5);
        taskOfLevel3.neededCommodity.put("bread",5);
        taskOfLevel3.neededCommodity.put("cow",3);
        taskOfLevel3.neededCommodity.put("milk",5);
        taskOfLevel3.neededCommodity.put("ice cream",5);
        //level4
        taskOfLevel4=new Task1(4,110,150,800,850,500);
        ArrayList<Integer>bearTimes4=new ArrayList<>();
        bearTimes4.add(5);
        bearTimes4.add(40);
        bearTimes4.add(70);
        ArrayList<Integer>tigerTimes4=new ArrayList<>();
        tigerTimes4.add(35);
        tigerTimes4.add(90);
        ArrayList<Integer>lionTimes4=new ArrayList<>();
        lionTimes4.add(96);


        taskOfLevel4.animalsAppearing.put("bear",bearTimes4);
        taskOfLevel4.animalsAppearing.put("tiger",tigerTimes4);
        taskOfLevel4.animalsAppearing.put("lion",lionTimes4);


        taskOfLevel4.neededCommodity.put("egg",10);
        taskOfLevel4.neededCommodity.put("turkey",5);
        taskOfLevel4.neededCommodity.put("chicken",5);
        taskOfLevel4.neededCommodity.put("bread",5);
        taskOfLevel4.neededCommodity.put("cow",5);
        taskOfLevel4.neededCommodity.put("milk",5);
        taskOfLevel4.neededCommodity.put("ice cream",5);
        taskOfLevel4.neededCommodity.put("wool",5);
        //level5
        taskOfLevel5=new Task1(5,150,200,1000,850,750);

        ArrayList<Integer>bearTimes5=new ArrayList<>();
        bearTimes5.add(5);
        bearTimes5.add(40);
        bearTimes5.add(60);
        bearTimes5.add(70);
        ArrayList<Integer>tigerTimes5=new ArrayList<>();
        tigerTimes5.add(35);
        tigerTimes5.add(90);
        ArrayList<Integer>lionTimes5=new ArrayList<>();
        lionTimes5.add(96);
        lionTimes5.add(105);
        lionTimes5.add(120);

        taskOfLevel4.animalsAppearing.put("bear",bearTimes5);
        taskOfLevel4.animalsAppearing.put("tiger",tigerTimes5);
        taskOfLevel4.animalsAppearing.put("lion",lionTimes5);


        taskOfLevel5.neededCommodity.put("egg",20);
        taskOfLevel5.neededCommodity.put("turkey",10);
        taskOfLevel5.neededCommodity.put("chicken",8);
        taskOfLevel5.neededCommodity.put("bread",5);
        taskOfLevel5.neededCommodity.put("cow",5);
        taskOfLevel5.neededCommodity.put("milk",5);
        taskOfLevel5.neededCommodity.put("ice cream",5);
        taskOfLevel5.neededCommodity.put("wool",5);
        taskOfLevel5.neededCommodity.put("flour",10);
        taskOfLevel5.neededCommodity.put("feather",10);



///////////////////////////////////////////////////////////////////////////////////









    }
    public void initializeUserLevelAndCoins(String userName)
    {
        Scanner scanner;
        File userFile=new File(userName+".txt");
        if(!userFile.exists())
        {
            try {
                userFile.createNewFile();
            } catch (IOException e) {
                LoggingToFile.logToFile("problem in creating "+userName+".txt (initializeUserLevelAndCoins)","severe");
                e.printStackTrace();
            }


        }



        try {
            scanner=new Scanner(userFile);
            FileReader fileReader=new FileReader(userFile);
            levelOfUser=scanner.nextInt();
            userInitialCoins=scanner.nextInt();

            System.out.println(userName+"  you are at level "+levelOfUser+" and you have "+userInitialCoins+" coins");




        } catch (FileNotFoundException e) {
            LoggingToFile.logToFile("can't find "+userName+".txt","severe");
            e.printStackTrace();
        }








    }
    public void startPlayingGame(String userName)
    {
        Scanner scanner=new Scanner(System.in);
        initializeUserLevelAndCoins(userName);
        initializeTasks();


        while(quitGame)
        {
            isGameRunning=true;
            int level=askingWhichLevelToPlay();
            if(level==0)
            {
                saveUserInfo(userName);
                return;

            }




            //start playing  Game  level 1
            else if(level==1) {

                System.out.println("*****************Enter your commands here*****************");
                String input;
                Regex regex = new Regex(taskOfLevel1);

                while (isGameRunning) {
                    input = scanner.nextLine();
                    regex.matcher(input);
                }
                continue;

            }
            //start playing  Game  level 2
            else if(level==2) {

                System.out.println("*****************Enter your commands here*****************");
                String input;
                Regex regex = new Regex(taskOfLevel2);
                while (isGameRunning) {
                    input = scanner.nextLine();
                    regex.matcher(input);
                }
              continue;
            }
            //start playing  Game  level 3
            else if(level==3) {

                System.out.println("*****************Enter your commands here*****************");
                String input;
                Regex regex = new Regex(taskOfLevel3);
                while (isGameRunning) {
                    input = scanner.nextLine();
                    regex.matcher(input);
                }
                continue;
            }
            //start playing  Game  level 4
            else if(level==4) {

                System.out.println("*****************Enter your commands here*****************");
                String input;
                Regex regex = new Regex(taskOfLevel4);
                while (isGameRunning) {
                    input = scanner.nextLine();
                    regex.matcher(input);
                }
               continue;
            }
            //start playing  Game  level 5
           else  if(level==5) {

                System.out.println("*****************Enter your commands here*****************");
                String input;
                Regex regex = new Regex(taskOfLevel5);
                while (isGameRunning) {
                    input = scanner.nextLine();
                    regex.matcher(input);
                }
                continue;
            }









        }








    }
    public int askingWhichLevelToPlay() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int level=0;
        while (flag) {
            System.out.println(ConsoleColors.BLUE + "Which level would you like to play ?  Enter number for level or type (0) to exit game" + ConsoleColors.RESET);
            level = scanner.nextInt();
            if (level > levelOfUser) {
                System.out.println(ConsoleColors.RED + "you cant play this level" + ConsoleColors.RESET);


            }
            if (level < 0) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (number out of range)" + ConsoleColors.RESET);
            }

          else{
                flag=false;
            }




        }
        return level;
    }

    public void saveUserInfo(String userName)
    {


        try {
            FileWriter fileWriter=new FileWriter(userName+".txt");
            fileWriter.write(levelOfUser);
            fileWriter.write("\\n");
            fileWriter.write(userInitialCoins);
        } catch (IOException e) {
            LoggingToFile.logToFile("problem in opening "+userName+".txt (saveUserInfo)","severe");
            e.printStackTrace();
        }


    }




}




