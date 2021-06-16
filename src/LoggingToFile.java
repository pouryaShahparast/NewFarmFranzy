import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingToFile {

    public  static FileHandler fileHandler;
    private  static int flag1=0;


    public static void logToFile(String message,String flag) {
        if(flag1<=5)
               flag1++;

        if(flag1==1)
        {
            try {

                fileHandler = new FileHandler("logger.txt",true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);

        Logger logger = Logger.getLogger("gamelogger");
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
        if(flag.equalsIgnoreCase("info"))
        {
            logger.info(message);
        }
         if(flag.equalsIgnoreCase("warning"))
         {

             logger.warning(message);

         }
         if(flag.equalsIgnoreCase("config"))
         {
             logger.config(message);
         }
        if(flag.equalsIgnoreCase("severe"))
        {
            logger.severe(message);
        }

        else
        {
          logger.warning(message);
        }


    }




}
