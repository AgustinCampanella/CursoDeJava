import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int altura;
        int peso;

        System.out.println("Ingrese altura en cm");
        Scanner s1 = new Scanner(System.in);
        altura = s1.nextInt();

        System.out.println("Ingrese genero:"+ (char)34 +"Hombre" + (char)34 + " o " + (char)34 + "Mujer" + (char)34);
        String gen = new String(s1.next());
        gen = gen.toLowerCase();
        if(gen.equals("hombre")){
            peso = altura - 110;
            System.out.println("El peso ideal es " + peso);
        } else if(gen.equals("mujer")){
            peso = altura - 120;
            System.out.println("El peso ideal es " + peso);
        } else{
            System.out.println("Genero invalido");
        }
    }
}
