package estoque;

import java.util.Scanner;

public class Menu {
public static void cadastro() {

	Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
        System.out.println("Escolha uma opção:");
        System.out.println("1-Cadastrar produto");
        System.out.println("2-Cadastrar alimento");
        System.out.println("3-Cadastrar eletrônico");
        System.out.println("4-Ver Produtos do estoque");
        System.out.println("5-Sair");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
  Produto.cadastrarProduto();

                break;
            case 2:
   Alimento.cadastrarAlimento();  
   
                break;
            case 3:
   Eletronico.cadastrarEletronico();         
                break;
            case 4:
            	  String leitura = Produto.readFromFile("estoque.txt");
          		System.out.println("Conteúdo lido do arquivo: " + leitura);
          		break;
            case 5:
                continuar = false;
                break;
            default:
                System.out.println("Escolha uma opção válida");
        }
    }

    scanner.close();
}
}
