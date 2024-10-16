import java.util.*;

//Classe 1 é a nossa view.
public class Classe1 {
    public static void main ( String[] args) {

                            // (PREFERI DOMUMENTER OS CÓDIGOS AO INVÉS DE APAGAR PARA FINS DIDATICOS POSTERIOES)

        //Scanner scnInputUsuario = new Scanner(System.in); // Cria o imput de entrada via terminal do usuário.
        //System.out.println("Olá! Bem vindo. Digite algo e tecle: \"Enter\"");
        //String strInputUsuario = scnInputUsuario.nextLine(); // Comando para o usuário digitar algo no terminal(nextLine é para coletar palavras).
        //System.out.println("Você digitou:" + strInputUsuario); // Mensagem exibida depois do usuário ter digitado.
        //scnInputUsuario.close(); // Fecha o programa.

        Scanner scnInputUsuario = new Scanner(System.in); // Cria o imput de entrada via terminal do usuário.
        System.out.println("Olá! Bem vindo a calculadora de Java. Digite o primeiro número a ser calculado e tecle: \"Enter\""); //Exibe a primeira interação com o usuario pedindo para digitar o primeiro número a ser somado. 
        int intInputUsuario1 = scnInputUsuario.nextInt(); // Comando para o usuário digitar o primeiro número no terminal (nextInt é para coletar números).
        System.out.println("Digite o segundo número a ser calculado e tecle: \"Enter\""); //Exibe a segunda interação com o usuario pedindo para digitar o segundo número a ser somado. 
        int intInputUsuario2 = scnInputUsuario.nextInt(); 
        System.out.println("Digite o número da opção desejada e tecle: \"Enter\"");
        String[] opcoes = Classe2.mostrarOpcoes();
        for (int count = 0; count < opcoes.length; count++) {
            System.out.println(count + " - " + opcoes[count]);
        }
        int opcaoEscolhida = scnInputUsuario.nextInt(); // Variável coleta a opçãop escolhida.
        System.out.println("O resultado da "+ opcoes[opcaoEscolhida] + " é:" + Classe2.resultado(intInputUsuario1,intInputUsuario2,opcaoEscolhida)); // Teceira interação com o usuátio: Mensagemexibe o resultado.
        scnInputUsuario.close(); // Fecha o programa.
    }
}