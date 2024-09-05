package Product;

public class ValidationDoc {
		//-------------------método para validação de cpf-----------------------
	    public static boolean validationCPF(String cpf) {
	        // Remover caracteres não numéricos
	        cpf = cpf.replaceAll("[^\\d]", "");

	        // Verifica se o CPF tem 11 dígitos
	        if (cpf.length() != 11) {
	            return false;
	        }

	        // Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
	        if (cpf.matches("(\\d)\\1{10}")) {
	            return false;
	        }

	        // Cálculo do primeiro dígito verificador
	        int soma = 0;
	        for (int i = 0; i < 9; i++) {
	            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	        }

	        int primeiroDigitoVerificador = 11 - (soma % 11);
	        if (primeiroDigitoVerificador > 9) {
	            primeiroDigitoVerificador = 0;
	        }

	        // Verifica o primeiro dígito
	        if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
	            return false;
	        }

	        // Cálculo do segundo dígito verificador
	        soma = 0;
	        for (int i = 0; i < 10; i++) {
	            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	        }

	        int segundoDigitoVerificador = 11 - (soma % 11);
	        if (segundoDigitoVerificador > 9) {
	            segundoDigitoVerificador = 0;
	        }

	        // Verifica o segundo dígito
	        return segundoDigitoVerificador == Character.getNumericValue(cpf.charAt(10));
	    }



	   //------------------método para validação de cnpj-----------------------------

	    public static boolean validationCNPJ(String cnpj) {
	        // Remover caracteres não numéricos
	        cnpj = cnpj.replaceAll("[^\\d]", "");

	        // Verifica se o CNPJ tem 14 dígitos
	        if (cnpj.length() != 14) {
	            return false;
	        }

	        // Verifica se todos os dígitos são iguais (CNPJ inválido)
	        if (cnpj.matches("(\\d)\\1{13}")) {
	            return false;
	        }

	        // Cálculo do primeiro dígito verificador
	        int[] pesosPrimeiro = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	        int soma = 0;
	        for (int i = 0; i < 12; i++) {
	            soma += Character.getNumericValue(cnpj.charAt(i)) * pesosPrimeiro[i];
	        }

	        int primeiroDigitoVerificador = 11 - (soma % 11);
	        if (primeiroDigitoVerificador >= 10) {
	            primeiroDigitoVerificador = 0;
	        }

	        if (primeiroDigitoVerificador != Character.getNumericValue(cnpj.charAt(12))) {
	            return false;
	        }

	        // Cálculo do segundo dígito verificador
	        int[] pesosSegundo = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	        soma = 0;
	        for (int i = 0; i < 13; i++) {
	            soma += Character.getNumericValue(cnpj.charAt(i)) * pesosSegundo[i];
	        }

	        int segundoDigitoVerificador = 11 - (soma % 11);
	        if (segundoDigitoVerificador >= 10) {
	            segundoDigitoVerificador = 0;
	        }

	        return segundoDigitoVerificador == Character.getNumericValue(cnpj.charAt(13));
	    }

}


