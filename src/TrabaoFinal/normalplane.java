package TrabaoFinal;

public class normalplane extends plane{
    normalplane(){
        Ventana ventana1 = new Ventana();
        ventana1.setVisible(true);

    }

    public String velocidadavion(){
        String ee="Voy a 100 m/s";
        return ee;
    }
    public void disparar(){
        System.out.println("No disparo...");
    }

}
