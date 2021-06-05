import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggingToFile {

    public  static FileHandler fileHandler;

    {
        try {
            fileHandler = new FileHandler("logger.log",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void logToFile(String message,String flag) {

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


    }




}
