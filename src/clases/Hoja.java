
package clases;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Hoja extends JPanel{
    
    Color colFondo=Color.WHITE, colLineas=Color.BLACK;
    ImageIcon ii=new ImageIcon("./src/iconos/eraser.png");
    Toolkit t =Toolkit.getDefaultToolkit();
    Controlador ctr = new Controlador();
    Estructura lp ;
    boolean modo=true;
    Cursor c;

    public Hoja(){
        this.setBackground(colFondo);
        lp= new Estructura(colFondo);
        
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        
        this.addMouseMotionListener(ctr);
        this.setVisible(true);
    }
    
    public Hoja(Estructura l){
        this.lp=l;
        this.setBackground(Color.WHITE);
        
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        
        this.addMouseMotionListener(ctr);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        super.paint(g2);
        
        for(int i=1;i<lp.info.size()&&lp.info!=null;i++){
            if(lp.info.get(i).dibujar==true&&lp.info.get(i).borrado==false){
                g2.setColor(lp.info.get(i).pincel);
                g2.setStroke(new BasicStroke(5));
                g2.drawLine(lp.info.get(i).cc.x, lp.info.get(i).cc.y, lp.info.get(i-1).cc.x, lp.info.get(i-1).cc.y);
            }else if(lp.info.get(i).borrado==true){
                g2.setColor(colFondo);
                g2.setStroke(new BasicStroke(20));
                g2.drawLine(lp.info.get(i).cc.x, lp.info.get(i).cc.y, lp.info.get(i-1).cc.x, lp.info.get(i-1).cc.y);
            }
        }
 
    }
    
    public void cambiarFondo(Color c){
        colFondo=c;
        setBackground(colFondo);
        lp.setColorFondo(c);
    }
    
    public void cambiarColorDibujo(Color c){
        colLineas=c;
    }
    
    public void cambiarModo(){
        if(modo){
            c=t.createCustomCursor(ii.getImage(), new Point(0,0), "borrador");
            this.setCursor(c);
            modo=false;
        }else{
            modo=true;
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
    
    private class Controlador implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            if(modo){
                    lp.add(e.getPoint(), true,colLineas,false);
                    repaint();
                }else{
                    lp.add(e.getPoint(), true, colLineas,true);
                    repaint();
                }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
             lp.add(e.getPoint(), false,colLineas,false);
        } 
    }
    
}
