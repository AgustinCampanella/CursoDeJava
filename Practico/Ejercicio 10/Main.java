import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numero;
        int adivinador = (int) (Math.random() * 101);
        int i = 0;
        int intentos = 0;

        System.out.println("Adivina el numero entre 1 y 100\nIngrese un numero");
        Scanner s1 = new Scanner(System.in);
        numero = s1.nextInt();
        if(numero <= 100 && numero >=0){
            while(i == 0){
                if(numero > adivinador){
                    intentos ++;
                    System.out.println("El numero es menor, ingrese otro");
                    numero = s1.nextInt();
                } else if(numero < adivinador){
                    intentos ++;
                    System.out.println("El numero es mayor, ingrese otro");
                    numero = s1.nextInt();
                } else {
                    intentos ++;
                    System.out.println("Numero correcto\nEl numero aleatorio era "+ adivinador);
                    System.out.println("Cantidad de intentos " + intentos);
                    i = 1;
                }
            }
            if(numero > adivinador){
                System.out.println();
            }
        } else {
            System.out.println("Numero invalido");
        }

    }
}
