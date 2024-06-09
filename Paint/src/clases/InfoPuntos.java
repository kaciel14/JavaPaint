
package clases;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;


public class InfoPuntos implements Serializable{
    private static final long serialVersionUID = 1L;
    Color pincel;
    boolean dibujar,borrado;
    Point cc;
    
    
    public InfoPuntos(Point p, boolean b, Color c, boolean e){
        cc=p;
        dibujar=b;
        pincel=c;
        borrado=e;
    }

    
}

