package dev.lipco.daos;
import dev.lipco.entities.Account;
import dev.lipco.utils.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;

public class PsqlAccountDAO implements AccountDAO {
    private Logger logger = Logger.getLogger(PsqlAccountDAO.class.getName());

    @Override
    public Account createAccount(Account account) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into account (balance, client_id) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, account.getBalance());
            ps.setInt(2, account.getcId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("account_id");
            account.setId(key);
            return account;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to create account", sqlException);
            return null;
        }
    }

    @Override
    public Set<Account> getAllAccounts() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from account";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Set<Account> accounts = new HashSet<Account>();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalance(rs.getBigDecimal("balance"));
                account.setcId(rs.getInt("client_id"));
                accounts.add(account);
            }
            return accounts;
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to get all accounts", sqlException);
            return null;
        }
    }

    @Override
    public Account getAccountById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from account where account_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            account.setBalance(rs.getBigDecimal("balance"));
            account.setcId(rs.getInt("client_id"));
            return account;
        }catch(SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to get Account with id " + id, sqlException);
            return null;
        }
    }

    @Override
    public Account updateAccount(Account account) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update account set balance = ?, client_id = ? where account_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, account.getBalance());
            ps.setInt(2, account.getcId());
            ps.setInt(3, account.getId());
            ps.executeUpdate();
            return account;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Unable to update account with id " + account.getId(), sqlException);
            return null;
        }
    }

    @Override
    public boolean deleteAccountById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "delete from account where account_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException sqlException) {
         sqlException.printStackTrace();
         logger.error("Unable to delete account with id " + id, sqlException);
         return false;
        }
    }

}
