import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcController {

    double firstNumber, secondNumber, result;
    int operation, firstNumberInt, secondNumberInt;
    String firstNumberText, secondNumberText, resultText, changePositiveNegativeText = "";
    boolean nextNumber = false, negativeFirstNumber = false, negativeSecondNumber = false;

    @FXML
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, 
    btn_backspace, btn_division, btn_result, btn_clear, btn_multiplication, btn_dot, btn_percent,
    btn_positive_negative, btn_addition, btn_subtraction;
   
    @FXML
    private TextField txt_field_display, txt_conta_extenso;

    @FXML
    void clickResult(ActionEvent event) {
        if(negativeFirstNumber == false && negativeSecondNumber == false){
            firstNumber = Double.parseDouble(firstNumberText);
            secondNumber = Double.parseDouble(secondNumberText);
            
        }else if(negativeFirstNumber == false && negativeSecondNumber == true){
            firstNumber = Double.parseDouble(firstNumberText);
            secondNumber = Double.parseDouble(secondNumberText);
            secondNumber = (secondNumber - (secondNumber * 2));
            
        }else if(negativeFirstNumber == true && negativeSecondNumber == false){
            firstNumber = Double.parseDouble(firstNumberText);
            firstNumber = (firstNumber - (firstNumber * 2));
            secondNumber = Double.parseDouble(secondNumberText);
            
        }else{
            firstNumber = Double.parseDouble(firstNumberText);
            firstNumber = (firstNumber - (firstNumber * 2));
            secondNumber = Double.parseDouble(secondNumberText);
            secondNumber = (secondNumber - (secondNumber * 2));
            
        }

        switch(operation){
            case 1:
            result = (firstNumber + secondNumber);
            resultText = Double.toString(result);
            txt_field_display.setText(resultText);
            txt_conta_extenso.setText(firstNumberText + " + " + secondNumberText + " = " + resultText);
            break;
            
            case 2:
            result = (firstNumber - secondNumber);
            resultText = Double.toString(result);
            txt_field_display.setText(resultText);
            txt_conta_extenso.setText(firstNumberText + " - " + secondNumberText + " = " + resultText);
            break;

            case 3:
            result = (firstNumber * secondNumber);
            resultText = Double.toString(result);
            txt_field_display.setText(resultText);
            txt_conta_extenso.setText(firstNumberText + " * " + secondNumberText + " = " + resultText);
            break;

            case 4:
            result = (firstNumber / secondNumber);
            resultText = Double.toString(result);
            txt_field_display.setText(resultText);
            txt_conta_extenso.setText(firstNumberText + " / " + secondNumberText + " = " + resultText);
            break;

            default:
            System.out.print("Erro");
        }
    }

    @FXML
    void clickAddition(ActionEvent event) {
        nextNumber = true;
        operation = 1;
        changePositiveNegativeText = "";
        txt_conta_extenso.setText(firstNumberText + " + ");
    }
    
    @FXML
    void clickSubtraction(ActionEvent event) {
        nextNumber = true;
        operation = 2;
        changePositiveNegativeText = "";
        txt_conta_extenso.setText(firstNumberText + " - ");
    }

    @FXML
    void clickMultiplication(ActionEvent event) {
        nextNumber = true;
        operation = 3;
        changePositiveNegativeText = "";
        txt_conta_extenso.setText(firstNumberText + " * ");
    }

    @FXML
    void clickDivision(ActionEvent event) {
        nextNumber = true;
        operation = 4;
        changePositiveNegativeText = "";
        txt_conta_extenso.setText(firstNumberText + " / ");
    }

    @FXML
    void clickClear(ActionEvent event) {
        negativeFirstNumber = false;
        negativeSecondNumber = false;
        firstNumberText = null;
        secondNumberText = null;
        firstNumber = 0;
        secondNumber = 0;
        nextNumber = false;
        txt_field_display.setText(null);
        txt_conta_extenso.setText(null);
        changePositiveNegativeText = "";
    }

    @FXML
    void clickZero(ActionEvent event) {
        addNumber("0");
    }

    @FXML
    void clickOne(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void clickTwo(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    void clickThree(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void clickFour(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void clickFive(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void clickSix(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void clickSeven(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void clickEight(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void clickNine(ActionEvent event) {
        addNumber("9");
    }

    @FXML
    void clickDot(ActionEvent event) {
        addNumber(".");
    }

    @FXML
    void clickPositiveNegative(ActionEvent event) {
        if(changePositiveNegativeText == "" && nextNumber == false && negativeFirstNumber == false){
            changePositiveNegativeText = "-";
            negativeFirstNumber = true;
            txt_field_display.setText(changePositiveNegativeText + firstNumberText);
            

        }else if(changePositiveNegativeText == "-" && nextNumber == false && negativeFirstNumber == true){
            changePositiveNegativeText = "";
            negativeFirstNumber = false;
            txt_field_display.setText(changePositiveNegativeText + firstNumberText);
            

        }else if(changePositiveNegativeText == "" && nextNumber == true && negativeSecondNumber == false){
            changePositiveNegativeText = "-";
            negativeSecondNumber = true;
            txt_field_display.setText(changePositiveNegativeText + secondNumberText);
            


        }else if(changePositiveNegativeText == "-" && nextNumber == true && negativeSecondNumber == true){
            changePositiveNegativeText = "";
            negativeSecondNumber = false;
            txt_field_display.setText(changePositiveNegativeText + secondNumberText);
        }
    }
    
    void addNumber(String numero){
        if(firstNumberText == null && nextNumber == false){
            firstNumberText = (numero);
            txt_field_display.setText(firstNumberText);

        }else if(firstNumberText != null && nextNumber == false){
            firstNumberText = (firstNumberText + numero);
            txt_field_display.setText(firstNumberText);

        }else if(secondNumberText == null && nextNumber == true){
            secondNumberText = (numero);
            txt_field_display.setText(secondNumberText);

        }else{
            secondNumberText = (secondNumberText + numero);
            txt_field_display.setText(secondNumberText);
        }
    }
}