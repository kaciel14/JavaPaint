
package clases;

import javax.swing.SwingUtilities;


public class Principal {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                Programa p = new Programa();
            }
        });
    }
    
}
