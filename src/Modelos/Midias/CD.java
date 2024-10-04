package Modelos.Midias;

import java.math.BigDecimal;
import java.util.Date;

public class CD extends Midia{
    private String cantorPrincipal;
    private int numeroDeFaixas;

    public CD(String nomeAlbum, String generoMusical, Date anoDeProducao, BigDecimal aluguelDiario,
              String cantorPrincipal, int numeroDeFaixas){
        super(nomeAlbum,generoMusical,anoDeProducao,aluguelDiario);
    }

    public String getCantorPrincipal(){
        return cantorPrincipal;
    }

    public int getNumeroDeFaixas(){
        return numeroDeFaixas;
    }

}
