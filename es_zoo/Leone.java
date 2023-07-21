//package java_workspaces.es_zoo;

public class Leone extends Mammifero{
        public Leone(String nomeProprioAnimale){
            super(nomeProprioAnimale);
        }

        public String getSpecieAnimale(){  //implemento il metodo getNome della superclasse Animale
            return this.getClass().getSimpleName();  //il metodo getSimpleName() prende il nome della classe come stringa
            //non si può fare senza prima specificare getClass
        }
    }

