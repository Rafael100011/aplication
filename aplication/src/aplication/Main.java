package aplication;

import entities.Client;
import entities.Enterprise;
import Product.Transaction;

public class Main {
	public static void main(String[] args) {
		String cnpj = "59291534084328";
		String nomeEmpresa = "loja do rafael";
		Enterprise enterprise = new Enterprise(nomeEmpresa, cnpj, 2.0);
		Client client = new Client("João da Silva", "70131179608");

		Transaction deposito = new Transaction(enterprise, client, 1000.0, "deposito");
		deposito.executar(); // Executa o depósito

		Transaction saque = new Transaction(enterprise, client, 500.0, "saque");
		saque.executar(); // Executa o saque
	}
	//testando commit
	
}
