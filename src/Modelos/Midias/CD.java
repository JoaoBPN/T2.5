package Modelos.Midias;


public class CD extends Midia{
    private final String cantorPrincipal;
    private final int numeroDeFaixas;

    public CD(String nomeAlbum, String generoMusical, int anoDeProducao,
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

    @Override
    public String toString(){
        return "Álbum: "+getNome()+
                "\nGênero: "+getGenero()+
                "\nAno de produção: "+getData()+
                "\nCantor principal: "+getCantorPrincipal()+
                "\nNumero de faixas: "+getNumeroDeFaixas();
    }

    @Override
    public boolean hasParticipante(String participante) {
        return getCantorPrincipal().equals(participante);
    }
}
