package model;

public class Car {

    private String modelo, marca;
    private int anoFabricacion;

    public Car(String marca, String modelo, int anoFabricacion){
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public String getModelo() {
        return modelo;
    }
}