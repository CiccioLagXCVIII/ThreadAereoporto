public class Main{
    public static void main(String[] args){
        final int numPiste = 2;
        final int numAerei = 10;

        //Monitor
        Aereoporto aereoporto = new Aereoporto();

        //Array Di Thread
        Aereo aereo[] = new Aereo[numAerei];
        Pista pista[] = new Pista[numPiste];

        //Creazione E Avvio Thread
        for (int i = 0; i < numPiste; i++) {
            pista[i] = new Pista(aereoporto, i);
            pista[i].start();
            System.out.println(pista[i].toString() + " Creata!");
        }

        
        for (int j = 0; j < numAerei; j++) {
            aereo[j] = new Aereo(aereoporto, j, j%2, j&2);      //i%3 può dare solo 0 e 1
            aereo[j].start();
        }
    }
}