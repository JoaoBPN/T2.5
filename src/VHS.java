import java.util.List;

public class VHS extends MidiaVisual{
    private boolean rebobinado;

    public VHS(String nome, String genero,int ano, double aluguelDiario,int quantidadeDeCopias,List<String> atores,int duracaoEmMinutos, String diretor,boolean rebobinado){
        super(nome,genero,ano,aluguelDiario,quantidadeDeCopias,atores,duracaoEmMinutos,diretor);
        setRebobinado(rebobinado);
    }

    public void setRebobinado(boolean rebobinado){
        this.rebobinado = rebobinado;
    }

    public boolean getRebobinado(){
        return rebobinado;
    }

    @Override
    public boolean participanteNaMidia(String participante){
        return participante.equals(getDiretor()) || getAtores().contains(participante);
    }

    @Override
    public String toString(){
        return  "Título: "+getNome() + "\n" +
                "Gênero:" +getGenero() + "\n"+
                "Ano de lançamento: "+getAno() + "\n"+
                "Diretor: " +getDiretor()+ "\n"+
                "Atores: " +concatenaAtoresEmString(getAtores()) +"\n"+
                "Duração: "+getDuracaoEmMinutos()+"\n"+
                "Aluguel diário: "+getAluguelDiario() + " reais\n";
    }

}
