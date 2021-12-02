package br.edu.iftm.carrinhocompras;

import java.util.Scanner;

public class Principal {

    private ProcessoCompra pc;
    private Scanner texto;

    public Principal(){
        pc = new ProcessoCompra();
        texto = new Scanner(System.in);
    }

    public void iniciar(){
        int opcao = 0;
        String nome = "";
        do {
            System.out.println(" --- Menu ---");
            System.out.println("1 - Cadatrar Cliente");
            System.out.println("2 - Cadatrar Produto");
            System.out.println("3 - Buscar Cliente");
            System.out.println("4 - Adicionar Produto");
            System.out.println("5 - Excluir Produto");
            System.out.println("6 - Nota Fiscal");
            System.out.println("0 - Sair");
            System.out.print("Digite a opcao: ");
            opcao = texto.nextInt();
            texto.nextLine();
            switch (opcao) {
                case 1:
                    this.pc.cadastroCliente();
                    break;
                
                    case 2:
                    this.pc.cadastroProduto();
                    break;

                    case 3:
                    System.out.print("\nDigite o nome do cliente: ");                    
                    nome = this.texto.nextLine();
                    Cliente cl = this.pc.buscarCliente(nome);
                    if(cl != null){
                        System.out.println("Cliente " + cl.getNome() + " foi encontrado!" );
                    } else{
                        System.out.println("Cliente não encontrado!");
                    }                   
                    break;

                    case 4:
                    this.pc.adicionaProduto();
                    break;

                    case 5:
                    this.pc.excluirProduto();
                    break;

                    case 6:
                    this.pc.geraNotaFiscal();
                    break;

                    case 0:
                    System.out.println("Programa finalizado!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
        

    }
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciar();
    }
}