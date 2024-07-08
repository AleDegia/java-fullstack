public class Esame {   //devo collegare ad ogni paziente quanti esami deve fare
    private int identificativoEsame;
    private int identificativoPaziente;
    
    public Esame(int identificativoEsame, int identificativoPaziente) {
        this.identificativoEsame = identificativoEsame;
        this.identificativoPaziente = identificativoPaziente;
    }
    public int getIdentificativoEsame() {
        return identificativoEsame;
    }

    public int getIdentificativoPaziente() {
        return identificativoPaziente;
    }


}
