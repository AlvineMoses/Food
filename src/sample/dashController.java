package sample;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.FXMLDocumentController;

import java.io.IOException;

/**
 *
 * @author Alvins
 */
public class dashController {

    @FXML
    private JFXButton logout;

    public void logout(MouseEvent mouseEvent) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("resources/view/Main.fxml"));

        logout.getScene().getWindow().hide();
        Scene scene = new Scene(root);

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

