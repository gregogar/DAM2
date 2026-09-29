package model;

public class Producto
{
    private int id;
    private double precio;
    private String nombre;

    public Producto(int i, String n, double p)
    {
        this.id = i;
        this.precio = p;
        this.nombre = n;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public double getPrecio()
    {
        return this.precio;
    }

    public void setId(int i)
    {
        this.id = i;
    }

    public void setPrecio(double p)
    {
        this.precio = p;
    }

    public void setNombre(String n)
    {
        this.nombre = n;
    }
}