package pe.tsi.model;

public class Employees {
    private int employee_id;
    private String last_name;
    private String description;
    private String job_id;

    public Employees(int employee_id, String last_name, String description, String job_id) {
        this.employee_id = employee_id;
        this.last_name = last_name;
        this.description = description;
        this.job_id = job_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }
    
    

}
