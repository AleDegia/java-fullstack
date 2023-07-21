public class Giocatore {
    private String nome;
    private int tentativi;

    public Giocatore(String nome, int tentativi) {
        this.nome = nome;
        this.tentativi = tentativi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTentativi() {
        return tentativi;
    }

    public void setTentativi(int tentativi) {
        this.tentativi = tentativi;
    }

}
