package ifpb.ads.cliente;

import ifpb.ads.cliente.infra.Clientes;
import ifpb.ads.cliente.infra.ClientesJDBC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/06/2017, 16:57:08
 */
public class ClienteService {

    //private List<Cliente> clientes = new ArrayList<>();
    private Clientes clientes = new ClientesJDBC();

    public void salvar(Cliente cliente) {
        //cliente.setNome("Oi, "+cliente.getNome());
//        cliente.setId(clientes.size() + 1);
//        this.clientes.add(cliente);
        clientes.salvar(cliente);
    }

    public void remover(Cliente cliente) {
//        this.clientes.remove(cliente);
        clientes.remover(cliente);
    }

    public void atualizar(Cliente cliente) {
//        for (Cliente cli : clientes) {
//            if (cli.getId() == cliente.getId()) {
//                cli.setNome(cliente.getNome());
//                break;
//            }
//        }
        clientes.atualizar(cliente);
    }

    public List<Cliente> todosOsClientes() {
        //return Arrays.asList(new Cliente("Kiko"), new Cliente("Chaves"));
//        return this.clientes;
        return clientes.listar();
    }
}
