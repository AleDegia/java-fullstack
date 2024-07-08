//package java_workspaces.es_zoo;
public class Pitone extends Rettile{
    public Pitone(String nomeProprioAnimale){
        super(nomeProprioAnimale);
    }

    public String getSpecieAnimale(){
        return this.getClass().getSimpleName();
    }
}
