package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

import java.awt.*;

public class Controller {

public TextField TextField_1;
public TextField TextField_2;
public TextField TextField_3;
public TextField TextField_4;

public RadioButton Radio_Instate;
public RadioButton Radio_Outstate;
public RadioButton Radio_International;

public Button ADD;
public Button REMOVE;
public Button PRINT;

public CheckBox FUNDING;
public CheckBox TRISTATE;
public CheckBox EXCHANGE_STUDENT;


public TextArea OUTPUT;


public void handleButtonClick(){
    OUTPUT.setText(TextField_1.getText() + " " + TextField_2.getText() + " " + TextField_3.getText()); 
}
  
  
