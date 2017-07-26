package dao;

import conn.ConnectionOracle;
import model.Department;
import interfaces.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentDAO implements DAO<Department>{
    
    private static final String SQL_INSERT = "Insert into departments values (?, ?, ?, ?)";
    private static final String SQL_DELETE = "Delete from departments where department_id = ?";
    private static final String SQL_UPADTE = "Update departments set department_name = ?, manager_id = ?, location_id = ? where department_id = ?";
    private static final String SQL_SELECT = "Select * from departments where department_id = ?";
    private static final String SQL_SELECTALL = "Select * from departments";
    
    private static final ConnectionOracle conn = ConnectionOracle.startConnection();

    @Override
    public boolean insert(Department ta) {
        PreparedStatement ps;
        try {
            // Prepara el SQL para ejecutarse
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setInt(1, ta.getDepartment_id());
            ps.setString(2, ta.getDepartment_name());
            ps.setInt(3, ta.getManager_id());
            ps.setInt(4, ta.getLocation_id());
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        
        return false;        
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int)key);
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Department ta) {
        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_UPADTE);
            ps.setString(1, ta.getDepartment_name());
            ps.setInt(2, ta.getManager_id());
            ps.setInt(3, ta.getLocation_id());
            ps.setInt(4, ta.getDepartment_id());
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return false;
    }

    @Override
    public Department select(Object key) {
        PreparedStatement ps;
        ResultSet rs;
        Department dep = null;
        
        try {
            ps = conn.getConnection().prepareStatement(SQL_SELECT);
            ps.setInt(1, (int)key);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                dep = new Department(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
            return dep;
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return dep;
        
    }

    @Override
    public ArrayList<Department> selectAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Department> deps = new ArrayList<>();
        
        try {
            ps = conn.getConnection().prepareStatement(SQL_SELECTALL);
            rs = ps.executeQuery();
            while(rs.next()) {
                deps.add(new Department(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            return deps;
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return deps;        
    }    
}
