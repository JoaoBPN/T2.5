package Modelos.Midias;

import java.util.Date;

public class CD extends Midia{
    private String cantorPrincipal;
    private int numeroDeFaixas;

    public CD(String nomeAlbum, String generoMusical, Date anoDeProducao,
              String cantorPrincipal, int numeroDeFaixas){
        super(nomeAlbum,generoMusical,anoDeProducao);
        this.cantorPrincipal = cantorPrincipal;
        this.numeroDeFaixas = numeroDeFaixas;
    }

    public String getCantorPrincipal(){
        return cantorPrincipal;
    }

    public int getNumeroDeFaixas(){
        return numeroDeFaixas;
    }

}
