public class Pista extends Thread{
    
    private Aereoporto aereoporto;
    public int idPista;
    //idPista Rules:
    //0     Pista A
    //1     Pista B
    

    //Costruttore
    public Pista(Aereoporto a, int id){
        aereoporto = a;
        idPista = id;
    }

    //toString
    public String toString(){
        String nome = "";
        if(idPista == 0){
            nome = "Pista A";
        } else if(idPista == 1){
            nome = "Pista B";
        }
        return nome;
    }

    //Metodo Run
    public void run(){
        try {
            aereoporto.faiAtterrare(this);
            aereoporto.faiPartire(this);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}