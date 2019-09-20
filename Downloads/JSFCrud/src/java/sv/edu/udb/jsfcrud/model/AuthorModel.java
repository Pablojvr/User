/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.jsfcrud.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel extends sv.edu.udb.jsfcrud.model.Connection {

    public AuthorModel() {
        super();
    }

    public List<Author> getAuthors() throws SQLException {

        this.connect();

        PreparedStatement ps
                = con.prepareStatement(
                        "select a.id as idAuthor, a.name, a.birth, a.number, l.name as literarygenre "
                        + "from authors a "
                        + "join literarygenre l "
                        + "on l.id = a.literarygenreid ");

        ResultSet result = ps.executeQuery();

        List<Author> list = new ArrayList<Author>();

        while (result.next()) {
            Author author = new Author();
            author.setAuthorId(result.getInt("idAuthor"));
            author.setAuthorName(result.getString("name"));
            author.setAuthorBirth(result.getDate("birth"));
            author.setAuthorNumber(result.getString("number"));
            author.setLiteraryGenre(result.getString("literarygenre"));
            list.add(author);
        }

        this.close();
        return list;

    }

    public List<Author> filterAuthors(String genero) throws SQLException {

        if (!genero.isEmpty()) {
            this.connect();
            PreparedStatement ps
                    = con.prepareStatement(
                            "select a.id as idAuthor, a.name, a.birth, a.number, l.name as literarygenre "
                            + "from authors a "
                            + "join literarygenre l "
                            + "on l.id = a.literarygenreid where l.id = ?");
            ps.setInt(1, Integer.parseInt(genero));
            ResultSet result = ps.executeQuery();

            List<Author> list = new ArrayList<Author>();

            while (result.next()) {
                Author author = new Author();
                author.setAuthorId(result.getInt("idAuthor"));
                author.setAuthorName(result.getString("name"));
                author.setAuthorBirth(result.getDate("birth"));
                author.setAuthorNumber(result.getString("number"));
                author.setLiteraryGenre(result.getString("literarygenre"));
                list.add(author);
            }

            this.close();
            return list;
        } else {
            return getAuthors();
        }
    }

    public int findSameNameAuhor(String name) throws SQLException {

        this.connect();

        PreparedStatement ps
                = con.prepareStatement("select count(*) as total "
                        + "from authors a "
                        + " where name like ? ");

        ps.setString(1, name);
        ResultSet result = ps.executeQuery();
        int count = 0;

        while (result.next()) {
            count = result.getInt("total");
        }

        this.close();
        return count;
    }

    public void addAuthor(Author author) throws SQLException {

        this.connect();

        if (dataSource == null) {
            throw new SQLException("Can't get data source");
        }

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }

        PreparedStatement ps = con.prepareStatement("insert into authors (name,birth,number,literarygenreid) "
                + " values (?,?,?,?)");
        ps.setString(1, author.getAuthorName());
        ps.setDate(2, new java.sql.Date(author.getAuthorBirth().getTime()));//convirtiendofecha 

        ps.setString(3, author.getAuthorNumber());
        ps.setString(4, author.getLiteraryGenre());

        ps.execute();

        this.close();

    }

    public void delete(Author author) throws SQLException {
        this.connect();
        if (dataSource == null) {
            throw new SQLException("Can't get data source");
        }

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }

        PreparedStatement ps
                = con.prepareStatement("delete from authors where id = ?");

        ps.setInt(1, author.getAuthorId());

        ps.execute();

        this.close();
    }
    //Usted debe implementar esta funcionalidad

    public boolean update(Author author) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public int Contar(String genero) throws SQLException {
        int cantidad = 0;
        if (!genero.isEmpty()) {
            this.connect();
            PreparedStatement ps
                    = con.prepareStatement("select count(id) from authors\n"
                            + "where literarygenreid = ?;");
            ps.setInt(1, Integer.parseInt(genero));
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                cantidad = result.getInt(1);
            }

            this.close();
            return cantidad;
        } else {
            this.connect();
            PreparedStatement ps = con.prepareStatement("select count(id) from authors;");

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                cantidad = result.getInt(1);
            }

            this.close();
            return cantidad;
        }
    }

}
