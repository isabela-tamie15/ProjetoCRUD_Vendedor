package controller;

import model.Vendedor;
import model.dao.VendedorDAO;

import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class VendedorController {

    public static String calcularComissaoVendas(String[] dados) {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setPorcentagemComissao(Double.parseDouble(dados[0]));
        vend.setTotalVendasMensal(Double.parseDouble(dados[1]));

        vdao.calcularComissaoVendas(vend);

        return Double.toString(vend.getComissaoVendas());
    }

    public static String definirPremioMeta(String dado) {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setComissaoVendas(Double.parseDouble(dado));

        vdao.definirPremioMeta(vend);

        return Double.toString(vend.getPremioMeta());
    }

    public static String calcularSalarioFinal(String[] dados) {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setComissaoVendas(Double.parseDouble(dados[0]));
        vend.setPremioMeta(Double.parseDouble(dados[1]));
        vend.setSalarioLiquido(Double.parseDouble(dados[2]));

        vdao.calcularSalarioFinal(vend);

        return Double.toString(vend.getSalarioFinal());
    }

    public static void inserirVendedor(String[] dados) throws SQLException, ClassNotFoundException {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setNome(dados[0]);
        vend.setCpf(dados[1]);
        vend.setEndereco(dados[2]);
        vend.setTotalVendasMensal(Double.parseDouble(dados[3]));
        vend.setPorcentagemComissao(Double.parseDouble(dados[4]));
        vend.setSalarioLiquido(Double.parseDouble(dados[5]));
        vend.setPremioMeta(Double.parseDouble(dados[6]));
        vend.setComissaoVendas(Double.parseDouble(dados[7]));
        vend.setSalarioFinal(Double.parseDouble(dados[8]));

        vdao.inserirVendedor(vend);
    }

    public static void atualizarVendedor(String[] dados) throws SQLException, ClassNotFoundException {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setNome(dados[0]);
        vend.setCpf(dados[1]);
        vend.setEndereco(dados[2]);
        vend.setTotalVendasMensal(Double.parseDouble(dados[3]));
        vend.setPorcentagemComissao(Double.parseDouble(dados[4]));
        vend.setSalarioLiquido(Double.parseDouble(dados[5]));
        vend.setPremioMeta(Double.parseDouble(dados[6]));
        vend.setComissaoVendas(Double.parseDouble(dados[7]));
        vend.setSalarioFinal(Double.parseDouble(dados[8]));
        vend.setId(Integer.parseInt(dados[9]));

        vdao.atualizarVendedor(vend);
    }

    public static void deletarVendedor(String dado) throws SQLException, ClassNotFoundException {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setId(Integer.parseInt(dado));

        vdao.deletarVendedor(vend);
    }

    public static String[] consultarPorId(String dado) throws SQLException, ClassNotFoundException {
        Vendedor vend = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();

        vend.setId(Integer.parseInt(dado));

        vend = vdao.consultarPorId(vend);
        
        if (vend.getNome() != null) {
            String[] atributos = {
                vend.getNome(),
                vend.getCpf(),
                vend.getEndereco(),
                Double.toString(vend.getTotalVendasMensal()),
                Double.toString(vend.getPorcentagemComissao()),
                Double.toString(vend.getSalarioLiquido()),
                Double.toString(vend.getPremioMeta()),
                Double.toString(vend.getComissaoVendas()),
                Double.toString(vend.getSalarioFinal())
            };
            return atributos;
        } else {
            return null;
        }
    }

    public static List<String[]> consultarTodos() throws SQLException, ClassNotFoundException {
        VendedorDAO vdao = new VendedorDAO();
        List<String[]> lvend = new ArrayList<>();
        
        List<Vendedor> vendedores = vdao.consultarTodos();
        for (Vendedor vend : vendedores) {
            String[] atributos = {
                Integer.toString(vend.getId()),
                vend.getNome(),
                vend.getCpf(),
                vend.getEndereco(),
                Double.toString(vend.getTotalVendasMensal()),
                Double.toString(vend.getPorcentagemComissao()),
                Double.toString(vend.getSalarioLiquido()),
                Double.toString(vend.getPremioMeta()),
                Double.toString(vend.getComissaoVendas()),
                Double.toString(vend.getSalarioFinal())
            };
            lvend.add(atributos);
        }
        
        return lvend;
    }
    
}
