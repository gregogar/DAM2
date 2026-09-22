package dao;

public class RemoteCarDAO implements CarDAO{
    
    public String ruta;

    public RemoteCarDAO(String ruta)
    {
        this.ruta = ruta;
    }

}
