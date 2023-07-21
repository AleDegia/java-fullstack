import java.util.ArrayList;
import java.util.List;

public class Fattoria {
    private List<Animale> animali;

    public Fattoria() {
        this.animali = new ArrayList<>();
    }

    public void aggiungiAnimale(Animale animale){
        this.animali.add(animale);
    }

    public void faRumore(){
        for(Animale animale : animali){
            animale.faRumore();
        }
    }
}
