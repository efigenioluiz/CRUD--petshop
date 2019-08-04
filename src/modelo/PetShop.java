package modelo;

import com.sun.deploy.util.FXLoader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;

public class PetShop {
    public ObservableList<Animal> list;
    private static PetShop instance;

    public static PetShop getInstance(){
        if(instance == null){
            instance= new PetShop();
        }

        return instance;
    }


    public PetShop() {
        this.list = FXCollections.observableArrayList();
    }

    public ObservableList<Animal> getList() {
        return list;
    }


    public void gravarAnimal(){


        File f=null;
        FileOutputStream fos= null;
        ObjectOutputStream oos;

        f= new File("animais.bin");
        try{
            fos= new FileOutputStream(f);
            oos= new ObjectOutputStream(fos);

            for(Animal a: PetShop.getInstance().getList()){
                oos.writeObject(a);
            }


            oos.close();
            fos.close();

        } catch (IOException e){

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void lerAnimal(){
        File f=null;
        FileInputStream fis= null;
        ObjectInputStream ois= null;

        try{
            f= new File("animais.bin");
            fis= new FileInputStream(f);
            ois= new ObjectInputStream(fis);

            while (ois.read() != f.length()){
                Animal animal= (Animal) ois.readObject();
                list.add(animal);
            }


        }catch (IOException i){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void remover(Animal animal){
        list.remove(animal);
    }
    public void mudaJanela(AnchorPane TELA, String url){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FXMLLoader loader= new FXMLLoader();
                loader.setLocation(getClass().getResource(url));

                try{
                    Parent layoutJanela= loader.load();
                    Stage stage= (Stage) TELA.getScene().getWindow();

                    stage.setScene(new Scene(layoutJanela,600,400));
                    stage.setResizable(false);


                }catch (Exception e){

                }
            }
        });
    }
}
