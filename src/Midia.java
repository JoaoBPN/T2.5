import java.util.HashMap;
import java.util.Map;

public abstract class Midia {

    private String nome;
    private String genero;
    private int ano;
    private double aluguelDiario;
    private final Sequenciador sequenciadorDasCopias = new Sequenciador();
    private final Map<Integer,Boolean> copias = new HashMap<>();

    public Midia(String nome,String genero,int ano,double aluguelDiario,int quantidadeDeCopias){
        setNome(nome);
        setGenero(genero);
        setAno(ano);
        setAluguelDiario(aluguelDiario);
        adicionaCopias(quantidadeDeCopias);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getGenero(){return genero;}

    public void setAno(int ano){
        this.ano = ano;
    }

    public int getAno(){
        return ano;
    }

    public void setAluguelDiario(Double aluguelDiario){
        this.aluguelDiario = aluguelDiario;
    }

    public double getAluguelDiario(){
        return aluguelDiario;
    }

    public boolean participanteNaMidia(String participante){
        return false;
    }

    public void adicionaCopias(int quantidadeDeCopias){
        for (int i = 0; i < quantidadeDeCopias; i++) {
            int num = sequenciadorDasCopias.getNewId();
            copias.put(num,false);
        }
    }

    public Boolean isAlugada(int num){
        if(!copias.containsKey(num)) {
            System.out.println("Copia inixesitente");
            return false;
        }
        return copias.get(num);
    }

    public void alugaCopia(int num){
        if(!copias.containsKey(num)){
            System.out.println("copia inexistente");
            return;
        }
        if(isAlugada(num)){
            System.out.println("Essa cópia já foi alugada");
            return;
        }
        copias.replace(num,false,true);
    }

    public void devolveCopia(int num){
        if(!copias.containsKey(num)){
            System.out.println("copia inexistente");
            return;
        }
        if(!isAlugada(num)){
            System.out.println("Copia não esta alugada");
            return;
        }
        copias.replace(num,true,false);
    }

    public void exibeCopiasNaoAlugadas(String serial){
        System.out.println("Unidades não alugadas");
        for(Map.Entry<Integer,Boolean> entry: copias.entrySet()){
            if(!entry.getValue()){
                System.out.println(serial+":"+entry.getKey());
            }
        }
    }

}
