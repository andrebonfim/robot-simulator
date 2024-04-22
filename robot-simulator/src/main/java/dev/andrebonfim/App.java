package dev.andrebonfim;

import dev.andrebonfim.code.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Esta classe serve como a entrada principal para o simulador de robô. Ela
 * oferece uma interface de linha de comando
 * para interagir com o simulador, permitindo que o usuário execute comandos
 * para controlar o robô ou obter informações
 * sobre o aplicativo.
 * <p>
 * Os comandos disponíveis incluem:
 * <ul>
 * <li>--author ou -a: Exibe o autor do programa.</li>
 * <li>--version ou -v: Exibe a versão do programa.</li>
 * <li>--help ou -h: Exibe a ajuda sobre como usar o programa.</li>
 * <li>--commands ou -c: Lista todos os comandos disponíveis para movimentação
 * do robô.</li>
 * <li>--move ou -m seguido por comandos: Executa uma sequência de comandos de
 * movimentação.</li>
 * </ul>
 * Além disso, o programa pode ser executado em um modo interativo onde comandos
 * podem ser digitados sequencialmente.
 * </p>
 * 
 * @author André Luis Bonfim
 * @version 2.0
 */
public class App {

    /**
     * Inicia o aplicativo. Dependendo dos argumentos passados, o aplicativo pode
     * responder informações ou
     * executar comandos de movimentação do robô.
     * 
     * @param args argumentos de linha de comando usados para controlar o programa.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            processCommandLineArguments(args);
        } else {
            runInteractiveMode();
        }
    }

    /**
     * Processa argumentos de linha de comando para executar ações específicas.
     * 
     * @param args argumentos de linha de comando fornecidos ao programa.
     */
    private static void processCommandLineArguments(String[] args) {
        String command = args[0].toLowerCase();
        switch (command) {
            case "--author":
            case "-a":
                System.out.println("Autor: André Luis Bonfim");
                break;
            case "--version":
            case "-v":
                System.out.println("Versão: 2.0");
                break;
            case "--help":
            case "-h":
                printHelp();
                break;
            case "--commands":
            case "-c":
                printSupportedCommands();
                break;
            case "--move":
            case "-m":
                RoboTransporte robo = new RoboTransporte();
                System.out.println("Execução com movimentos agendados:");
                if (args.length > 1) {
                    String[] movimentos = Arrays.copyOfRange(args, 1, args.length); // Exclui o primeiro argumento "-m"
                    robo.movimentosAgendados(movimentos);
                } else {
                    System.out.println("Nenhum comando de movimento fornecido após '--move'.");
                }
                break;
            default:
                System.out.println("Argumento não válido: " + args[0]);
                break;
        }
        System.exit(0);
    }

    /**
     * Exibe a ajuda sobre como usar o aplicativo, detalhando todos os comandos
     * disponíveis.
     */
    private static void printHelp() {
        System.out.println("Ajuda do Simulador de Robô:");
        System.out.println("\t--author, -a: Mostra informações do autor.");
        System.out.println("\t--version, -v: Mostra a versão do programa.");
        System.out.println("\t--help, -h: Mostra esta ajuda.");
        System.out.println("\t--commands, -c: Lista os comandos suportados pelo programa.");
        System.out.println("\t--move <commands>, -m <commands>: Executa uma sequência de movimentos.");
    }

    /**
     * Lista todos os comandos suportados pelo simulador de robô, facilitando a
     * interação do usuário com o programa.
     */
    private static void printSupportedCommands() {
        System.out.println("Comandos suportados:");
        System.out.println("\tw: move para cima");
        System.out.println("\ta: move para esquerda");
        System.out.println("\ts: move para baixo");
        System.out.println("\td: move para direita");
        System.out.println("\t0: sair da aplicação");
    }

    /**
     * Executa o modo interativo do simulador de robô, onde o usuário pode digitar
     * comandos para controlar o robô em tempo real.
     */
    private static void runInteractiveMode() {
        RoboTransporte robo = new RoboTransporte();
        System.out.println("Modo interativo. Digite comandos para mover o robô (w, a, s, d) ou '0' para sair:");
        try (Scanner scan = new Scanner(System.in)) {
            String tecla;
            boolean quit = false;
            while (!quit) {
                tecla = scan.next();
                if (tecla.charAt(0) == '0') {
                    quit = true;
                } else {
                    try {
                        robo.setOrientacao(tecla.charAt(0));
                        robo.printPos();
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Comando inválido: " + tecla);
                    }
                }
            }
        }
        System.out.println("Saindo do modo interativo.");
    }
}
