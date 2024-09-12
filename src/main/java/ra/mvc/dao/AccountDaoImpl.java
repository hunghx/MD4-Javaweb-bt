package ra.mvc.dao;

import ra.mvc.model.Account;
import ra.mvc.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements IAccountDao{
    @Override
    public Account login(String username, String password) {
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callStmt = null;
        try{
            callStmt = conn.prepareCall("{call login(?,?)}");
            // truyen tham so
            callStmt.setString(1,username);
            callStmt.setString(2,password);
            // thuc thi cau lenh
            ResultSet rs = callStmt.executeQuery();
            if(rs.next()){
                Account account = new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        "", // ko dc phep lây pass về
                        rs.getString("fullName"),
                        rs.getInt("balance")
                );
                return account;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void sendMoney(int idSender, int idReceiver, int amount) {
        // co 2 thao tác : sử dụng transaction
        Connection conn  = ConnectionDB.getConnection();
        CallableStatement callSt1 = null;
        CallableStatement callSt2 = null;
        try {
            conn.setAutoCommit(false);

            // thuc hien tru tien truoc
            callSt1 = conn.prepareCall("{call changeBalance(?,?)}");
            callSt1.setInt(1, -amount);
            callSt1.setInt(2, idSender);
            callSt1.executeUpdate();
            // thuc hhienj thao tac cong tien
            callSt2 = conn.prepareCall("{call changeBalance(?,?)}");
            callSt2.setInt(1, amount);
            callSt2.setInt(2, idReceiver);
            callSt2.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
}
