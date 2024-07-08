public class Amazon {
    private String nome;
    private double prezzoAzioneAmazon;
    
    public Amazon(String nome, double prezzoAzioneAmazon) {
        this.nome = nome;
        this.prezzoAzioneAmazon = prezzoAzioneAmazon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzoAzioneAmazon() {
        return prezzoAzioneAmazon;
    }

    public void setPrezzoAzioneAmazon(double prezzoAzioneAmazon) {
        this.prezzoAzioneAmazon = prezzoAzioneAmazon;
    }

    
}
