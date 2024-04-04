package estoque;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
 
    public Produto(int codigo, String nome, String descricao, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }
 
    public int getCodigo() {
        return codigo;
    }
 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public int getQuantidade() {
        return quantidade;
    }
 
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 
    public double getPreco() {
        return preco;
    }
 
    public void setPreco(double preco) {
        this.preco = preco;
    }
 
    public String exibirDetalhes() {
        return "Código: " + codigo + "\nNome: " + nome + "\nDescrição: " + descricao
                + "\nQuantidade em estoque: " + quantidade + "\nPreço unitário: " + preco;
    }
 
    public void gravaEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write("PRODUTO GENÉRICO"+"\nCódigo: " + codigo + "\nNome: " + nome + "\nDescrição: " + descricao
                    + "\nQuantidade: " + quantidade + "\nPreço: " + preco + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public static void cadastrarProduto() {
    	Scanner sc = new Scanner(System.in);
    	int codigo =0;
    	String nome = "";
    	String descricao= "";
    	int quantidade = 0;
    	double preco =0;
    	
    	do {
    	try {
        System.out.println("Informe o código do produto");
         codigo = sc.nextInt();
        sc.nextLine(); 
 
        System.out.println("Informe o nome do produto");
        nome = sc.nextLine();
 
        System.out.println("Informe a descrição do produto");
         descricao = sc.nextLine();
 
        System.out.println("Informe a quantidade em estoque");
         quantidade = sc.nextInt();
        sc.nextLine(); 
        
        System.out.println("Informe o preço unitário do produto");
        preco = sc.nextDouble();
        
    	} catch(Exception e) {
      		 System.out.println("Os dados do alimento foram digitados de forma incorreta, Digite de acordo com o pedido");
      		 System.out.println();
      		break;
      		}
    	Produto produto = new Produto(codigo, nome, descricao, quantidade, preco);
        produto.gravaEstoque();
    }while(false);
        
    }

	public static  String readFromFile(String fileName) {
		
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line;
		
			while ((line = reader.readLine())!= null) {
				
				content.append(line).append("\n");
			}
		}catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: "+ e.getMessage());
		}
		return content.toString();
	}
}
