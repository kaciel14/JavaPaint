
package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Carga {
    ObjectInputStream stream;
    Estructura recuperado;
    
    public Carga(){
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.dat","dat");
        JFileChooser sel = new JFileChooser();
        sel.setCurrentDirectory(new File("."));
        sel.setFileFilter(filter);
        sel.setDialogTitle("Seleccione archivo para cargar");
        sel.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if(sel.showOpenDialog(null)==JFileChooser.APPROVE_OPTION);
            File f = sel.getSelectedFile();
  
        try {
            if(f!=null){
                stream = new ObjectInputStream(new FileInputStream(f));
                recuperado = (Estructura)stream.readObject();
                stream.close();
            }

        } catch (Exception ex) {
        }
    }
    public Estructura imagen(){
        return recuperado;
    }
}
