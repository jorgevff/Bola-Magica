import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/**

 */
public class Aplicacion extends Application
{
    // instance variables - replace the example below with your own
    private static final float LADO_VENTANA = 800;
    private static final ImageView CONTENEDOR_FONDO = new ImageView();
    private Image icono;
    
    private static final String RUTA_ICONO = "icono.png";
    private static final String TITULO_VENTANA = "Mi Bola";
    private static final String RUTA_FONDO = "fondo.png";
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        //inicializando la escena y el escenario y pasandoselo a la aplicacion
        Pane escenario = new Pane();
        Scene escena = new Scene(escenario, LADO_VENTANA, LADO_VENTANA);
        primaryStage.setScene(escena);
        escenario.getChildren().add(CONTENEDOR_FONDO);
        
        //configurando la apariencia de la ventana
        primaryStage.setTitle(TITULO_VENTANA);
        primaryStage.setResizable(false);
        
        //inicializando elementos multimedia
        try{
            Image fondo = new Image(RUTA_FONDO);
            CONTENEDOR_FONDO.setImage(fondo);
            icono = new Image(RUTA_ICONO);
            //fijando el icono de la ventana
            primaryStage.getIcons().add(icono);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        primaryStage.show();
    }
  
}
