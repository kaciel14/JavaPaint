
package clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Guarda{
    ObjectOutputStream stream;
    
    public Guarda(Estructura l){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.dat","dat");
        JFileChooser sel = new JFileChooser();
        sel.setCurrentDirectory(new File("."));
        sel.setFileFilter(filter);
        sel.setDialogTitle("Seleccione carpeta para guardar");
        sel.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        if(sel.showSaveDialog(null)==JFileChooser.APPROVE_OPTION);
            File f = sel.getSelectedFile();
        
        try{
            if(f!=null){
                stream=new ObjectOutputStream(new FileOutputStream(f));
                stream.writeObject(l);
                stream.close();
            }
            

        }catch(Exception ex){
        }
    }
}
