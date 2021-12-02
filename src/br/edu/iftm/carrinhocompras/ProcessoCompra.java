package br.edu.iftm.carrinhocompras;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcessoCompra {

    private int totalDeContas;
    //private int totalDeProdutos;
    private ArrayList<Cliente> vetorCliente;
    private ArrayList<Produto> vetorProduto;
    private Scanner texto;

    public ProcessoCompra() {
        this.totalDeContas = 0;
        this.vetorCliente = new ArrayList<Cliente>();
        this.vetorProduto = new ArrayList<Produto>();
        this.texto = new Scanner(System.in);
    }

    public void cadastroCliente() {

        System.out.print("\nDigite o nome do cliente: ");
        String nome = texto.nextLine();
        System.out.print("\n Digite o cpf do cliente: ");
        String cpf = texto.nextLine();
        System.out.print("\nDigite o e-mail do cliente: ");
        String email = texto.nextLine();
        System.out.print("\nDigite o endereco do cliente: ");
        String endereco = texto.nextLine();
        Cliente cl = new Cliente(this.totalDeContas + 1, nome, cpf, email, endereco);
        this.vetorCliente.add(cl);
        // this.totalDeContas = this.totalDeConta + 1;
        this.totalDeContas++;

    }

    public void cadastroProduto() {
        System.out.print("\nDigite o nome do Produto: ");
        String nome = texto.nextLine();        
        System.out.print("\nDigite o preço do Produto: ");
        float preco = texto.nextFloat();
        texto.nextLine();
        Produto p = new Produto(nome, preco);
        this.vetorProduto.add(p);        
    }

    public Cliente buscarCliente(String nome) {
        for (int i = 0; i < this.vetorCliente.size(); i++) {
            if (this.vetorCliente.get(i).getNome().equals(nome)) {
                return this.vetorCliente.get(i);
            }
        }
        return null;
    }

    public Produto buscarProduto(String nome) {
        for (int i = 0; i < this.vetorProduto.size(); i++) {
            if (this.vetorProduto.get(i).getNome().equals(nome)) {
                return this.vetorProduto.get(i);
            }
        }
        return null;
    }

    public void adicionaProduto() {
        System.out.print("\nDigite o nome do cliente: ");
        String nome = texto.nextLine();
        Cliente cl = this.buscarCliente(nome);
        if (cl != null) {
            System.out.print("\nDigite o nome do Produto: ");
            String nomeP = texto.nextLine();
            Produto p = this.buscarProduto(nomeP);
            System.out.print("\nDigeite a quantidade: ");
            int quantidade = texto.nextInt();
            if (p != null) {
                ItemCarrinho itemCarrinho = new ItemCarrinho(p, quantidade);
                cl.adicionaItem(itemCarrinho);
            } else {
                System.out.println("Produto não foi encontrado!");
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }

    }

    public void excluirProduto() {
        System.out.print("\nDigite o nome do cliente: ");
        String nome = texto.nextLine();
        Cliente cl = this.buscarCliente(nome);
        if (cl != null) {
            cl.excluirItem();
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void geraNotaFiscal() {
        System.out.print("\nDigite o nome do cliente: ");
        String nome = texto.nextLine();
        Cliente cl = this.buscarCliente(nome);
        if (cl != null) {
            cl.geraNotaFiscal();
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public int getTotalDeContas() {
        return totalDeContas;
    }

    public void setTotalDeContas(int totalDeContas) {
        this.totalDeContas = totalDeContas;
    }   

    public ArrayList<Cliente> getVetorCliente() {
        return vetorCliente;
    }

    public void setVetorCliente(ArrayList<Cliente> vetorCliente) {
        this.vetorCliente = vetorCliente;
    }

    public ArrayList<Produto> getVetorProduto() {
        return vetorProduto;
    }

    public void setVetorProduto(ArrayList<Produto> vetorProduto) {
        this.vetorProduto = vetorProduto;
    }    

}