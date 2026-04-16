package br.com.fiap.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    private String username;
    private String hashSenha;

    public Login(String username, String senha) {
        this.username = username;
        this.hashSenha = senha; //implementar hash da senha
    }

    public Login() {}

    public String getUsername() {
        return this.username;
    }

    public String getHashSenha() {
        return this.hashSenha;
    }

    /*public boolean autenticar(String senha) {
        String hash = gerarHash(senha);
        return hash.equals(this.hashSenha);
    }*/

    /*private String gerarHash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();

            for(byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);

                if(hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao gerar o hash da senha!");
        }
    }*/
}
