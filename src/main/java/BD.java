import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Cliente> clientes = new HashMap<>();

    public static Cliente getCliente(Integer id) {
        return clientes.get(id);
    }

    public static void addCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}
