import java.util.List;

public class ClienteProxy implements ICliente {
    private Cliente cliente;

    private Integer id;

    public ClienteProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.id);
        }
        return this.cliente.obterDadosPessoais();
    }

    @Override
    public String obterSenha(Administrador administrador) {
        if (!administrador.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.cliente == null) {
            this.cliente = new Cliente(this.id);
        }
        return this.cliente.obterSenha(administrador);
    }

}
