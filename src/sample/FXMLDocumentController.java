package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sample.Helpers.DBConnector;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * @author JISOO
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane layersignup;
    @FXML
    private AnchorPane layer2;
    @FXML
    private AnchorPane layer3;
    @FXML
    private JFXButton signin;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private JFXButton signup;
    @FXML
    private Label a2;
    @FXML
    private Label b2;
    @FXML
    private Label a1;
    @FXML
    private Label b1;
    @FXML
    private JFXButton btnsignup;
    @FXML
    private JFXButton btnsignin;
    @FXML
    private TextField u1;
    @FXML
    private TextField u2;
    @FXML
    private TextField u3;
    @FXML
    private TextField n1;
    @FXML
    private TextField n2;
    @FXML
    private Label n3;
    @FXML
    private AnchorPane layer1;
    @FXML
    private Label l31;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        signup.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        btnsignin.setVisible(false);
        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
        l31.setVisible(true);
        u1.setVisible(true);
        u2.setVisible(true);
        u3.setVisible(true);
        layer3.setVisible(false);
    }

    @FXML
    private void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(491);
        slide.play();

        ParallelTransition parallelTransition = new ParallelTransition();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.7), layer1);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(1.0);
        fadeOut.play();


        ParallelTransition parallelTransition2 = new ParallelTransition();
        FadeTransition fadeOut2 = new FadeTransition(Duration.seconds(0.7), layer2);
        fadeOut2.setFromValue(0.5);
        fadeOut2.setToValue(1.0);
        fadeOut2.play();


        layer1.setTranslateX(-309);
        btnsignin.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true);

        s1.setVisible(true);
        s2.setVisible(true);
        s3.setVisible(true);
        signup.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        signin.setVisible(false);
        a1.setVisible(false);
        a2.setVisible(false);
        btnsignup.setVisible(false);
        n1.setVisible(true);
        n2.setVisible(true);
        n3.setVisible(true);
        l31.setVisible(false);
        u1.setVisible(false);
        u2.setVisible(false);
        u3.setVisible(false);
        layer3.setVisible(false);

        slide.setOnFinished((e -> {


        }));
    }

    @FXML
    private void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(0);
        btnsignin.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        signup.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        signin.setVisible(true);
        a1.setVisible(true);
        a2.setVisible(true);
        btnsignup.setVisible(true);
        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
        l31.setVisible(true);
        u1.setVisible(true);
        u2.setVisible(true);
        u3.setVisible(true);
        layer3.setVisible(false);

        slide.setOnFinished((e -> {


        }));
    }

    @FXML
    private void btnsignup(MouseEvent event) throws SQLException {
        Connection connection = DBConnector.getInstance().getConnection();
        String username = u1.getText();
        String email = u2.getText();
        String password = u3.getText();

        try {
            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("insert into Users (users, email, password)" +
                    "values ('" + username + "','" + email + "','" + password + "' )");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("User registered");
    }

    @FXML
    private void sign(MouseEvent event) throws SQLException {
        String username, password;

        username = n1.getText();
        password = n2.getText();

        Connection connection = DBConnector.getInstance().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users where users = '" + username + "' " +
                "+ password = '" + password + "'");

    }

    @FXML
    private void click(ActionEvent event) throws IOException {
        if ("Alvin".equals(n1.getText()) && "OOP".equals(n2.getText())) {
            String tilte = "Sign In";
            String message = n1.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));


            btnsignin.getScene().getWindow().hide();
            Stage primaryStage = new stage();
            Parent root = FXMLLoader.load(getClass().getResource("resources/view/dash.fxml"));

            Scene scene = new Scene(root);

            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();


        }
        if (!"Alvin".equals(n1.getText())) {
            String tilte = "Sign In";
            String message = "Error Username " + "'" + n1.getText() + "'" + " Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
        if (!"OOP".equals(n2.getText())) {
            String tilte = "Sign In";
            String message = "Error Password " + "'" + n2.getText() + "'" + " Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
        if (!"Alvin".equals(n1.getText()) && !"OOP".equals(n2.getText())) {
            String tilte = "Sign In";
            String message = "Error Username " + "'" + n1.getText() + "'" + ", and Password " + "'" + n2.getText() + "'" + " Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }


    @FXML
    private void btnsignin(MouseEvent event) {

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(491);
        slide.play();

        ParallelTransition parallelTransition = new ParallelTransition();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.7), layer3);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.play();

    }

    private static class stage extends Stage {

        public stage() {
        }
    }
}

