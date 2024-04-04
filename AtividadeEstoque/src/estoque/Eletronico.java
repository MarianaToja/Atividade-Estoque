package estoque;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Eletronico extends Produto {
    private String marca;
    private String modelo;
 
    public Eletronico(int codigo, String nome, String descricao, int quantidade, double preco, String marca, String modelo) {
        super(codigo, nome, descricao, quantidade, preco);
        this.marca = marca;
        this.modelo = modelo;
    }
 
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    public String getModelo() {
        return modelo;
    }
 
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
 
    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + "\nMarca: " + marca + "\nModelo: " + modelo;
    }
 
    @Override
    public void gravaEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write("ELETRÔNICO"+"\nCódigo: " + getCodigo() + "\nNome: " + getNome() + "\nDescrição: " + getDescricao()
                    + "\nQuantidade: " + getQuantidade() + "\nPreço: " + getPreco() + "\nMarca: " + marca
                    + "\nModelo: " + modelo + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void cadastrarEletronico() {
    	Scanner sc = new Scanner(System.in);
    	int codigo =0;
    	String nome = "";
    	String descricao= "";
    	int quantidade = 0;
    	double preco =0;
    	String marca = "";
    	String modelo = "";
    	do {
    		
        	
        	try {
        		 System.out.println("Informe o código do eletrônico (Apenas números)");
                 codigo = sc.nextInt();
                sc.nextLine(); 
         
                System.out.println("Informe o nome do eletrônico");
                nome = sc.nextLine();
         
                System.out.println("Informe a descrição do eletrônico");
                 descricao = sc.nextLine();
         
                System.out.println("Informe a quantidade em estoque (Apenas números)");
                 quantidade = sc.nextInt();
                sc.nextLine(); 
         
                System.out.println("Informe o preço unitário do eletrônico (Apenas números)");
                preco = sc.nextDouble();
                sc.nextLine(); 
         
                System.out.println("Informe a marca do eletrônico");
                 marca = sc.nextLine();
         
                System.out.println("Informe o modelo do eletrônico");
                 modelo = sc.nextLine();
        		
        	} catch(Exception e) {
          		 System.out.println("Os dados do eletrônico foram digitados de forma incorreta, Digite de acordo com o pedido");
           		 System.out.println();
           		break;
           		}
        	  Eletronico eletronico = new Eletronico(codigo, nome, descricao, quantidade, preco, marca, modelo);
              eletronico.gravaEstoque();
    	}while(false);
 
      
    }
}