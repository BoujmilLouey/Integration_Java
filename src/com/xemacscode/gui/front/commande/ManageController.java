package com.xemacscode.gui.front.commande;


import com.xemacscode.entities.Commande;
import com.xemacscode.gui.front.MainWindowController;
import com.xemacscode.services.CommandeService;
import com.xemacscode.utils.AlertUtils;
import com.xemacscode.utils.Constants;
import com.xemacscode.utils.RelationObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageController implements Initializable {

    @FXML
    public DatePicker dateCommandeDP;
    @FXML
    public TextField montantCommandeTF;
    @FXML
    public ComboBox<RelationObject> userCB;
    @FXML
    public Button btnAjout;
    @FXML
    public Text topText;

    Commande currentCommande;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (RelationObject user : CommandeService.getInstance().getAllUsers()) {
            userCB.getItems().add(user);
        }

        currentCommande = ShowAllController.currentCommande;

        if (currentCommande != null) {
            topText.setText("Modifier commande");
            btnAjout.setText("Modifier");

            try {
                dateCommandeDP.setValue(currentCommande.getDateCommande());
                montantCommandeTF.setText(String.valueOf(currentCommande.getMontantCommande()));
                userCB.setValue(currentCommande.getUserId());

            } catch (NullPointerException ignored) {
                System.out.println("NullPointerException");
            }
        } else {
            topText.setText("Ajouter commande");
            btnAjout.setText("Ajouter");
        }
    }

    @FXML
    private void manage(ActionEvent event) {

        if (controleDeSaisie()) {

            Commande commande = new Commande(
                    dateCommandeDP.getValue(),
                    Float.parseFloat(montantCommandeTF.getText()),
                    userCB.getValue()
            );

            if (currentCommande == null) {
                if (CommandeService.getInstance().add(commande)) {
                    AlertUtils.makeSuccessNotification("Commande ajout?? avec succ??s");
                    MainWindowController.getInstance().loadInterface(Constants.FXML_FRONT_DISPLAY_ALL_COMMANDE);
                } else {
                    AlertUtils.makeError("commande existe deja");
                }
            } else {
                commande.setId(currentCommande.getId());
                if (CommandeService.getInstance().edit(commande)) {
                    AlertUtils.makeSuccessNotification("Commande modifi?? avec succ??s");
                    ShowAllController.currentCommande = null;
                    MainWindowController.getInstance().loadInterface(Constants.FXML_FRONT_DISPLAY_ALL_COMMANDE);
                } else {
                    AlertUtils.makeError("commande existe deja");
                }
            }

        }
    }


    private boolean controleDeSaisie() {


        if (dateCommandeDP.getValue() == null) {
            AlertUtils.makeInformation("Choisir une date pour dateCommande");
            return false;
        }


        if (montantCommandeTF.getText().isEmpty()) {
            AlertUtils.makeInformation("montantCommande ne doit pas etre vide");
            return false;
        }


        try {
            Float.parseFloat(montantCommandeTF.getText());
        } catch (NumberFormatException ignored) {
            AlertUtils.makeInformation("montantCommande doit etre un r??el");
            return false;
        }
        if (userCB.getValue() == null) {
            AlertUtils.makeInformation("Choisir user");
            return false;
        }


        return true;
    }
}