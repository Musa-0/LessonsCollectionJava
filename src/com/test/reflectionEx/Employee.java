package com.test.reflectionEx;

public class Employee {
    public int id;
    public String name;
    public String department;
    private double salary=1000;


    private void changeDepartment(String newDepartment){//смена профессии
        this.department = newDepartment;
        System.out.println("Новая работа " + department);
    }

    public void increaseSalary(){//умножем зарплату а двое
        salary*=2;
    }
    public Employee(int id, String name, String department) {//конструктор без зарплаты
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
