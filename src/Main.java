import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Animal;
import modelo.PetShop;

import java.io.*;
import java.util.Scanner;

public class Main extends Application {

//    public static ObservableList<Animal> animals= FXCollections.observableArrayList();

    public void init(){
        System.out.println("entrou no int");
        PetShop.getInstance().lerAnimal();

    }
    public void stop(){
        System.out.println("entrou no stop");
        PetShop.getInstance().gravarAnimal();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/janelaPainel.fxml"));
        primaryStage.setTitle("Pet Shop");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
            launch(args);

    }
}