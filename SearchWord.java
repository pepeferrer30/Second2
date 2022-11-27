import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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

public class BuscarPalabrasController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField pathOrigen;
    @FXML
    private Text numeroVecesPalabra;
    @FXML
    private TextField palabraBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pathOrigen.setText("donQuijote.txt");
    }

    @FXML
    private void leerArchivoBuscar(ActionEvent event) throws IOException {

        FileReader fr = null;
        try {
            File f = new File(pathOrigen.getText());
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            String contenido = "";
            int coincidencias = 0;

            while ((linea = br.readLine()) != null) {
                contenido += linea;
                String[] palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    if (palabras[i].equalsIgnoreCase(palabraBuscar.getText())) {
                        coincidencias++;
                    }
                }
            }

            numeroVecesPalabra.setText("Numero de veces que aparece la palabra: " + Integer.toString(coincidencias));
            textArea.setText(contenido);

            String remp = "<<" + palabraBuscar.getText() + ">>";
            String editado = BuscarPalabrasController.abrirFichero(pathOrigen.getText()).replaceAll(palabraBuscar.getText(), remp);

            if (f.exists()) {

                File nuevo = new File(f.getParent()+"\\"+f.getName());
                f.delete();
                nuevo.createNewFile();  //comprobar
            }

            try {
                //f.createNewFile();
                FileOutputStream out = new FileOutputStream(f);
                byte[] arr = editado.getBytes();
                out.write(arr);
                out.close();

                textArea.setText(editado);
            } catch (IOException ex) {
                Logger.getLogger(LeerEscribirController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BuscarPalabrasController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(BuscarPalabrasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static String abrirFichero(String ruta) throws IOException {
        String contenido = "";

        File f = new File(ruta);
        try {
            FileInputStream fip = new FileInputStream(f);

            int caracter = 0;

            while ((caracter = fip.read()) != -1) {
                contenido += (char) caracter;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerEscribirController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contenido;
    }

}
