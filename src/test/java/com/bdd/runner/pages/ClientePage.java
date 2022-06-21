package com.bdd.runner.pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ClientePage extends BasePage {

    public ClientePage() {
        super(driver);
    }

    public void nevegateToCliente() {

        try {

            navigateTo("http://localhost:4200/");

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Pagina no encontrada " + e.getMessage());
        }
    }

    public void filtrarClienteIdentificacion(String cedula) {
        try {
            //ubicamos el componente y filtramos por la cedula
            findXpath("//*[@id=\"tblFilterIdentificacion\"]").sendKeys(cedula);
            //verificamos que se halla filtrado en la tabla y tomamos el registro de la tabla
            WebElement element = findXpath("//*[@id=\"tblListaCliente\"]/div/div[2]/table/tbody");
            //verificamos que este presente
            if (element.isDisplayed()) {
                //mandamos hacer click en el boton de editar mediante la referencia a su componente
                //Podriamos hacerlo por su path relativo
                //clickElementXpath("//*[@id=\"btnActualizar\"]");
                //Tambien lo podriamos hacer por su Id ya que este boton si lo tiene escojeremos esta opcion
                clickElementById("btnActualizar");
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

    public void insertarDatoModificar() {
        try {
            WebElement element = findId("txtDireccion");
            //vamos a concatenarle la direccion que tenga mas "Modificada desde selenium test"
            String direccion = element.getText() + " Modificada desde selenium test";
            element.clear();
            element.sendKeys(direccion);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

    public void butonGuardar() {
        try {
            clickElementById("btnGuardar");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

    public boolean messageGuardar() {

        String text = getText("/html/body/app-root/app-principal/app-cliente/p-toast/div/p-toastitem/div/div/div/div[2]");
        try {
            if (text.trim().equals("Registro actualizado"))

                return true;
            else
                return false;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }


    }

    public void clickbotonNuevoCliente() {
        try {
            clickElementById("btnNuevo");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

    public void insertamosDatosNuevoCliente() {
        try {
            String cedula = "1311902005";
            String nombres = "Juan Pablo";
            String apellidos = "Perez Ramirez";
            Integer edad = 33;
            String telefono = "088765456";
            String fechaNacimiento = "1988-12-10";
            String estadoCivil = "Soltero";
            String direccion = "Vicentina";
            String sujetoCredito = "Sujeto de crédito";
            findId("txtIdentificacion").sendKeys(cedula);
            findId("txtNombre").sendKeys(nombres);
            findId("txtApellido").sendKeys(apellidos);
            findId("txtEdad").sendKeys(edad.toString());
            findId("txtTelefono").sendKeys(telefono);
            findXpath("//body/app-root[1]/app-principal[1]/app-cliente[1]/p-panel[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[5]/div[1]/div[2]/p-calendar[1]/span[1]/input[1]").sendKeys(fechaNacimiento);
            findId("txtDireccion").sendKeys(direccion);
            findId("txtEstadoCivil").sendKeys(estadoCivil);
            findXpath("//body/app-root[1]/app-principal[1]/app-cliente[1]/p-panel[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[11]/div[1]/div[1]/p-radiobutton[1]/div[1]/div[2]").click();

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

    public void filtrarClienteIdentificacionEliminar(String cedula) {
        try {
            //ubicamos el componente y filtramos por la cedula
            findXpath("//*[@id=\"tblFilterIdentificacion\"]").sendKeys(cedula);

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

    public void clickBotonEliminar() {
        try {

            //verificamos que se halla filtrado en la tabla y tomamos el registro de la tabla
            WebElement element = findXpath("//*[@id=\"tblListaCliente\"]/div/div[2]/table/tbody");
            //verificamos que este presente
            if (element.isDisplayed()) {
                //mandamos hacer click en el boton de editar mediante la referencia a su componente
                //Tambien lo podriamos hacer por su Id ya que este boton si lo tiene escojeremos esta opcion
                clickElementById("btnEliminar");
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: Componente no encontrado " + e.getMessage());
        }
    }

}
