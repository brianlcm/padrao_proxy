import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente {
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public Cliente(int id) {
        this.id = id;
        Cliente objeto = BD.getCliente(id);
        this.nome = objeto.nome;
        this.email = objeto.email;
        this.senha = objeto.senha;
    }

    public Cliente(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.email);
    }

    @Override
    public String obterSenha(Administrador administrador) {
        return this.senha;
    }

}
