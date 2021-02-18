package dev.lipco.daos;

import dev.lipco.entities.Client;
import dev.lipco.services.ClientServiceImpl;
import dev.lipco.utils.ConnectionUtil;

import java.sql.*;
import java.util.Set;
import java.util.HashSet;

public class PsqlClientDAO implements ClientDAO {

    @Override
    public Client createClient(Client client) {
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "insert into client (first_name, last_name) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("id");
            client.setId(key);

            return client;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("could not create account " + sqlException);
        }
        return null;
    }

    @Override
    public Set<Client> getAllClients() {
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from client";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Set<Client> clients  = new HashSet<Client>();

            while(rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                clients.add(client);
            }

            return clients;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Could not retrieve account " + sqlException );
            return null;
        }
    }

    @Override
    public Client getClientById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from client where id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));

            return client;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Could not retrieve account " + sqlException );
            return null;
        }
    }

    @Override
    public Client updateClient(Client client) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update client set first_name = ?, last_name = ? where id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,client.getFirstName());
            ps.setString(2,client.getLastName());
            ps.setInt(3, client.getId());
            ps.executeUpdate();

            return client;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Could not update account " + sqlException );
            return null;
        }
    }

    @Override
    public boolean deleteClientById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from client where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Could not delete account " + sqlException );
            return false;
        }
    }

}
