import java.util.PriorityQueue;
//Atterraggio >> Partenza       Internazionali >> Nazionali
public class Aereoporto {
    private int PostiCodaPartenza = 10;
    ComparatorTipoVolo comparatorTipoVolo = new ComparatorTipoVolo();
    private PriorityQueue<Aereo> codaAtterraggio = new PriorityQueue<Aereo>(comparatorTipoVolo);
    private PriorityQueue<Aereo> codaPartenza = new PriorityQueue<Aereo>(PostiCodaPartenza, comparatorTipoVolo);
    private Aereo ultimoAtterrato;
    private Aereo ultimoPartito;

    public synchronized void mettiInCoda(Aereo aereo){
        if (aereo.tipoAereo == 0) { //In Partenza
            System.out.println("L'Aereo " + aereo.idAereo + " Viene Aggiunto Alla Coda Di Partenza");
            codaPartenza.add(aereo);
            notifyAll();
        } else if (aereo.tipoAereo == 1) { //In Arrivo
            System.out.println("L'Aereo " + aereo.idAereo + " Viene Aggiunto Alla Coda Di Atterraggio");
            codaAtterraggio.add(aereo);
            notifyAll();
        }
    }

    public synchronized void faiAtterrare(Pista pista){
        while(codaAtterraggio.size() == 0){
            System.out.println("Non Ci Sono Aerei Che Vogliono Atterrare!");
            try{
                wait();
            } catch (Exception e) {
                //TODO
            }
        }
        while(codaAtterraggio.size() != 0){
            System.out.println("L'Aereo " + codaAtterraggio.peek().idAereo + " Può Atterrare Nella" + pista.toString());
            ultimoAtterrato = codaAtterraggio.poll();
            
            try {
                Thread.sleep((int)Math.random() * 2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            
            System.out.println("L'Aereo " + ultimoAtterrato.idAereo + " E' Atterrato In Sicurezza Sulla " + pista.toString());
        }
        notifyAll();
    }

    public synchronized void faiPartire(Pista pista){
        while(codaAtterraggio.size() == 0){
            //Non ci sono aerei che vogliono atterrare Quindi
            while(codaPartenza.size() == 0){
                System.out.println("Non Ci Sono Aerei Che Vogliono Partire!");
                try{
                    wait();
                } catch (Exception e) {
                    //TODO
                }
            }
            while(codaPartenza.size() != 0){
                System.out.println("L'Aereo " + codaPartenza.peek().idAereo + " Può Partire Dalla" + pista.toString());
                ultimoPartito = codaPartenza.poll();
                
                try {
                    Thread.sleep((int)Math.random() * 2000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
                System.out.println("L'Aereo " + ultimoPartito.idAereo + " E' Partito In Sicurezza Dalla " + pista.toString());
            }
            notifyAll();
        }
    }   
}