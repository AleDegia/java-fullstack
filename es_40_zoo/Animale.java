//package java_workspaces.es_zoo;

public abstract class Animale {     //si chiamano variabili di istanza
    private String ordineAnimale;    //mammifero, rettile, pesce
    private String specieAnimale;     //cane, gatto, cavallo
    private String nomeProprioAnimale;

    public Animale(String nomeDato){   //costruttore della classe Animale che crea un oggetto animale 
        this.nomeProprioAnimale=nomeDato;
    }

    public String getNomeProprioAnimale(){
        return nomeProprioAnimale;
    }

    public abstract String getSpecieAnimale(); //metodo che verrà implementato dalle sottoclassi

    public abstract String getOrdineAnimale(); //idem, abstract perchè non è ancora definito

    public void stampa(){  //metodo di stampa
        System.out.println(
            "Ordine: " + getOrdineAnimale() +
            "\n Nome animale: " + getSpecieAnimale() +
            "\n Nome proprio: " + getNomeProprioAnimale()
        );
    }

}
