package lecture02;

import java.io.IOException;
import java.util.logging.*;

public class Ex005_Logger {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Ex005_Logger.class.getName());

        // Тип Handler.
        // ConsoleHandler
//        ConsoleHandler ch = new ConsoleHandler();
//        logger.addHandler(ch);
        // FileHandler
        FileHandler fh = new FileHandler("src/lecture02/log.xml");
        logger.addHandler(fh);

        // Format message.
        // Simple
//        SimpleFormatter sFormat = new SimpleFormatter();
//        ch.setFormatter(sFormat);
        // XML-format for Console
//        XMLFormatter xml = new XMLFormatter();
//        ch.setFormatter(xml);
        // XML-format for File
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        //Messages.
        //logger.setLevel((Level.INFO));
        logger.log(Level.WARNING, "Тестовое логгирование 1");
        logger.info("Тестовое логгирование 2");
    }
}
