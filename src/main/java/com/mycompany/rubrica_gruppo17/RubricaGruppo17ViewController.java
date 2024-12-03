package com.mycompany.rubrica_gruppo17;

import java.io.IOException;
import javafx.fxml.FXML;

public class RubricaGruppo17ViewController {

    @FXML
    private void switchToSecondary() throws IOException {
        RubricaGruppo17.setRoot("secondary");
    }
}
