import java.util.List;

public interface ICliente {
    List<String> obterDadosPessoais();
    String obterSenha(Administrador administrador);
}
