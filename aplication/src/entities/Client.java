package entities;
import Product.ValidationDoc;
public class Client {
    private String name;
    private String cpf;

    public Client(String name, String cpf) {
        if (!ValidationDoc.validationCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
