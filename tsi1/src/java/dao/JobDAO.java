package dao;

import conn.ConnectionOracle;
import interfaces.DAO;
import java.util.ArrayList;
import model.Job;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JobDAO implements DAO<Job>{
    private static final String SQL_INSERT = "Insert into jobs values (?, ?, ?, ?)";
    private static final String SQL_DELETE = "Delete from jobs where job_id = ?";
    private static final String SQL_UPADTE = "Update jobs set job_title = ?, min_salary = ?, max_salary = ? where job_id = ?";
    private static final String SQL_SELECT = "Select * from jobs where job_id = ?";
    private static final String SQL_SELECTALL = "Select * from jobs";
    
    private static final ConnectionOracle conn = ConnectionOracle.startConnection();
    
    @Override
    public boolean insert(Job ta) {
        PreparedStatement ps;
        try {
            // Prepara el SQL para ejecutarse
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, ta.getJob_id());
            ps.setString(2, ta.getJob_title());
            ps.setInt(3, ta.getMin_salary());
            ps.setInt(4, ta.getMax_salary());
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            ps.setString(1, (String)key);
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Job ta) {
        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_UPADTE);
            ps.setString(1, ta.getJob_title());
            ps.setInt(2, ta.getMin_salary());
            ps.setInt(3, ta.getMax_salary());
            ps.setString(4, ta.getJob_id());
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return false;
    }

    @Override
    public Job select(Object key) {
        PreparedStatement ps;
        ResultSet rs;
        Job job = null;
        
        try {
            ps = conn.getConnection().prepareStatement(SQL_SELECT);
            ps.setString(1, (String)key);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                job = new Job(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
            return job;
            
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return job;
    }

    @Override
    public ArrayList<Job> selectAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Job> jobs = new ArrayList<>();
        
        try {
            ps = conn.getConnection().prepareStatement(SQL_SELECTALL);
            rs = ps.executeQuery();
            while(rs.next()) {
                jobs.add(new Job(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            return jobs;
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return jobs;        
    }
    
}
