public class Guerrero extends Player implements Ataque,Defensa{

    public Guerrero(){
        this.vida = 50;
        this.ataque = 10;
        this.defensa = 7;
        this.stamina = 10;
        this.decision = 0;
    }


    @Override
        public void atacar(Player player){
            player.vida -= this.ataque;
            this.stamina -=2;
    }

    @Override
        public void defender(Player player){
            this.stamina--;
    }

}
