import java.util.HashMap;
import java.util.Map;

public class Locadora {

    private String nome;
    private final Map<String,Midia> midias = new HashMap<>();
    private final Sequenciador sequenciadorLocadora = new Sequenciador();

    public Locadora(String nome){
        setNome(nome);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public int novoId(){
        return sequenciadorLocadora.getNewId();
    }

    public void adicionaMidia(String serial,Midia midia){
        if(midias.size() < 200) {
            midias.put(serial, midia);
            return;
        }

        System.out.println("Impossível adicionar mais mídias, o limite de 200 mídias distintas foi atingido");
    }

    public void removeMidia(String serial){
        if(midias.containsKey(serial)){
            midias.remove(serial);
            System.out.println("Mídia removida com sucesso");
            return;
        }
        System.out.println("Mídia não encontrada, confirme o serial e tente novamente");
    }

    public void listaMidiaPorTipo(String tipo){
        tipo = tipo.toLowerCase();

        for (Map.Entry<String, Midia> entry : midias.entrySet()) {
            Midia midia = entry.getValue();
            if (midia instanceof CD && tipo.equals("cd")) {
                System.out.println(midia);
                System.out.println("Serial: "+entry.getKey());
            }
            if(midia instanceof DVD && tipo.equals("dvd")){
                System.out.println(midia);
                System.out.println("Serial: "+entry.getKey());
            }
            if(midia instanceof VHS && tipo.equals("vhs")){
                System.out.println(midia);
                System.out.println("Serial: "+entry.getKey());
            }
            // não adicionei a impressão do serial aqui, já que o tipo informado pode estar errado
        }
    }

    public void listaMidiaPorParticipante(String participante){
        for (Map.Entry<String, Midia> entry : midias.entrySet()) {
            Midia midia = entry.getValue();
            if(midia.participanteNaMidia(participante)){
                System.out.println(midia);
                System.out.println("Serial: "+entry.getKey());
            }
        }
    }

    public void exibeMidiaPorSerial(String serial){
        if(midias.containsKey(serial)) {
            midias.get(serial).exibeCopiasNaoAlugadas(serial);
            return;
        }
        System.out.println("Serial não encontrado");
    }

    public void retornaCopia(String entrada){
        String[] partes = entrada.split(":");
        String serial = partes[0];
        int unidade = Integer.parseInt(partes[1]);

        if(midias.containsKey(serial)) {
            midias.get(serial).devolveCopia(unidade);
            System.out.println("Mídia retornada com sucesso");
            return;
        }

        System.out.println("Mídia não identificada, não foi possível retorna-la");
    }

    public void alugaCopia(String entrada){
        String[] partes = entrada.split(":");
        String serial = partes[0];
        int unidade = Integer.parseInt(partes[1]);

        if(midias.containsKey(serial)) {
            midias.get(serial).alugaCopia(unidade);
            System.out.println("Mídia alugada com sucesso");
            return;
        }

        System.out.println("Mídia não identificada, não foi possível aluga-la");
    }

    public void adicionaCopias(String serial,int quantidadeDeCopias){
        if(midias.containsKey(serial)) {
            midias.get(serial).adicionaCopias(quantidadeDeCopias);
            return;
        }
        System.out.println("Serial não encontrado");
    }


}
