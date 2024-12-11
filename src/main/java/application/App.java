package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Carga el archivo FXML desde el classpath
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProyectoEsteganografia.fxml"));
        VBox pane = fxmlLoader.load();
        Scene scene = new Scene(pane);

        // Configura la ventana
        stage.setTitle("GUI deL proyecto de esteganografía UEM grupo 4");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
