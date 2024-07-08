//package java_workspaces.es_zoo;

public abstract class Mammifero extends Animale { //la classe astratta mammifero estende la superclasse Animale
    public Mammifero(String nomeProprioAnimale){
        super(nomeProprioAnimale);//super= della superclasse
    }

    public String getOrdineAnimale(){ //implemento il metodo getClasse della superclasse
        return "Mammifero";
    }
}
