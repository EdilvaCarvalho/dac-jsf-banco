
package ifpb.ads.cliente.infra;

import ifpb.ads.cliente.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class ClientesJDBC implements Clientes{
    
    private Connection connection;
    
    public ClientesJDBC() {
        this.connection = Conexao.getConnection();
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clientes.add(dadosDoCliente(rs));
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    @Override
    public boolean salvar(Cliente cliente) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente(nome) VALUES(?)");
            ps.setString(1, cliente.getNome());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Cliente cliente) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM cliente WHERE id = ?");
            ps.setInt(1, cliente.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cliente SET nome = ? WHERE id = ?");
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private Cliente dadosDoCliente(ResultSet rs) throws SQLException{
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        return cliente;
    }
    
}
