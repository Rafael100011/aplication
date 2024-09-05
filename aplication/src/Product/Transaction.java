package Product;
import entities.Enterprise;
import entities.Client;
public class Transaction {
    private Client client;
    private double value;
    private String tipo; // Saque ou Depósito
    Enterprise enterprise1 = new Enterprise(tipo,tipo,value);

    
    public Transaction(Enterprise enterprise, Client client, double value, String tipo) {
        this.client = client;
        this.value = value;
        this.tipo = tipo;
    }

    public void executar() {
        if (tipo.equalsIgnoreCase("saque")) {
            if (enterprise1.performSake(value)) {
                enviarCallback();
                notificarCliente();
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else if (tipo.equalsIgnoreCase("deposito")) {
            enterprise1.addBalance(value);
            enviarCallback();
            notificarCliente();
        }
    }

    private void enviarCallback() {
        // Simular callback para empresa usando webhook.site
        System.out.println("Callback enviado para a empresa " + enterprise1.getCnpj());
        // Aqui você pode usar uma biblioteca como HttpURLConnection ou uma lib REST para simular
    }

    private void notificarCliente() {
        // Simular notificação para cliente
        System.out.println("Notificação enviada para o cliente " + client.getName());
    }
}

