
package ifpb.ads.cliente.infra;

import ifpb.ads.cliente.Cliente;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface Clientes {
    
    List<Cliente> listar();
    boolean salvar(Cliente cliente);
    boolean remover(Cliente cliente);
    boolean atualizar(Cliente cliente);
    
}
