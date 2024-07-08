public class Gallina extends Animale{
    public Gallina(String nome){ //invece che dichiarare la variabile, la eredito dalla classe padre, percio faccio subito il costruttore
        super(nome);
    }

    @Override
    public void faRumore(){
        System.out.println(getNome() + "dice: Coccode!");
    }
}
