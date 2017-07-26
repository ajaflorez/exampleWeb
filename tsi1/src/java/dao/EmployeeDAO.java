package dao;

import conn.ConnectionOracle;
import interfaces.DAO;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.ExamenPLSQL;
import oracle.jdbc.OracleTypes;


public class EmployeeDAO implements DAO<Employee>{
    
    private static final String SQL_INSERT = "Insert into employees values "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "Delete from employees where employee_id = ?";
    private static final String SQL_UPADTE = "Update employees set first_name = ?, " 
            + "last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, " 
            + "salary = ?, commission_pct = ?, manager_id = ?, department_id = ? " 
            + "where employee_id = ?";
    private static final String SQL_SELECT = "Select * from employees where employee_id = ?";
    private static final String SQL_SELECTALL = "Select * from employees";
    
    private static final String PLSQL_GETVALOR = "{call getValor(?, ?)}";
    private static final String PLSQL_GETEXAMENPLSQL = "{call getExamenPLSQL(?)}";
    
    
    private static final ConnectionOracle conn = ConnectionOracle.startConnection();

    @Override
    public boolean insert(Employee ta) {
        PreparedStatement ps;
        try {
            // Prepara el SQL para ejecutarse
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setInt(1, ta.getEmployee_id());
            ps.setString(2, ta.getFirst_name());
            ps.setString(3, ta.getLast_name());
            ps.setString(4, ta.getEmail());
            ps.setString(5, ta.getPhone_number());
            ps.setDate(6, new Date(ta.getHire_date().getTime()));
            ps.setString(7, ta.getJob_id());
            ps.setDouble(8, ta.getSalary());
            ps.setFloat(9, ta.getCommission_pct());
            ps.setInt(10, ta.getManager_id());
            ps.setInt(11, ta.getDepartment_id());
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Employee ta) {
        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_UPADTE);            
            ps.setString(1, ta.getFirst_name());
            ps.setString(2, ta.getLast_name());
            ps.setString(3, ta.getEmail());
            ps.setString(4, ta.getPhone_number());
            ps.setDate(5, new Date(ta.getHire_date().getTime()));
            ps.setString(6, ta.getJob_id());
            ps.setDouble(7, ta.getSalary());
            ps.setFloat(8, ta.getCommission_pct());
            ps.setInt(9, ta.getManager_id());
            ps.setInt(10, ta.getDepartment_id());
            ps.setInt(11, ta.getEmployee_id());
            
            if(ps.executeUpdate() > 0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return false;
    }

    @Override
    public Employee select(Object key) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee emp = null;
        
        try {
            ps = conn.getConnection().prepareStatement(SQL_SELECT);
            ps.setInt(1, (int)key);
            
            rs = ps.executeQuery();
            if(rs.next()) {
                emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), 
                        rs.getDouble(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11));
            }
            return emp;
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return emp;
    }

    @Override
    public ArrayList<Employee> selectAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Employee> emp = new ArrayList<>();
        
        try {
            ps = conn.getConnection().prepareStatement(SQL_SELECTALL);
            rs = ps.executeQuery();
            while(rs.next()) {
                emp.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), 
                        rs.getDouble(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11)));
            }
            return emp;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return emp;       
    }    
    public float getValue(Object key) {
        float valor = 0;
        CallableStatement cs;
        try {
            cs = conn.getConnection().prepareCall(PLSQL_GETVALOR);  // Preparando el PLSQL
            cs.setInt(1, (int)key); // estableciendo el Parametro de entrada
            cs.registerOutParameter(2, OracleTypes.NUMBER); //  estableciendo el Parametro de salida
            cs.execute();   // Ejecutar el Procedure
            valor = cs.getFloat(2); // recuperando el parametro de salida
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return valor;
    }
    public ArrayList<ExamenPLSQL> getExamenPLSQL() {
        ArrayList<ExamenPLSQL> examen = new ArrayList<>();
        CallableStatement cs;
        try {
            cs = conn.getConnection().prepareCall(PLSQL_GETEXAMENPLSQL);  // Preparando el PLSQL            
            cs.registerOutParameter(1, OracleTypes.CURSOR); //  estableciendo el Parametro de salida
            cs.execute();   // Ejecutar el Procedure
            ResultSet rs = (ResultSet)cs.getObject(1); // recuperando el parametro de salida
            while(rs.next()) {
                examen.add(new ExamenPLSQL(rs.getString(1), rs.getInt(2), rs.getInt(3), 
                        rs.getFloat(4), rs.getFloat(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.closeConnection();
        }
        return examen;
    }
}
