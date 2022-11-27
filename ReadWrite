import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LeerEscribirController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField pathOrigen;
    @FXML
    private TextField pathDestino;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void leerArchivo(ActionEvent event) throws IOException {
        File f = new File(pathOrigen.getText());
        try {
            FileInputStream fip = new FileInputStream(f);
            
            int caracter=0;
            String contenido="";
            
            while((caracter=fip.read())!=-1){
                contenido+=(char) caracter;
            }
            
            textArea.setText(contenido);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerEscribirController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void escribirArchivo(ActionEvent event) {
        String contenido=textArea.getText();
        File f = new File(pathDestino.getText());
        
        try {
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            byte[] arr = contenido.getBytes();
            out.write(arr);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(LeerEscribirController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
