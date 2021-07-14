package GUI;
import ETC.Task1;
import inGamGraphics.Program;


public class Game {


    public static Task1 task;
    public Game(Task1 task1) {
      task=task1;
        Program program=new Program(1000,700,GUIEntrance.jFrame);
        program.start();
//        while (program.getThread().isAlive())
//        {
//
//        }

    }







}
