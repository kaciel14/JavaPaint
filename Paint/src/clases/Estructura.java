
package clases;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;


public class Estructura implements Serializable{
    Color fondo;
    ArrayList<InfoPuntos> info;
    
    public Estructura(Color back){
        info=new ArrayList<>();
        fondo=back;

    }
    
    public void add(Point p, boolean b, Color c,boolean e){
            info.add(new InfoPuntos(p,b,c,e));
        
    }
    
    
    public void setColorFondo(Color c){
        fondo=c;

    }
}