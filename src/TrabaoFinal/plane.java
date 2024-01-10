package TrabaoFinal;

abstract class plane implements objetovolador{
    private Double peso;
    private Double velocidad;
    private Integer pasajeros;

    public void volar() {
        System.out.println("Soy un avion y vuelo");
    }
    abstract String velocidadavion();
    public double getPeso(){
        return this.peso;
    };
    public double getVelocidad(){
        return this.velocidad;
    };
    public Integer getPasajeros(){
        return this.pasajeros;
    };
    public void setPeso (Double num){
        this.peso=num;
    };
    public void setVelocidad (Double num){
        this.velocidad=num;
    };
    public void setPasajeros (Integer num){
        this.pasajeros=num;
    };



}

