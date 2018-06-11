import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        AbstractFactory Background_Factory = FactoryProducer.getFactory("Back");
        //get an object of Shape Circle
        Background p = Background_Factory.getBackground("pic1");
        //call draw method of Shape Circle
        p.Back();


        
        
    }
}
