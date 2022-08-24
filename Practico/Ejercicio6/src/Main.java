public class Main {

    public static void main(String[] args) {
        int numero = 60;
        int otroNumero = 10;

        //Funciones Trigonometricas

        System.out.println(Math.sin(numero));
        System.out.println(Math.cos(numero));
        System.out.println(Math.tan(numero));
        System.out.println(Math.atan(numero));
        System.out.println(Math.atan2(numero,otroNumero));

        //Funciones exponenciales y su inversa

        System.out.println("E, elevado a 60 es " + Math.exp(numero));
        System.out.println("La base neutral de 10 es " + Math.log(otroNumero));

        //Constante PI y E

        System.out.println("Pi es igual a " + Math.PI);
        System.out.println("E es igual a " + Math.E);

    }
}
