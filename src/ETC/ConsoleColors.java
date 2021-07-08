package ETC;

import controller.Entrance;

public class ConsoleColors {


    public static  final String  RESET="\033[0m";
    public static  final String  BLACK = "\033[0;30m";
    public static  final String  RED ="\033[0;31m";
    public static  final String  BLUE="\033[0;34m";
    public static  final String  CYAN_="\033[4;36m";
    public static  final String  GREEN="\033[0;32m";
    public static  final String  YELLOW="\033[0;33m";

    public static void main(String[] args) {
        Entrance entrance=new Entrance();
        entrance.menu();
    }



}
