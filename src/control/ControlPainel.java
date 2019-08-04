package control;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.Animal;
import modelo.PetShop;

public class ControlPainel {
    
    public TextField tfNome,tfRaca;
    public ListView<Animal> lvLista;
    public AnchorPane TELA;


    public void initialize(){
       att();
    }

    public void adicionar(ActionEvent actionEvent) {
        Animal animal= new Animal(tfNome.getText(),tfRaca.getText());
        PetShop.getInstance().getList().add(animal);
        att();
        tfNome.setText("");
        tfRaca.setText("");
        menssagem(Alert.AlertType.CONFIRMATION,"Adicionado com Sucesso!");

    }
    public void att(){
        // lvLista.setItems(FXCollections.observableArrayList(PetShop.getInstance().list));
        lvLista.getItems().clear();
        lvLista.getItems().addAll(PetShop.getInstance().list);
    }

    public void remover(ActionEvent actionEvent) {
        if(lvLista.getSelectionModel().getSelectedItem() != null){
            PetShop.getInstance().remover(lvLista.getSelectionModel().getSelectedItem());
            att();
            menssagem(Alert.AlertType.CONFIRMATION,"Removido com Sucesso!");
        }else{
            menssagem(Alert.AlertType.ERROR,"Animal não selecionado!");
        }
    }

    public void menssagem(Alert.AlertType alertType, String msg){
        Alert alert= new Alert(alertType,msg);
        alert.show();
    }

    public void Sair() {
        PetShop.getInstance().mudaJanela(TELA,"../view/janelaLogin.fxml");
    }
}
