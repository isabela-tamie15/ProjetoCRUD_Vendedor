package model.dao;

import util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import model.Vendedor;

public class VendedorDAO {
 
    // CALCULAR
    public void calcularComissaoVendas(Vendedor vend) {
        vend.setComissaoVendas(vend.getPorcentagemComissao() * vend.getTotalVendasMensal());
    }
    
    public void definirPremioMeta(Vendedor vend) {
        if (vend.getComissaoVendas() >= 10000) {
            vend.setPremioMeta(1000);
        } else {
            vend.setPremioMeta(0);
        }
    }
    
    public void calcularSalarioFinal(Vendedor vend) {
        vend.setSalarioFinal(vend.getComissaoVendas() + vend.getPremioMeta() + vend.getSalarioLiquido());
    }
    
    
    // CRUDs
    public void inserirVendedor(Vendedor vend) throws SQLException, ClassNotFoundException {
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("insert into vendedor (nome, cpf, endereco, totalVendasMensal, porcentagemComissao, salarioLiquido, premioMeta, comissaoVendas, salarioFinal) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        comando.setString(1, vend.getNome());
        comando.setString(2, vend.getCpf());
        comando.setString(3, vend.getEndereco());
        comando.setDouble(4, vend.getTotalVendasMensal());
        comando.setDouble(5, vend.getPorcentagemComissao());
        comando.setDouble(6, vend.getSalarioLiquido());
        comando.setDouble(7, vend.getPremioMeta());
        comando.setDouble(8, vend.getComissaoVendas());
        comando.setDouble(9, vend.getSalarioFinal());
        
        comando.execute();
        
        // TRATAR O RETORNO, ESSE MÉTODO NÃO POSSUI RETORNO, POIS NÃO É MÉTODO DE CONSULTAR
        
        con.close();
    }
    
    public void atualizarVendedor(Vendedor vend) throws SQLException, ClassNotFoundException {
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("update vendedor set nome = ?, cpf = ?, endereco = ?, totalVendasMensal = ?, porcentagemComissao = ?, salarioLiquido = ?, premioMeta = ?, comissaoVendas = ?, salarioFinal = ? where id = ?");
        comando.setString(1, vend.getNome());
        comando.setString(2, vend.getCpf());
        comando.setString(3, vend.getEndereco());
        comando.setDouble(4, vend.getTotalVendasMensal());
        comando.setDouble(5, vend.getPorcentagemComissao());
        comando.setDouble(6, vend.getSalarioLiquido());
        comando.setDouble(7, vend.getPremioMeta());
        comando.setDouble(8, vend.getComissaoVendas());
        comando.setDouble(9, vend.getSalarioFinal());
        comando.setInt(10, vend.getId());
        
        comando.execute();
        
        con.close();
    }
    
    public void deletarVendedor(Vendedor vend) throws SQLException, ClassNotFoundException {
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("delete from vendedor where id = ?");
        comando.setInt(1, vend.getId());
        
        comando.execute();
        
        con.close();
    }
    
    public Vendedor consultarPorId(Vendedor vend) throws SQLException, ClassNotFoundException {
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("select * from vendedor where id = ?");
        comando.setInt(1, vend.getId());
        
        ResultSet rs = comando.executeQuery();
        
        Vendedor v = new Vendedor();
        if (rs.next()) {
            v.setId(rs.getInt("id"));
            v.setNome(rs.getString("nome"));
            v.setCpf(rs.getString("cpf"));
            v.setEndereco(rs.getString("endereco"));
            v.setTotalVendasMensal(rs.getDouble("totalVendasMensal"));
            v.setPorcentagemComissao(rs.getDouble("porcentagemComissao"));
            v.setSalarioLiquido(rs.getDouble("salarioLiquido"));
            v.setPremioMeta(rs.getDouble("premioMeta"));
            v.setComissaoVendas(rs.getDouble("comissaoVendas"));
            v.setSalarioFinal(rs.getDouble("salarioFinal"));
        }
        
        con.close();
        return v;
    }
    
    public List<Vendedor> consultarTodos() throws SQLException, ClassNotFoundException {
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("select * from vendedor");
        
        ResultSet rs = comando.executeQuery();
        
        List<Vendedor> lvend = new ArrayList<>();
        while (rs.next()) {
            Vendedor v = new Vendedor();
            v.setId(rs.getInt("id"));
            v.setNome(rs.getString("nome"));
            v.setCpf(rs.getString("cpf"));
            v.setEndereco(rs.getString("endereco"));
            v.setTotalVendasMensal(rs.getDouble("totalVendasMensal"));
            v.setPorcentagemComissao(rs.getDouble("porcentagemComissao"));
            v.setSalarioLiquido(rs.getDouble("salarioLiquido"));
            v.setPremioMeta(rs.getDouble("premioMeta"));
            v.setComissaoVendas(rs.getDouble("comissaoVendas"));
            v.setSalarioFinal(rs.getDouble("salarioFinal"));
            lvend.add(v);
        }
        
        con.close();
        return lvend;
    }
}
