public class Paziente extends Persona{
    private int priorita;
    private int identificativo;

    public Paziente(int priorita, int identificativo, String nome, String cognome) {
        super.nome= nome;
        super.cognome= cognome;
        this.priorita = priorita;
        this.identificativo = identificativo;
    }

   public int getPriorita(){
    return priorita;
   }

   public int getIdentificativo(){
    return identificativo;
   }

   public String getNome(){
    return nome;
   }

   public String getCognome(){
    return cognome;
   }

}
