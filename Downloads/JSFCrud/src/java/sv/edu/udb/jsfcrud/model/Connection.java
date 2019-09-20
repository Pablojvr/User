/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.jsfcrud.model;

import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connection {

    protected DataSource dataSource;
    protected java.sql.Connection con;

    public Connection() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws SQLException {
        //if resource injection is not support, you still can get it manually.
        if (dataSource == null) {
            throw new SQLException("Can't get data source");
        }

        con = dataSource.getConnection();

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
    }

    protected void close() throws SQLException {
        con.close();
    }

}
