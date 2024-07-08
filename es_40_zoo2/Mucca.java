public class Mucca extends Animale {
    public Mucca(String nome){
        super(nome);
    }

    @Override
    public void faRumore(){
        System.out.println(getNome() + "dice: Mooo");
    }
}
