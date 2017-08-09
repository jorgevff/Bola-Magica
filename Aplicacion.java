import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import java.util.ArrayList;
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

    private Label mensaje;

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

        //configurando mensaje
        mensaje = new Label("Haz click para mostrar tu fortuna");
        mensaje.setLayoutX(LADO_VENTANA/2);
        mensaje.setLayoutY(LADO_VENTANA/2);
        escenario.getChildren().add(mensaje);

        //cofigurando evento de raton
        escena.setOnMouseClicked((MouseEvent evento) -> {
            //obtenemos posicion del raton
                double posicionXRaton = evento.getX();
                double posicionYRaton = evento.getY();
            //fijamos la posicion del mensaje a la posicion del raton que obtuvimos antes
                mensaje.setLayoutX(posicionXRaton);
                mensaje.setLayoutY(posicionYRaton);
            //invocamos el metodo que modificara el mensaje
                modificarMensaje();

            });
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
    
    private void modificarMensaje(){
        ArrayList<String> frases = new ArrayList<>();
        
        String mensaje1 = "Te va a tocar el gordo";
        String mensaje2 = "Te vas a encontrar dinero";
        String mensaje3 = "Nanai";
        String mensaje4 = "Te va a pillar un bus";
        
        frases.add(mensaje1);
        frases.add(mensaje2);
        frases.add(mensaje3);
        frases.add(mensaje4);
        
        Random aleatorio = new Random();
        //Obtenemos un numero aleatorio entre 0 y el numero indicado
        //en este caso la cantidad de elementos dentro de la coleccion
        int numeroAleatorio = aleatorio.nextInt(frases.size());
        
        //Obtenemos un elemento de la coleccion mediante el numero aleatorio
        String mensajeFijado = frases.get(numeroAleatorio);
        
        mensaje.setText(mensajeFijado); 
    }

}
