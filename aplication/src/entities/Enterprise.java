package entities;

import Product.ValidationDoc;

public class Enterprise {
    private String name;
    private String cnpj;
    private static double balance;
    private static double taxSystem;

    public Enterprise(String name, String cnpj, double taxSystem) {
        if (!ValidationDoc.validationCNPJ(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        this.name = name;
        this.cnpj = cnpj;
        Enterprise.taxSystem = taxSystem;
        Enterprise.balance = 0.0;
    }

	public void addBalance(double value) {
        Enterprise.balance += value;
    }

    public boolean performSake(double value) {
        if (balance >= value) {
            balance -= (value + calculateTax(value));
            return true;
        }
        return false;
    }

    public double calculateTax(double value) {
        return value * (taxSystem / 100);
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getBalance() {
        return balance;
    }

    public double getTaxSystem() {
        return taxSystem;
    }
}

