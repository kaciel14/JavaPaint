
package clases;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;


public class ListaPuntos implements Serializable{
    Point[] cc = new Point[100000];
    boolean[] pintar = new boolean[100000];
    int counter;
    Color fondo;
    Color[] pincel=new Color[100000];
    
    public ListaPuntos(Color back){
        this.fondo=back;
    }
    
    public void add(Point p, int contador,boolean b,Color c){
        this.counter=contador;
        cc[counter] = p;
        pintar[counter] = b;
        pincel[counter]=c;
    }
    public int length(){
        return cc.length;
    }
    public String toString(){
        return ("CC:"+cc+"\tPintar:"+pintar)+"Contador:"+counter+"Color Fondo:"+fondo;
    }
    public void setColorFondo(Color c){
        this.fondo=c;
    }

}
