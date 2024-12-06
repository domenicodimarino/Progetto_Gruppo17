package it.unisa.softeng.rubricagrp17.controllers;

import it.unisa.softeng.rubricagrp17.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class RubricaPrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
