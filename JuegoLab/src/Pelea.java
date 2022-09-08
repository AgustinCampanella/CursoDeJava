import java.util.Random;
import java.util.Scanner;

public class Pelea{

    Scanner s1 = new Scanner(System.in);
    Boolean activo = true;

    public static int randomNumberGenerator(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min) +min;
    }





    public void pelea(Guerrero p1, Guerrero p2){
        while(activo){
            System.out.println("Pulse 1 para atacar, 2 para defender o 3 para recuperar stamina");
            switch (s1.nextInt()){
                case 1:
                    p1.decision = 1;
                    break;
                case 2:
                    p1.decision = 2;
                    break;
                case 3:
                    p1.decision = 3;

            }
            p2.decision = randomNumberGenerator(1,4);

            //Ataque jugador a enemigo que ataca
            if(p1.decision == 1 && p2.decision == 1){
                //Ataque empardado
                if(p1.stamina >= 2 && p2.stamina >= 2){
                    p1.stamina -= 2;
                    p2.stamina -= 2;
                    System.out.println("Ambos atacaron y gastaron energia, nadie sale herido\nHas perdido 2 de stamina\n" + p1.stamina +" puntos de stamina restantes");
                //Ataque fallido
                } else if(p1.stamina < 2 && p2.stamina >= 2){
                    p2.atacar(p1);
                    System.out.println("No tienes energia suficiente para atacar y sales herido\nTe quedan " + p1.vida + " puntos de vida restantes");
                //Ataque exitoso
                } else if(p2.stamina < 2 && p1.stamina >= 2){
                    p1.atacar(p2);
                    System.out.println("Ambos atacaron pero el enemigo no tiene energias para protegerse y ha perdido vida\nAl enemigo le restan " + p2.vida + " puntos de vida restantes\n" + p1.stamina + " puntos de stamina restantes");
                //Ataque fallido
                } else if(p2.stamina < 2 && p1.stamina < 2){
                    System.out.println("Ninguno tuvo energias suficientes para realizar una accion");
                }
            //Ataque a jugador enemigo que se defiende
            } else if(p1.decision == 1 && p2.decision == 2){
                //Ataque defendido
                if(p1.stamina >= 2 && p2.stamina >= 1){
                    p1.stamina -= 2;
                    p2.defender(p1);
                    System.out.println("Has atacado pero el enemigo se ha defendido con exito\nHas perdido 2 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Ataque fallido
                } else if(p1.stamina < 2 && p2.stamina >= 1){
                    p2.defender(p1);
                    System.out.println("Te has quedado sin energia para atacar, pero tu rival ha decidido defenderse");
                //Ataque exitoso
                } else if(p2.stamina < 1 && p1.stamina >=2){
                    p1.atacar(p2);
                    System.out.println("El enemigo ha intentado defenderse pero se quedo sin energias, tu ataque fue exitoso\nAl enemigo le restan " + p2.vida + " puntos de vida restantes\nHas perdido 2 puntos de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Ataque fallido
                } else if(p2.stamina < 1 && p1.stamina < 2){
                    System.out.println("Ninguno tuvo energias suficientes para realizar una accion");
                }
            //Ataque indefenso
            } else if(p1.decision == 1 && p2.decision == 3){
                //Ataque exitoso
                if(p1.stamina >= 2){
                    p1.atacar(p2);
                    System.out.println("Has atacado con exito mientras el enemigo recuperaba energias\nAl enemigo le restan " + p2.vida + " puntos de vida restantes\nHas perdido 2 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                    p2.stamina += 6;
                //Ataque fallido
                } else if(p1.stamina < 2){
                    System.out.println("Te has quedado sin energias para atacar, el enemigo ha aprovechado para recuperar energias");
                    p2.stamina += 6;
                }
            //Defensa ante un ataque
            } else if(p1.decision == 2 && p1.decision == 1){
                //Defensa exitosa
                if(p1.stamina >= 1 && p2.stamina >= 2){
                    p1.defender(p2);
                    p2.stamina -= 2;
                    System.out.println("Te has defendido del ataque enemigo con exito\nHas perdido 1 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Defensa fallida
                } else if(p1.stamina < 1 && p2.stamina >=2){
                    p2.atacar(p1);
                    System.out.println("Te has intentado defender pero no tienes energias, has recibido un ataque\n Te quedan "+ p1.vida + " puntos de vida restantes");
                //Defensa exitosa
                } else if(p2.stamina < 2 && p1.stamina >= 1){
                    p1.defender(p2);
                    System.out.println("Te has defendido pero el enemigo no tuvo energias para atacar\n" + p1.stamina + " puntos de stamina restantes");
                //Defensa fallida
                } else if(p2.stamina < 2 && p1.stamina < 1){
                    System.out.println("Ninguno tuvo energias suficientes para realizar una accion");
                }
            //Defensa ante una defensa
            } else if(p1.decision == 2 && p2.decision == 2){
                //Defensa exitosa
                if(p1.stamina >= 1 && p2.stamina >= 1){
                    p1.defender(p2);
                    p2.defender(p1);
                    System.out.println("Ambos se han defendido\nHas perdido 1 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Defensa fallida
                } else if(p1.stamina < 1 && p2.stamina >= 1){
                    p2.defender(p1);
                    System.out.println("No tienes energia para defenderte, por suerte el enemigo se defiende tambien");
                //Defensa exitosa
                } else if(p2.stamina < 1 && p1.stamina >= 1){
                    p1.defender(p2);
                    System.out.println("Te defiendes contra un enemigo que se ha quedado sin energias para defenderse\nHas perdido 1 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Defensa fallida
                } else if(p2.stamina < 1 && p1.stamina < 1){
                    System.out.println("Ninguno tuvo energias suficientes para realizar una accion");
                }
            //Defensa ante recarga
            } else if(p1.decision == 2 && p2.decision == 3){
                //Defensa exitosa
                if(p1.stamina >= 1){
                    p1.defender(p2);
                    p2.stamina += 6;
                    System.out.println("Te has defendido mientras el enemigo recuperaba energias\nHas perdido 1 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Defensa fallida
                } else if(p1.stamina < 1){
                    p2.stamina += 6;
                    System.out.println("No tienes energias para defenderte, el enemigo aprovecha para recuperar energias");
                }
            //Recarga de energia ante ataque
            } else if(p1.decision == 3 && p2.decision == 1){
                //Recarga extisa con daño
                if(p2.stamina >= 2){
                    p2.atacar(p1);
                    p1.stamina += 6;
                    System.out.println("Te han atacado mientras recuperabas energias\nTe quedan " + p1.vida + " puntos de vida restantes\nHas recuperado 6 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Recarga exitosa sin daños
                } else if(p2.stamina < 2){
                    p1.stamina += 6;
                    System.out.println("El enemigo no tiene energias suficientes para atacar, recargas energias sin problemas\nHas recuperado 6 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                }
            //Recarga de energia ante defensa
            } else if(p1.decision == 3 && p2.decision == 2){
                //Recarga exitosa con defensa
                if(p2.stamina >= 1){
                    p1.stamina += 6;
                    p2.defender(p1);
                    System.out.println("Has recuperado energias mientras el enemigo se protegia\nHas recuperado 6 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                //Recarga exitosa sin defensa
                } else if(p2.stamina < 1){
                    p1.stamina += 6;
                    System.out.println("El enemigo no tiene energias para defenderse, recargas energias sin problema\nHas recuperado 6 de stamina\n" + p1.stamina + " puntos de stamina restantes");
                }
            //Recarga de energia ante recarga
            } else if(p1.decision == 3 && p2.decision == 3){
                p1.stamina += 6;
                p2.stamina += 6;
                System.out.println("Ambos han recuperado energias\nHas recuperado 6 de stamina\n" + p1.stamina + " puntos de stamina restantes");
            }

            //Condicion de finalizacion del juego
            if(p1.vida <= 0){
                System.out.println("\nHas muerto en combate");
                activo = false;
            } else if(p2.vida <= 0){
                System.out.println("\nHas ganado el combate");
                activo = false;
            }
        }
    }

}
