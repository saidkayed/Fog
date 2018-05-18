/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author tobbe
 */
public class OurLogger {

    private static Logger logger;
    private static FileHandler fh = null;

    public static void init() throws IOException {        
        try {
            fh = new FileHandler("/Users/sidad/Desktop/log.txt", true); // sidste parameter appende til eksisterende. 
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        Logger l = Logger.getLogger(OurLogger.class.getName());
        fh.setFormatter(new SimpleFormatter());
        l.addHandler(fh);
        l.setLevel(Level.CONFIG);

    }
    
    }
    

