import java.util.List;

public class DVD extends MidiaVisual{
    private int classificacaoEtaria;
    private String regiao;

    public DVD(String nome, String genero,int ano,double aluguelDiario,int quantidadeDeCopias,List<String> atores,int duracaoEmMinutos, String diretor,int classificacaoEtaria,String regiao){
        super(nome,genero,ano,aluguelDiario,quantidadeDeCopias,atores,duracaoEmMinutos,diretor);
        setClassificacaoEtaria(classificacaoEtaria);
        setRegiao(regiao);
    }

    public void setClassificacaoEtaria(int classificacaoEtaria){
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public int getClassificacaoEtaria(){
        return classificacaoEtaria;
    }

    public void setRegiao(String regiao){
        this.regiao = regiao;
    }

    public String getRegiao(){
       return regiao;
    }

    @Override
    public boolean participanteNaMidia(String participante){
        return participante.equals(getDiretor()) || getAtores().contains(participante);
    }

    @Override
    public String toString(){
        return     "Título: "+getNome() + "\n" +
                   "Gênero: " +getGenero() + "\n"+
                   "Ano de lançamento: "+getAno() + "\n"+
                   "Diretor: " +getDiretor()+ "\n"+
                   "Atores: " +concatenaAtoresEmString(getAtores()) +"\n"+
                   "Duração: "+getDuracaoEmMinutos()+"\n"+
                   "Classificação Indicativa: "+getClassificacaoEtaria() +"\n"+
                   "Aluguel diário: "+getAluguelDiario() + " reais\n";

    }

}
