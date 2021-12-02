package br.edu.iftm.carrinhocompras;

import java.util.ArrayList;

public class Cliente {

    private int qtdCarrinho;
    private int numero;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private ArrayList<ItemCarrinho> carrinhoDeCompras;

    public Cliente(int numero, String nome, String cpf, String email, String endereco) {

        this.qtdCarrinho = 0;
        this.numero = numero;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.carrinhoDeCompras = new ArrayList<ItemCarrinho>();
    }

    public void adicionaItem(ItemCarrinho p) {
        if (this.qtdCarrinho < 10) {
            this.carrinhoDeCompras.add(p);
            this.qtdCarrinho++;
        } else {
            System.out.printf("\nO carrinho de compras do cliente %s está cheia", this.nome);
        }
    }

    public void excluirItem() {
        this.carrinhoDeCompras.remove(this.carrinhoDeCompras.size()-1);
    }

    public void geraNotaFiscal() {
        float totalNota = 0f;
        StringBuilder msg = new StringBuilder();
        msg.append("\n---Nota Fiscal---\n");
        msg.append("\nNome: " + this.nome + " CPF: " + this.cpf);
        msg.append("\n\nProduto ---- Qtd --- Valor x Qtd\n\n");
        for (int i = 0; i < carrinhoDeCompras.size(); i++) {
            if (carrinhoDeCompras.get(i) != null) {
                msg.append("\n" + carrinhoDeCompras.get(i).getProduto().getNome() + " --- " + carrinhoDeCompras.get(i).getQuantidade()
                        + " --- " + carrinhoDeCompras.get(i).valorTotal());
                totalNota += carrinhoDeCompras.get(i).valorTotal();
            }

        }
        msg.append("\n\nValor total: " + totalNota);
        System.out.println(msg.toString());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    

    public ArrayList<ItemCarrinho> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(ArrayList<ItemCarrinho> carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdCarrinho() {
        return qtdCarrinho;
    }

    public void setQtdCarrinho(int qtdCarrinho) {
        this.qtdCarrinho = qtdCarrinho;
    }

}