
package clases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Programa extends JFrame{
    JMenu diseño;
    JMenuItem nuevo,guardar,cargar,blanco,negro,rojo,rosa,amarillo,otro;
    JMenuItem pblanco,pnegro,projo,prosa,pamarillo,potro;
    JRadioButton borrar,pintar;
    Container con;
    Hoja h;
    
    public Programa(){
        super("Programa Pintor");
        
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        con=this.getContentPane();
        
        JMenuBar barraPrincipal = new JMenuBar();
        setJMenuBar(barraPrincipal);
        
        Controlador c = new Controlador();
        JMenu archivo = new JMenu("Archivo");
        
        nuevo = new JMenuItem("Nuevo");
        nuevo.addActionListener(c);
        
        guardar = new JMenuItem("Guardar");
        guardar.setEnabled(false);
        guardar.addActionListener(c);
        
        cargar = new JMenuItem("Cargar");
        cargar.addActionListener(c);
        
        archivo.add(nuevo);
        archivo.add(guardar);
        archivo.add(cargar);
        
        
        diseño = new JMenu("Diseño");
        diseño.setEnabled(false);
        JMenu colores = new JMenu("Color de fondo");
        diseño.add(colores);
        
        blanco = new JMenuItem("Blanco"); 
        blanco.addActionListener(c);
        
        negro = new JMenuItem("Negro");
        negro.addActionListener(c);
        
        rojo = new JMenuItem("Rojo"); 
        rojo.addActionListener(c);
        
        rosa = new JMenuItem("Rosa"); 
        rosa.addActionListener(c);
        
        amarillo = new JMenuItem("Amarillo"); 
        amarillo.addActionListener(c);
        
        otro = new JMenuItem("Otro");
        otro.addActionListener(c);
        
        JMenu pincel = new JMenu("Color del pincel");
        diseño.add(pincel);
        
        pblanco=new JMenuItem("Blanco");
        pblanco.addActionListener(c);
        
        pnegro=new JMenuItem("Negro");
        pnegro.addActionListener(c);
        
        projo=new JMenuItem("Rojo");
        projo.addActionListener(c);
        
        prosa=new JMenuItem("Rosa");
        prosa.addActionListener(c);
        
        pamarillo=new JMenuItem("Amarillo");
        pamarillo.addActionListener(c);
        
        potro = new JMenuItem("Otro");
        potro.addActionListener(c);
        
        colores.add(blanco);
        colores.add(negro);
        colores.add(rojo);
        colores.add(rosa);
        colores.add(amarillo);
        colores.add(otro);
        
        pincel.add(pblanco);
        pincel.add(pnegro);
        pincel.add(projo);
        pincel.add(prosa);
        pincel.add(pamarillo);
        pincel.add(potro);
        
        ButtonGroup bg = new ButtonGroup();
        borrar=new JRadioButton("borrar");
        borrar.setEnabled(false);
        borrar.addActionListener(c);
        pintar=new JRadioButton("pintar");
        pintar.setEnabled(false);
        pintar.addActionListener(c);
        bg.add(borrar);
        bg.add(pintar);
        
        bg.setSelected(pintar.getModel(), true);
        
        barraPrincipal.add(archivo);
        barraPrincipal.add(diseño);
        barraPrincipal.add(borrar);
        barraPrincipal.add(pintar);
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    class Controlador implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==nuevo){
                
                h=new Hoja();
                con.add(h).setBounds(0,0,1400,700);
                con.repaint();
                diseño.setEnabled(true);
                guardar.setEnabled(true);
                pintar.setEnabled(true);
                borrar.setEnabled(true);
                
            }
            else if(e.getSource()==guardar){
                Estructura save = h.lp;
                Guarda g = new Guarda(save);
            }
            else if(e.getSource()==cargar){
                
                Carga ch = new Carga();
                
                if(ch.recuperado!=null){
                    h=new Hoja(ch.imagen());
                    h.cambiarFondo(h.lp.fondo);
                    h.repaint();
                    con.add(h).setBounds(0,0,1400,700);
                    guardar.setEnabled(true);
                    diseño.setEnabled(true);
                    pintar.setEnabled(true);
                    borrar.setEnabled(true);
                }
            }
            
            else if(e.getSource()==blanco){
                h.cambiarFondo(Color.WHITE);
            }else if(e.getSource()==negro){
                h.cambiarFondo(Color.BLACK);
            }else if(e.getSource()==rojo){
                h.cambiarFondo(Color.RED);
            }else if(e.getSource()==rosa){
                h.cambiarFondo(Color.PINK);
            }else if(e.getSource()==amarillo){
                h.cambiarFondo(Color.YELLOW);
            }else if(e.getSource()==otro){
                h.cambiarFondo(JColorChooser.showDialog(null, "Elige un color", Color.WHITE));
            }
            
            else if(e.getSource()==pblanco){
                h.cambiarColorDibujo(Color.WHITE);
            }else if(e.getSource()==pnegro){
                h.cambiarColorDibujo(Color.BLACK);
            }else if(e.getSource()==projo){
                h.cambiarColorDibujo(Color.RED);
            }else if(e.getSource()==prosa){
                h.cambiarColorDibujo(Color.PINK);
            }else if(e.getSource()==pamarillo){
                h.cambiarColorDibujo(Color.YELLOW);
            }else if(e.getSource()==potro){
                h.cambiarColorDibujo(JColorChooser.showDialog(null, "Elige un color", Color.BLACK));
            }
            else if(e.getSource()==borrar){
                h.cambiarModo();
            }else if(e.getSource()==pintar){
                h.cambiarModo();
            }
        }
                        
    }
    
}

