import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.text.Text;

public class ContarVocalesController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField pathOrigen;
    @FXML
    private Text numeroVecesVocales;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pathOrigen.setText("donQuijote.txt");
    }

    @FXML
    private void leerArchivoContar(ActionEvent event) throws IOException {

        FileInputStream fip;
        try {
            File f = new File(pathOrigen.getText());
            fip = new FileInputStream(f);
            int caracter = 0;
            String contenido = "";
            int contA=0;
            int contE=0;
            int contI=0;
            int contO=0;
            int contU=0;
            

            while ((caracter = fip.read()) != -1) {
                char c = (char) caracter;
                contenido += c;

                if (c == 'a') {
                    contA++;
                }
                if (c == 'e') {
                    contE++;
                }
                if (c == 'i') {
                    contI++;
                }
                if (c == 'o') {
                    contO++;
                }
                if (c == 'u') {
                    contU++;
                }
            }
            textArea.setText(contenido);
            numeroVecesVocales.setText("Numero de veces que aparaece la a:"+Integer.toString(contA)+" e:"+Integer.toString(contE)+" i:"+Integer.toString(contI)+" o:"+Integer.toString(contO)+" u:"+Integer.toString(contU));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContarVocalesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
