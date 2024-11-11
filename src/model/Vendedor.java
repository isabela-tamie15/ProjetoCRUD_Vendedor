package model;

public class Vendedor {
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private double totalVendasMensal;
    private double porcentagemComissao;
    private double salarioLiquido;   
    private double premioMeta;
    private double comissaoVendas;  // CALCULADO (não inserir na tela)
    private double salarioFinal;    // CALCULADO (não inserir na tela)
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getTotalVendasMensal() {
        return totalVendasMensal;
    }

    public void setTotalVendasMensal(double totalVendasMensal) {
        this.totalVendasMensal = totalVendasMensal;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public double getPorcentagemComissao() {
        return porcentagemComissao;
    }
    
    public void setPorcentagemComissao(double porcentagemComissao) {
        this.porcentagemComissao = porcentagemComissao;
    }
    
    public double getComissaoVendas() {
        return comissaoVendas;
    }

    public void setComissaoVendas(double comissaoVendas) {
        this.comissaoVendas = comissaoVendas;
    }

    public double getPremioMeta() {
        return premioMeta;
    }

    public void setPremioMeta(double premioMeta) {
        this.premioMeta = premioMeta;
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }
    
    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }
      
}
