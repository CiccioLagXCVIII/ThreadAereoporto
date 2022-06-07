public class Aereo extends Thread{

    private Aereoporto aereoporto;
    public int idAereo;
    public int tipoVolo;
    //tipoVolo Rules:
    //  0 = Nazionale
    //  1 = Interzionale
    public int tipoAereo;
    //tipoAereo Rules:
    //  0 = In Partenza
    //  1 = In Arrivo

    //Costruttore
    public Aereo(Aereoporto a, int id, int tipoA, int tipoV){
        aereoporto = a;
        idAereo = id;
        tipoAereo = tipoA;
        tipoVolo = tipoV;
    }

    //tipoVoloToString
    public String tipoVoloToString(){
        String volo = "";
        if(tipoVolo == 0){
            volo = "Volo Nazionale";
        } else if(tipoVolo == 1){
            volo = "Volo Internazionale";
        }
        return volo;
    }

    //tipoAereoToString
    public String tipoAereoToString(){
        String aereo = "";
        if(tipoAereo == 0){
            aereo = "Aereo In Partenza";
        } else if(tipoAereo == 1){
            aereo = "Aereo In Arrivo";
        }
        return aereo;
    }



    //Metodo Run
    public void run(){
        try{
            Thread.sleep((int)Math.random() * 3000);
            aereoporto.mettiInCoda(this);
        } catch (Exception e){
            //TODO: handle exception
        }
    }
}