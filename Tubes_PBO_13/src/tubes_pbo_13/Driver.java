package tubes_pbo_13;

import Controller.ControllerMenuUtama;
import Model.Aplikasi;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class Driver implements Serializable{
    public static void main(String[] args){

        Aplikasi aplikasi = new Aplikasi();
        new ControllerMenuUtama(aplikasi);
        
//        Console console = new Console();
//        console.mainMenu(args);
    }
}
        