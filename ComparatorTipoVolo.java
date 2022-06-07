import java.util.Comparator;
public class ComparatorTipoVolo implements Comparator<Aereo>{

    public int compare(Aereo a1, Aereo a2){
        if(a1.tipoVolo < a2.tipoVolo){
            return 1;
        } else if(a1.tipoVolo > a2.tipoVolo){
            return -1;
        }
        return 0;
    }
}