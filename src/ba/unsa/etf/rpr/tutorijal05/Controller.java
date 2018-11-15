package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.WritableFloatValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.awt.*;

public class Controller {
    private SimpleStringProperty broj;
    private SimpleStringProperty prethodnoUneseniBroj; //ovaj atribut sluzi da se sacuva vrijednost prvog operanda
    private SimpleStringProperty operacije;
    private String displej = "";
    private double rezultat = 0;
    public Controller() {
        broj = new SimpleStringProperty("");
        prethodnoUneseniBroj = new SimpleStringProperty("");
        operacije = new SimpleStringProperty("=");
        prethodnoUneseniBroj = new SimpleStringProperty("=");
        broj.set("0");
    }
    public SimpleStringProperty brojProperty() {
        return broj;
    }
    public String getBroj() {
        return broj.get();
    }

    public SimpleStringProperty prethodnoUneseniBrojProperty() {
        return prethodnoUneseniBroj;
    }

    public String getprethodnoUneseniBroj() {
        return prethodnoUneseniBroj.get();
    }
    public SimpleStringProperty operacijeProperty() {
        return operacije;
    }
    public String getOperacije() {
        return operacije.get();
    }
    private void napraviBroj(String br) {
        if(getBroj().equals("0") && !br.equals("0")) {
            brojProperty().setValue("");
        }
        brojProperty().setValue(getBroj().concat(br));
    }
    public void nulaBtn(ActionEvent actionEvent) {
        if(!getBroj().equals("0") && !getprethodnoUneseniBroj().equals("0"))
            napraviBroj("0");
    }
    public void jedanBtn(ActionEvent actionEvent) {
        napraviBroj("1");
    }
    public void dvaBtn(ActionEvent actionEvent) {
        napraviBroj("2");
    }

    public void triBtn(ActionEvent actionEvent) {
        napraviBroj("3");
    }

    public void cetiriBtn(ActionEvent actionEvent) {
        napraviBroj("4");
    }

    public void petBtn(ActionEvent actionEvent) {
        napraviBroj("5");
    }

    public void sestBtn(ActionEvent actionEvent) {
        napraviBroj("6");
    }

    public void sedamBtn(ActionEvent actionEvent) {
        napraviBroj("7");
    }

    public void devetBtn(ActionEvent actionEvent) {
        napraviBroj("9");
    }

    public void osamBtn(ActionEvent actionEvent) {
        napraviBroj("8");
    }

    public void putaBtn(ActionEvent actionEvent) {
        prethodnoUneseniBroj.set(getBroj());
        broj.set("");
        if(!displej.contains("x")) {
            operacije.set("x");
            displej += "x";
        }
    }

    public void podijeljenoBtn(ActionEvent actionEvent) {
        prethodnoUneseniBroj.set(getBroj());
        broj.set("");
        operacije.set("/");
    }

    public void minusBtn(ActionEvent actionEvent) {
        prethodnoUneseniBroj.set(getBroj());
        broj.set("");
        operacije.set("-");
    }

    public void modulBtn(ActionEvent actionEvent) {
        prethodnoUneseniBroj.set(getBroj());
        broj.set("");
        operacije.set("%");
    }

    public void plusBtn(ActionEvent actionEvent) {
        prethodnoUneseniBroj.set(getBroj());
        broj.set("");
        operacije.set("+");
    }
    public void dotBtn(ActionEvent actionEvent) {
        prethodnoUneseniBroj.set(getBroj());
        broj.set(getBroj() + ".");
        operacije.set(".");
    }

    public void equalsBtn(ActionEvent actionEvent) {
        if(getOperacije().equals("x")) rezultat = Double.parseDouble(getBroj()) * Double.parseDouble(getprethodnoUneseniBroj());
        else if(getOperacije().equals("/"))  rezultat = Double.parseDouble(getprethodnoUneseniBroj()) / Double.parseDouble(getBroj());
        else if(getOperacije().equals("+")) rezultat = Double.parseDouble(getBroj()) + Double.parseDouble(getprethodnoUneseniBroj());
        else if(getOperacije().equals("-")) rezultat = Double.parseDouble(getprethodnoUneseniBroj()) - Double.parseDouble(getBroj());
        else if(getOperacije().equals("%")) rezultat = Double.parseDouble(getprethodnoUneseniBroj()) % Double.parseDouble(getBroj());
        else if(getOperacije().equals("=")) rezultat = Double.parseDouble(getBroj());

        brojProperty().setValue("" + rezultat);
    }
    public void decimal(ActionEvent actionEvent) {
       // if(!display.get().contains("."))
      //      display.set(display.get() + ".");
    }
}
