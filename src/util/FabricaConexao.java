package util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class FabricaConexao {
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/atv_crud";
        String USUARIO = "root";
        String SENHA = "";
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
