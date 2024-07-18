import java.util.List;

public abstract class MidiaVisual extends Midia{
    private List<String> atores;
    private int duracaoEmMinutos;
    private String diretor;

    public MidiaVisual(String nome,String genero,int ano,double aluguelDiario,int quantidadeDeCopias,List<String> atores,int duracaoEmMinutos,String diretor){
        super(nome,genero,ano,aluguelDiario,quantidadeDeCopias);
        setDuracaoEmMinutos(duracaoEmMinutos);
        setDiretor(diretor);
        setAtores(atores);
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos){
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos(){
        return duracaoEmMinutos;
    }

    public void setDiretor(String diretor){
        this.diretor = diretor;
    }

    public String getDiretor(){
        return diretor;
    }

    public void setAtores(List<String> atores){
        this.atores = atores;
    }

    public List<String> getAtores(){
        return atores;
    }

    public String concatenaAtoresEmString(List<String> atores){
        return String.join(" \n",atores);
    }
}
