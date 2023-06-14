package br.com.bruno.carrinhocompras.principal;

import br.com.bruno.carrinhocompras.modelos.CartaoCredito;
import br.com.bruno.carrinhocompras.modelos.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();
        CartaoCredito cartao = new CartaoCredito(limite);

        int sair = 1;
        while (sair != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = leitura.next().toUpperCase();

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        Collections.sort(cartao.getCompras());
        System.out.println("*******************\nCompras realizadas:");
        for (Compra c : cartao.getCompras()) {
            System.out.printf("%s - R$ %.2f\n" , c.getDescricao(), c.getValor());
        }
        System.out.printf("*******************\nSaldo do cartão: %.2f", cartao.getSaldo());
    }
}
