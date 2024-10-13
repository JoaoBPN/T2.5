package Principal;

import Atores.Locadora;
import Modelos.Midias.*;


import java.math.BigDecimal;
import java.util.*;

public class Principal {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Locadora locadora = new Locadora();

    public static void main(String[] args){
        System.out.println("Bem-vindo");
        switchPrincipal();
    }

    private static int menuPrincipal(){

        System.out.println("""
                Selecione uma opção:
                1 - Cadastrar mídia
                2 - Remover mídia
                3 - Adicionar cópia
                4 - Remover cópia
                5 - Busca por serial
                6 - Listar mídias por categoria
                7 - Listar mídias por participante
                8 - Alugar mídia
                9 - Alterar valor do aluguel de uma mídia
                0 - Encerrar aplicação""");

        var opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static void switchPrincipal(){
        var opcao = -1;
        while(opcao != 0){
            opcao = menuPrincipal();
            switch(opcao){
                case 1:
                    cadastraMidia();
                    break;
                case 2:
                    removeMidia();
                    break;
                case 3:
                    adicionaCopia();
                    break;
                case 4:
                    removeCopia();
                    break;
                case 5:
                    buscaPorSerial();
                    break;
                case 6:
                    listagemPorCategoria();
                    break;
                case 7:
                    listagemPorParticipante();
                    break;
                case 8:
                    alugaMidia();
                    break;
                case 9:
                    alteraValorAluguelMidia();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        }
    }

    // switch principal caso 1
    private static void cadastraMidia(){
        var classe = getMidiaClass();

        if(classe == null) return;

        Midia midia = null;
        if (classe.equals(CD.class)) midia = cadastraCD();

        if (MidiaVisual.class.isAssignableFrom(classe)) {
            midia = cadastraMidiaVisual(classe);
        }

        if(midia == null) return;

        System.out.print("Informe o numero de copias a cadastrar ou precione enter para pular: ");
        var numeroDeCopias = scanner.nextLine();

        System.out.print("Informe o valor de aluguel da mídia ou precione enter para pular: ");
        var precoAluguel = scanner.nextLine();

        adicionaMidia(midia,numeroDeCopias,precoAluguel);
    }

    // switch principal caso 2
    private static void removeMidia(){
        System.out.println("Informe o serial da mídia a ser removida");
        var serial = scanner.nextLine();

        locadora.removeMidia(serial);
    }

    // switch principal caso 3
    private static void adicionaCopia(){
        System.out.print("Informe o serial da mídia: ");
        var serial = scanner.nextLine();

        System.out.print("Informe a quantidade de cópias a serem adicionadas: ");
        var quantidadeDeCopias = scanner.nextInt();
        scanner.next();

        locadora.adicionaCopias(serial,quantidadeDeCopias);
    }

    // switch principal caso 4
    private static void removeCopia(){
        System.out.print("Informe o serial da mídia");
        var serial = scanner.nextLine();
    }

    // switch principal caso 5
    private static void buscaPorSerial(){
        System.out.print("Digite o serial da mídia: ");
        var serial = scanner.nextLine();

        locadora.buscaMidia(serial);
    }

    //switch principal caso 6
    private static void listagemPorCategoria(){
        var classe = getMidiaClass();
        if(classe == null) return;
        locadora.buscaMidia(classe);
    }

    // switch principal caso 7
    private static void listagemPorParticipante(){
        System.out.println("Digite o nome do participante: ");

        var participante = scanner.nextLine();

        locadora.buscaMidia(participante,true);
    }

    // switch principal caso 8
    private static void alugaMidia(){
        System.out.print("Informe o serial da mídia: ");
        var serial = scanner.nextLine();

        System.out.print("Digite o número da cópia para alugar uma específica ou precione enter para pegar qualquer uma: ");
        var textoNumCopia = scanner.nextLine();

        if(textoNumCopia.isEmpty()){
            locadora.alugaCopia(serial);
            return;
        }

        var numCopia = Integer.parseInt(textoNumCopia);

        locadora.alugaCopia(serial,numCopia);
    }

    // switch principal caso 9
    private static void alteraValorAluguelMidia(){
        System.out.print("Informe o serial da mídia: ");
        var serial = scanner.nextLine();

        System.out.print("Informe o novo valor do aluguel: ");
        var novoAluguel = scanner.nextLine();

        locadora.alteraAluguel(serial,new BigDecimal(novoAluguel));
    }

    private static Class<? extends Midia> getMidiaClass(){
        System.out.println("""
                Selecione uma categoria:
                1 - CD
                2 - DVD
                3 - VHS
                0 - Cancelar operação""");

        var opcao = scanner.nextInt();
        scanner.nextLine();

        return switch (opcao) {
            case 1 -> CD.class;
            case 2 -> DVD.class;
            case 3 -> VHS.class;
            case 0 -> {
                System.out.println("Encerrando operação");
                yield null;
            }
            default -> {
                System.out.println("Opção invalida");
                yield null;
            }
        };
    }

    private static Midia cadastraCD(){
        System.out.print("Informe o nome do álbum: ");
        var nomeAlbum = scanner.nextLine();

        System.out.print("Informe o gênero musical: ");
        var generoMusical = scanner.nextLine();

        System.out.print("Informe o ano de produção: ");
        var anoDeProducao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o cantor principal: ");
        var cantorPrincipal = scanner.nextLine();

        System.out.print("Informe o número de faixas: ");
        var numeroDeFaixas = scanner.nextInt();
        scanner.nextLine();

        return new CD(nomeAlbum,generoMusical,anoDeProducao,cantorPrincipal,numeroDeFaixas);
    }

    private static Midia cadastraMidiaVisual(Class<? extends Midia> classe){

        if(alsoExstendsMidiaVisual(classe)) {
            System.out.print("Informe o título: ");
            var titulo = scanner.nextLine();

            System.out.print("Informe o gênero: ");
            var genero = scanner.nextLine();

            System.out.print("Informe o ano de publicação: ");
            var anoDePublicacao = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Informe o diretor: ");
            var diretor = scanner.nextLine();

            var atores = getListaAtores();

            System.out.print("Informe sua duração em minutos: ");
            var duracaoEmMinutos = scanner.nextInt();
            scanner.nextLine();

            if (classe.equals(VHS.class))
                return new VHS(titulo, genero, anoDePublicacao, diretor, atores, duracaoEmMinutos);

            if (classe.equals(DVD.class)) {
                System.out.print("Informe a classificação etária: ");
                var classificacaoEtaria = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Informe a região: ");
                var regiao = scanner.nextLine();

                return new DVD(titulo, genero, anoDePublicacao, diretor, atores, duracaoEmMinutos, classificacaoEtaria, regiao);
            }
        }

        return null;
    }

    private static Set<String> getListaAtores(){
        Set<String> atores = new HashSet<>();

        System.out.print("Precione enter após informar o nome de cada ator, para encerrar precione enter sem informar nome algum: ");

        while(true){
            var ator = scanner.nextLine();
            if(ator.isEmpty()){
                break;
            }
            atores.add(ator);
        }

        return atores;
    }

    private static boolean alsoExstendsMidiaVisual(Class<? extends Midia> classe){
        return MidiaVisual.class.isAssignableFrom(classe);
    }

    private static void adicionaMidia(Midia midia, String numeroDeCopias, String precoAluguel){

        if(precoAluguel.isEmpty() && numeroDeCopias.isEmpty()){
            var serial = locadora.adicionaMidia(midia);
            System.out.println(serial);
            return;
        }

        var quantidadeDeCopias = Integer.parseInt(numeroDeCopias);

        if(precoAluguel.isEmpty()){
            var serial = locadora.adicionaMidia(midia,quantidadeDeCopias);
            System.out.println(serial);
            return;
        }

        var valorDoAluguel = new BigDecimal(precoAluguel);

        if(numeroDeCopias.isEmpty()) {
            var serial = locadora.adicionaMidia(midia,valorDoAluguel);
            System.out.println(serial);
            return;
        }

        var serial = locadora.adicionaMidia(midia,quantidadeDeCopias,valorDoAluguel);
        System.out.println(serial);

    }

}
