package Modelos.Sequenciadores;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SequenciadorString {

    private Set<String> sequenciaisGerados = new HashSet<>();

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SERIAL_LENTH = 7;
    private static final int MAX_SEQUENCIAIS = 308916776; // CHARACTER.LENTH() ^ SERIAL_LENTH

    public String getNovoSerial(){

    if(limiteAtingido()) return null;

    var novoSerial = geraSerialAleatorio();

    while(sequenciaisGerados.contains(novoSerial)){
        novoSerial = geraSerialAleatorio();
    }

    return novoSerial;

    }

    private String geraSerialAleatorio(){
        var random = new Random();
        var serial = new StringBuilder(SERIAL_LENTH);

        for (int i = 0; i < SERIAL_LENTH; i++) {
            int letra = random.nextInt(CHARACTERS.length());
            serial.append(CHARACTERS.charAt(letra));
        }

        return serial.toString();
    }

    private boolean limiteAtingido(){
        if(sequenciaisGerados.size() >= MAX_SEQUENCIAIS/2){

            if(sequenciaisGerados.size() == MAX_SEQUENCIAIS - 1){
                System.out.println("NÃO É POSSIVEL GERAR MAIS SEQUENCIAIS");
                return true;
            }

            System.out.println("O numero de sequenciais esta acabando");
            // Como esse é um exercício, acredito que não havia necessidade de solucionar esse problema, mesmo se não fosse
            // o valor de sequenciais é bem grande, contudo quanto mais proximo sequenciaisGerados.size() for de MAX_SEQUENCIAIS
            // mais demorará pro sequencial ser gerado
        }
        return false;
    }

}
