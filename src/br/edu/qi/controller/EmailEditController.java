/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.email.ArquivoModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class EmailEditController implements Initializable {
    
    @FXML
    private TextField txtHostServer;
    @FXML
    private TextField txtPara;
    @FXML
    private TextField txtDe;
    @FXML
    private TextField txtAssunto;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextArea txtConteudoMensagem;
    @FXML
    private Button btoEnviar;
    @FXML
    private Label lblHostServer;
    @FXML
    private Label lblPara;
    @FXML
    private Label lblDe;
    @FXML
    private Label lblAssunto;
    @FXML
    private Label lblUserName; 
    @FXML
    private Label lblSenha;
    @FXML
    private Text mensagem;
       
    @FXML
    private Parent consulta;
    
    @FXML
    private Parent formulario;
    
    private ArquivoModel arquivoModel;
    
    //tabela de arquivos anexados
    TableView<ArquivoModel> tabela;
	
	//lista de arquivos exibidos pela tabela
    ObservableList<ArquivoModel> listAnexos;
    
    @FXML
    private TableColumn colunaNome;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }
    
    private void trocar(boolean form) {
        formulario.setVisible(form);
        consulta.setVisible(!form);
    }

 @FXML
    private void novo() {
        
        txtHostServer.setText("smtp.gmail.com");
        txtPara.setText("");
        txtDe.setText("");
        txtAssunto.setText("");
        txtUsername.setText("");
        txtSenha.setText("");
        trocar(true);
    }
    
    @FXML
    private void enviar(){}

    @FXML
    private void cancelar(){}

    private void selecionarItemTvEmail(ArquivoModel newValue) {
       
    }
    
    
    
    
}
