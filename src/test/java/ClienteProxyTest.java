import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {
    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente(1, "Antônio", "antonio.silvapr@gmail.com","senha321"));
        BD.addCliente(new Cliente(2, "Rosa", "rosa.maria21@hotmail.com","133645"));
    }

    @Test
    void deveRetornarDadosPessoaisCliente() {
        ClienteProxy cliente = new ClienteProxy(1);

        assertEquals(Arrays.asList("Antônio", "antonio.silvapr@gmail.com"), cliente.obterDadosPessoais());
    }

    @Test
    void deveRetonarSenhaCliente() {
        Administrador administrador = new Administrador("Carol", true);
        ClienteProxy cliente = new ClienteProxy(2);

        assertEquals("133645", cliente.obterSenha(administrador));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotaSenha() {
        try {
            Administrador administrador = new Administrador("Marcos", false);
            ClienteProxy cliente = new ClienteProxy(2);

            cliente.obterSenha(administrador);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }

}