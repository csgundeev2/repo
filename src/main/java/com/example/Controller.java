package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private TextField txtName;

    @FXML
    void onButtonClick(ActionEvent event) {
        String name = txtName.getText();
        Alert alert = new Alert(AlertType.INFORMATION, "Сайн байна уу? " + name);
        alert.showAndWait();
    }

}
