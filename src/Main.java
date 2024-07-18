import java.util.List;

public class Main {

    static Locadora locadora = new Locadora("!!!");

    public static void main(String[] args) {
        consoleSwitch();
    }

    private static void consoleSwitch(){
        int opcao = 0;
        while(opcao != 3){
            opcao = console();
            switch (opcao){
                case 1:
                    administradorSwitch();
                    break;
                case 2:
                    clienteSwitch();
                    break;
                case 3:
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }
        }
    }

    private static int console(){
        System.out.println("Bem vindo a "+locadora.getNome());
        System.out.println("""
                Selecione uma opção:
                1 - Operações de administrador
                2 - Operações de cliente
                3 - Encerrar aplicação
                """);

        return SuperScanner.getInteger();
    }

    private static void administradorSwitch(){
        int opcao = 0;
        while(opcao != 5){
            opcao = menuAdministrador();
            switch (opcao){
                case 1:
                    cadastroSwitch();
                    break;
                case 2:
                    removeMidia();
                    break;
                case 3:
                    adicionaCopia();
                    break;
                case 4:
                    exibicaoSwitch();
                    break;
                case 5:
                    System.out.println("Voltando para o console...");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }
        }
    }

    private static int menuAdministrador(){
        System.out.println("""
                Selecione uma opção:
                1 - Cadastrar mídia
                2 - Remover mídia
                3 - Adicionar cópias
                4 - Listar mídias
                5 - Voltar para console
                """);

        return SuperScanner.getInteger();
    }

    private static void clienteSwitch(){
        int opcao = 0;
        while (opcao != 4){
            opcao = menuCliente();
            switch (opcao){
                case 1:
                    exibicaoSwitch();
                    break;
                case 2:
                    alugaMidia();
                    break;
                case 3:
                    retornaMidia();
                    break;
                case 4:
                    System.out.println("Voltando para o console...");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }
        }
    }

    private static int menuCliente(){
        System.out.println("""
                Selecione uma opção
                1 - Listar mídias
                2 - Alugar mídia
                3 - Retornar mídia
                4 - Voltar para o console
                """);

        return SuperScanner.getInteger();
    }

    private static void cadastroSwitch(){
        int opcao = 0;

        while(opcao != 4){
            opcao = cadastroMenu();
            switch (opcao){
                case 1:
                    cadastroCD();
                    break;
                case 2:
                    cadastroMidiaVisual(true);
                    break;
                case 3:
                    cadastroMidiaVisual(false);
                    break;
                case 4:
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Opção invalida tente novamente");
                    break;
            }
        }
    }

    private static int cadastroMenu(){
        System.out.println("""
                Escolha uma mídia para realizar o cadastro:
                1 - CD
                2 - DVD
                3 - VHS
                4 - Retornar
                """);
        return SuperScanner.getInteger();
    }

    private static void exibicaoSwitch(){
        int opcao = 0;

        while (opcao != 4){

            opcao = exibicaoMenu();

            switch (opcao){
                case 1:
                    buscaPorTipo();
                    break;
                case 2:
                    buscaPorParticipante();
                    break;
                case 3:
                    buscaPorSerial();
                    break;
                case 4:
                    System.out.println("Encerrando a busca...");
                    break;
                default:
                    System.out.println("Operação invalida");
                    break;
            }
        }
    }

    private static int exibicaoMenu(){
        System.out.println(""" 
                Selecione uma operação:
                1 - Listar por tipo de mídia
                2 - Lista por participante
                3 - Lista copias disponiveis por identificador
                4 - Encerrar a busca
                """);

        return SuperScanner.getInteger();
    }

    private static void buscaPorTipo(){
        System.out.println("Digite o tipo da mídia");
        String tipo = SuperScanner.getString();
        locadora.listaMidiaPorTipo(tipo);
    }

    private static void buscaPorParticipante(){
        System.out.println("Digite o nome do participante");
        String participante = SuperScanner.getString();
        locadora.listaMidiaPorParticipante(participante);
    }

    private static void buscaPorSerial(){
        System.out.println("Digite o serial");
        String serial = SuperScanner.getString();
        locadora.exibeMidiaPorSerial(serial);
    }

    private static void removeMidia(){
        System.out.println("Digite o serial");
        String serial = SuperScanner.getString();
        locadora.removeMidia(serial);
    }

    private static void adicionaCopia(){
        System.out.println("Digite o serial");
        String serial = SuperScanner.getString();
        System.out.println("Digite a quantidade de cópias");
        int quantidadeDeCopias = SuperScanner.getInteger();
        locadora.adicionaCopias(serial,quantidadeDeCopias);
    }

    private static void alugaMidia(){
        System.out.println("Digite o serial");
        String serial = SuperScanner.getString();
        locadora.alugaCopia(serial);
    }

    private static void retornaMidia(){
        System.out.println("Digite o serial");
        String serial = SuperScanner.getString();
        locadora.retornaCopia(serial);
    }

    private static void cadastroMidiaVisual(boolean DVD){
        System.out.println("Digite o título");
        String nome = SuperScanner.getString();
        System.out.println("Digite o gênero");
        String genero = SuperScanner.getString();
        System.out.println("Digite o ano de publicação");
        int ano = SuperScanner.getInteger();
        System.out.println("Digite o nome do diretor do DVD");
        String diretor = SuperScanner.getString();
        System.out.println("Digite o nome dos atores, um por vez e nulo para encerrar");
        List<String> atores = SuperScanner.getStringList();
        System.out.println("Digite a duração em minutos");
        int duracaoEmMinutos = SuperScanner.getInteger();
        System.out.println("Digite o preço do aluguel diário");
        double aluguelDiario = SuperScanner.getDouble();
        System.out.println();
        System.out.println("Digite a quantidade de copias iniciais");
        int quantidadeDeCopias = SuperScanner.getInteger();
        String serial = nome.charAt(0) + genero.substring(0,1) + ano + locadora.novoId();
        if(DVD){
            System.out.println("Digite a idade minima para consumir o DVD");
            int classificacaoEtaria = SuperScanner.getInteger();
            System.out.println("Digite a região");
            String regiao = SuperScanner.getString();
            locadora.adicionaMidia(serial,new DVD(nome,genero,ano,aluguelDiario,quantidadeDeCopias,atores,duracaoEmMinutos,diretor,classificacaoEtaria,regiao));
            return;
        }
        System.out.println("Por padrão as mídias são adicionadas como já rebobinadas, se elas não estiverem digite n, caso contrário apenes precione enter");
        String validacao = SuperScanner.getString();
        boolean rebobinado = !validacao.equals("n");
        locadora.adicionaMidia(serial,new VHS(nome,genero,ano,aluguelDiario,quantidadeDeCopias,atores,duracaoEmMinutos,diretor,rebobinado));
    }

    private static void cadastroCD(){
        System.out.println("Digite o nome do álbum");
        String nome = SuperScanner.getString();
        System.out.println("Digite o gênero musical");
        String genero = SuperScanner.getString();
        System.out.println("Digite o ano de produção");
        int ano = SuperScanner.getInteger();
        System.out.println("Digite o nome do cantor principal");
        String cantor = SuperScanner.getString();
        System.out.println("Digite o numero de faixas");
        int numeroDeFaixas = SuperScanner.getInteger();
        System.out.println("Digite o preço do aluguel diário");
        double aluguelDiario = SuperScanner.getDouble();
        System.out.println("Digite a quantidade de copias iniciais");
        int quantidadeDeCopias = SuperScanner.getInteger();
        String serial = nome.charAt(0) + genero.substring(0,1) + ano + locadora.novoId();

        locadora.adicionaMidia(serial,new CD(nome,genero,ano,aluguelDiario,quantidadeDeCopias,cantor,numeroDeFaixas));
    }
}
