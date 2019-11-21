/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtabla;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnInsertar;
    @FXML
    private Button btnModificar;
    @FXML 
    private TextField tNombre;
    @FXML 
    private TextField tApodo;
    @FXML 
    private TextField tPoder;
    @FXML 
    private TextField tEdad;
    @FXML 
    private TableView table;
    @FXML
    private TableColumn cNombre;
    @FXML
    private TableColumn cApodo;
    @FXML
    private TableColumn cPoder;
    @FXML
    private TableColumn cEdad;
    private Stage stage;
     public void setStage(Stage stage) {
        this.stage = stage;
    }
     public void initStage(Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("App");
        cNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        cApodo.setCellValueFactory(new PropertyValueFactory<>("Apodo"));
        cPoder.setCellValueFactory(new PropertyValueFactory<>("Poder"));
        cEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        ObservableList<EsperBean> espersData=FXCollections.observableArrayList(new ManagerFalso().getEspers());
        table.setItems(espersData);
       // table.getSelectionModel().selectedItemProperty().addListener(this::handlerEsperSelectionChanged);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /*
    #onActionInsertar" prefHeight="25.0" prefWidth="67.0" text="Insertar" />
            <Button layoutX="817.0" layoutY="392.0" mnemonicParsing="false" onAction="#onActionBorrar" prefHeight="25.0" prefWidth="67.0" text="Borrar" />
            <Button layoutX="817.0" layoutY="456.0" mnemonicParsing="false" onAction="#onActionModificar"
    */
    @FXML
    public void onActionInsertar(){
        EsperBean esper=new EsperBean(tNombre.getText().trim(),tApodo.getText().trim(),tPoder.getText().trim(),Integer.parseInt(tEdad.getText().trim()));
        table.getItems().add(esper);
        tNombre.setText("");
        tApodo.setText("");
        tPoder.setText("");
        tEdad.setText("");
    }
    @FXML
    public void onActionBorrar(){
        Alert alert=null;
        
            //Get selected user data from table view model
            EsperBean selectedEsper=((EsperBean)table.getSelectionModel()
                                                        .getSelectedItem());
            //Ask user for confirmation on delete
            /*
            alert=new Alert(Alert.AlertType.CONFIRMATION,
                                    "¿Borrar la fila seleccionada?\n"
                                    + "Esta operación no se puede deshacer.",
                                    ButtonType.OK,ButtonType.CANCEL);
            alert.getDialogPane().getStylesheets().add(
                    getClass().getResource("/javafxapplicationud3example/ui/view/customCascadeStyleSheet.css").toExternalForm());
            Optional<ButtonType> result = alert.showAndWait();
            */
            //If OK to deletion
          //ddd  //if (result.isPresent() && result.get() == ButtonType.OK) {
                //delete user from server side
               //      this.usersManager.deleteUser(selectedUser);
                //removes selected item from table
                table.getItems().remove(selectedEsper);
                table.getSelectionModel().clearSelection();
                table.refresh();
                //clears editing fields
                tNombre.setText("");
                tApodo.setText("");
                tPoder.setText("");
                tEdad.setText("");
                //cbDepartamentos.getSelectionModel().clearSelection();
             //   tgPerfil.selectToggle(rbUsuario);
             //   btCrear.setDisable(true);
             //   btModificar.setDisable(true);
                //Clear selection and refresh table view 
            //    tbUsers.getSelectionModel().clearSelection();
            //    tbUsers.refresh();
          //ddd     // }
        
    }
    @FXML
    public void onActionModificar(){
        EsperBean selectedEsper=((EsperBean)table.getSelectionModel()
                                                        .getSelectedItem());
        
        EsperBean esper=new EsperBean(tNombre.getText().trim(),tApodo.getText().trim(),tPoder.getText().trim(),Integer.parseInt(tEdad.getText().trim()));
        selectedEsper.setNombre(tNombre.getText().trim());
        selectedEsper.setApodo(tApodo.getText().trim());
        selectedEsper.setPoder(tPoder.getText().trim());
        selectedEsper.setEdad(Integer.parseInt(tEdad.getText().trim()));
        tNombre.setText("");
        tApodo.setText("");
        tPoder.setText("");
        tEdad.setText("");
        table.getSelectionModel().clearSelection();
        table.refresh();
    
    }
    public void handlerEsperSelectionChanged(ObservableValue observable,Object oldValue,Object newValue){
        if(newValue!=null){
            EsperBean esper=(EsperBean)newValue;
            tNombre.setText(esper.getNombre());
            tApodo.setText(esper.getApodo());
            tPoder.setText(esper.getPoder());
            tEdad.setText(String.valueOf(esper.getEdad()));
            btnBorrar.setDisable(false);
            btnInsertar.setDisable(false);
            btnModificar.setDisable(false);
        }
    }
}
