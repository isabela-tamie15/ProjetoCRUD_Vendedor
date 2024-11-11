create table vendedor (
    id int(3) not null primary key auto_increment,
    nome varchar(50) not null,
    cpf varchar(15) not null,
    endereco varchar(100) not null,
    totalVendasMensal double(8, 2) not null,
    porcentagemComissao double(3, 2) not null,
    salarioLiquido double(7, 2) not null,
    premioMeta double(6, 2) not null,
    comissaoVendas double(7, 2) not null,
    salarioFinal double(7, 2) not null
);

insert into vendedor (nome, cpf, endereco, totalVendasMensal, porcentagemComissao, salarioLiquido, premioMeta, comissaoVendas, salarioFinal) values ('Fulano3', '111.222.333-44', 'Rua sem nome', 100000.00, 0.1, 2000, 1000, 10000.00, 13000.00);

update vendedor set nome = 'Cliente', cpf = '111.111.111-11', endereco = 'Rua 1', totalVendasMensal = 100000, porcentagemComissao = 0.1, salarioLiquido = 2000, premioMeta = 2000, comissaoVendas = 10000, salarioFinal = 14000 where id = 1;

delete from vendedor where id = 3;

select * from vendedor;

select * from vendedor where id = 5;
