public class Avvio {
    public static void main(String[] args) {
        Persona p = new Persona("Pino", "Rossi");
        System.out.println(p.getNome()+ " " +p.getCognome());

        Dipendente d = new Dipendente("Mauro", "GI", 2000);
        System.out.println(d.getNome()+ " "+d.getCognome()+" "+ d.getStipendio());

        if(p instanceof Dipendente){ //se p è istanza di dipendente stampa.. (in questo caso non lo è, se mettevo d era vero)
            System.out.println("il riferimento appartiene ad un dipendente");
        }
        else
            System.out.println("il riferimento è di una persona");
    }
}
