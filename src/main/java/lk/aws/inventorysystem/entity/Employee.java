package lk.aws.inventorysystem.entity;

public class Employee extends SuperEntity{


    private String emp_id;
    private String emp_name;
    private String emp_age;
    private String emp_sex;
    private String emp_deignation;

    public Employee() {
    }

    public Employee(String emp_id, String emp_name, String emp_age, String emp_sex, String emp_deignation) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_age = emp_age;
        this.emp_sex = emp_sex;
        this.emp_deignation = emp_deignation;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(String emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public String getEmp_deignation() {
        return emp_deignation;
    }

    public void setEmp_deignation(String emp_deignation) {
        this.emp_deignation = emp_deignation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_age='" + emp_age + '\'' +
                ", emp_sex='" + emp_sex + '\'' +
                ", emp_deignation='" + emp_deignation + '\'' +
                '}';
    }
}
