package capgov.coppetec.com.br.dia1seminario.model;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable{

    public static final String TABLE = "pessoa";

    public static final String KEY_ID = "id";
    public static final String KEY_NOME = "nome";
    public static final String KEY_SENHA = "senha";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_DATA = "data";
    public static final String KEY_TELEFONE = "telefone";
    public static final String KEY_SEXO = "sexo";

    private String nome;
    private String senha;
    private String email;
    private Date data;
    private String telefone;
    private String sexo;

    public Pessoa() {
    }

    public Pessoa(String nome, String senha, String email, Date data, String telefone, String sexo) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.data = data;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
