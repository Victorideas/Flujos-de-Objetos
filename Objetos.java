/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Objetos {
    FileOutputStream fout=null;
    ObjectOutputStream out = null;
    FileInputStream fin=null;
    ObjectInputStream in = null;
    
    public void crearPersona(){
        Persona p1 = new Persona("Carlos", 35, 180);
        Persona p2 = new Persona("Miguel", 42, 165);
        Persona p3 = new Persona("Juan", 26, 175);
         try {
                fout = new FileOutputStream("C:\\Users\\Victor\\Desktop\\PersonasObject.dat", true);
                out = new ObjectOutputStream(fout);
                out.writeObject(p1);
                out.writeObject(p2);
                out.writeObject(p3);   
                
                fout.close();
            } catch (Exception e) {
                System.out.println("No se pudo guardar las personas");
            }
    }
    public void leerPersona(){
        try {
            fin = new FileInputStream("C:\\Users\\Victor\\Desktop\\PersonasObject.dat");
            in = new ObjectInputStream(fin);
            
            Persona persona1 = (Persona) in.readObject();	
            Persona persona2 = (Persona) in.readObject();
            Persona persona3 = (Persona) in.readObject();
			
            persona1.mostrarPersona();
            persona2.mostrarPersona();
            persona3.mostrarPersona();
            
            in.close();
            fin.close();
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Objetos obj = new Objetos();
        obj.crearPersona();
        obj.leerPersona();
    }
    
}
