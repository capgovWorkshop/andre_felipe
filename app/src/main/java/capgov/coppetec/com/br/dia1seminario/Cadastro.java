package capgov.coppetec.com.br.dia1seminario;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AndréFelipe on 27/05/2015.
 */
public class Cadastro implements Serializable{

    private String nome;
    private String password;
    private String email;
    private Date data;
    private String phone;
    private String sex;

    public Cadastro() {
    }

    public Cadastro(String nome, String password, String email, Date data, String phone, String sex) {

        this.nome = nome;
        this.password = password;
        this.email = email;
        this.data = data;
        this.phone = phone;
        this.sex = sex;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
