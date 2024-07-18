public class CD extends Midia{
    private String cantorPrincipal;
    private int numeroDeFaixas;

    public CD(String nome,String genero,int ano,double aluguelDiario,int quantidadeDeCopias,String cantorPrincipal,int numeroDeFaixas){
        super(nome,genero,ano,aluguelDiario,quantidadeDeCopias);
        setCantorPrincipal(cantorPrincipal);
        setNumeroDeFaixas(numeroDeFaixas);
    }

    public void setCantorPrincipal(String cantorPrincipal){
       this.cantorPrincipal = cantorPrincipal;
    }

    public String getCantorPrincipal(){
        return cantorPrincipal;
    }

    public void setNumeroDeFaixas(int numeroDeFaixas){
        this.numeroDeFaixas = numeroDeFaixas;
    }

    public int getNumeroDeFaixas(){
        return numeroDeFaixas;
    }

    @Override
    public boolean participanteNaMidia(String participante){
        return participante.equals(getCantorPrincipal());
    }

    @Override
    public String toString(){
        return  "Título: "+getNome() + "\n" +
                "Gênero: " +getGenero() + "\n"+
                "Ano de lançamento: "+getAno() + "\n"+
                "Cantro: "+getCantorPrincipal() +"\n"+
                "Numero de faixas: "+ getNumeroDeFaixas() +"\n"+
                "Aluguel diário: "+getAluguelDiario() + " reais\n";
    }


}
