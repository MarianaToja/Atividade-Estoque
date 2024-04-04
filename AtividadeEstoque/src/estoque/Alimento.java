package estoque;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Alimento extends Produto {
    private LocalDate dataValidade;
 
    public Alimento(int codigo, String nome, String descricao, int quantidade, double preco, LocalDate dataValidade) {
        super(codigo, nome, descricao, quantidade, preco);
        this.dataValidade = dataValidade;
    }
 
    public LocalDate getDataValidade() {
        return dataValidade;
    }
 
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
 
    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + "\nData de validade: " + dataValidade;
    }
 
    @Override
    public void gravaEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write("ALIMENTO"+"\nCódigo: " + getCodigo() + "\nNome: " + getNome() + "\nDescrição: " + getDescricao()
                    + "\nQuantidade: " + getQuantidade() + "\nPreço: " + getPreco() + "\nData de validade: "
                    + dataValidade + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void cadastrarAlimento() {
    	Scanner sc = new Scanner(System.in);
    	int ano =0;
    	int mes =0;
    	int dia =0;
    	int codigo =0;
    	String nome = "";
    	String descricao= "";
    	int quantidade = 0;
    	double preco =0;
    	
    	do {
    		
    	try {
    		 System.out.println("Informe o código do alimento (Apenas números)");
    	        codigo = sc.nextInt();
    	        sc.nextLine(); 
    	        
    	
        System.out.println("Informe o nome do alimento");
        nome = sc.nextLine();
 
        System.out.println("Informe a descrição do alimento");
         descricao = sc.nextLine();
 
        System.out.println("Informe a quantidade em estoque (em números)");
        quantidade = sc.nextInt();
        sc.nextLine(); 
 
        System.out.println("Informe o preço unitário do alimento (Valor númerico)");
        preco = sc.nextDouble();
        
 
            try {
                System.out.println("Informe o ano em que o alimento vence (Número do ano)");
                ano = sc.nextInt();
                if (ano <= 2023 || ano > 2040) {
                    throw new InputMismatchException();
                }
                System.out.println("Informe o mês do ano em que o alimento vence (Número do mês 1-12)");
                mes = sc.nextInt();
                    if (mes <= 00 || mes > 12) {
                        throw new InputMismatchException();
                    }
                    
                    System.out.println("Informe o dia do ano em que o alimento vence (Número do dia do mês 1-31)");
                     dia = sc.nextInt();
                    
                        if (dia <= 00 || dia > 31) {
                            throw new InputMismatchException();
                        } 
                         
            } catch (InputMismatchException e) {
                System.out.println("Digite uma data válida");
                sc.nextLine();
                break;
            }
            
        
    	} catch(Exception e) {
   		 System.out.println("Os dados do alimento foram digitados de forma incorreta, Digite de acordo com o pedido");
   		 System.out.println();
   		break;
   		}
    	
    	String dataValidadeStr = "";
    	if(mes < 9) {
    		 dataValidadeStr = ano+"-"+"0"+mes+"-"+dia;
    	}else {
    		 dataValidadeStr = ano+"-"+mes+"-"+dia;
    	}
    	  
         
		LocalDate dataValidade = LocalDate.parse(dataValidadeStr);
          Alimento alimento = new Alimento(codigo, nome, descricao, quantidade, preco, dataValidade);
          alimento.gravaEstoque();
          
    	}while(false);
    }
    
}