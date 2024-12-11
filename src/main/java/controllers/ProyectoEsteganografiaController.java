package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ProyectoEsteganografiaController {

    @FXML
    private void cargarImagen() {
        showAlert("Cargar Imagen", "Función no implementada aún.");
    }

    @FXML
    private void cargarArchivo() {
        showAlert("Cargar Archivo", "Función no implementada aún.");
    }

    @FXML
    private void ocultarMensaje() {
        showAlert("Ocultar Mensaje", "Función no implementada aún.");
    }

    @FXML
    private void extraerMensaje() {
        showAlert("Extraer Mensaje", "Función no implementada aún.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
