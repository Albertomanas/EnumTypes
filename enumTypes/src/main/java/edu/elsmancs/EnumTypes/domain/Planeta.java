package edu.elsmancs.EnumTypes.domain;

import java.util.EnumSet;

//Libro Beginning Java 8 Fundamentals (Cap. 18 Enum Types)

public enum Planeta {

    // pag 707 (Declaración de enum)
    MERCURY (3.303e+23, 2.4397e6),
    VENUS (4.869e+24, 6.0518e6),
    EARTH (5.976e+24, 6.37814e6),
    MARS (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27, 7.1492e7),
    SATURN (5.688e+26, 6.0268e7),
    URANUS (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private double masa = 0d;
    private double radio = 0d;


    /**propiedad de la gravedad G (kg-1 y s-2) Teoría de la gravitación universal
     *  G= (6,674*10^-11)* ((N*m^2)/kg^2)
     */
    public static final double G = 6.67300e-11;

    private Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    public double getMasa() {
        return this.masa;
    }

    public double getRadio() {
        return this.radio;
    }

    public double pesoSuperficie(double peso){
        return tu_masa(peso) * this.gravedadSuperficial();
    }

    public double tu_masa(double peso) {
        return peso / this.gravedadSuperficial(EARTH);
    }


    public double gravedadSuperficial() {
        return G * this.masa / (this.radio * this.radio);
    }

    /**Necesario hacer gravedadSuperficial de planeta para obtener EARTH para calcular tu_masa
     *
     * @param planeta
     * @return
     */

    public double gravedadSuperficial(Planeta planeta) {
        return G * planeta.getMasa() / (planeta.getRadio() * planeta.getRadio());
    }

    //Pag 724
    public static EnumSet<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(Planeta.MERCURY, Planeta.MARS);
    }

    //Rangos, pag 724 (allOf, range, complementOf)
    public static EnumSet<Planeta> getGigantesGaseosos(){
        return EnumSet.complementOf(getPlanetasTerrestres());
    }
}
