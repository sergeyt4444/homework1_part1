package com.mycompany.classes;

import java.util.Objects;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary*12;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ",name=" + getName() + ",salary=" + salary + "]";
    }

    public int raiseSalary(int percent) {
        //salary - целочисленный тип, что повлияет на точность вычислений
        //Также не совсем понятно, каким должен быть процент (например, при увеличении в 1.5 раз 50% или 150%)
        salary = (salary * (100 + percent))/100;
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary);
    }
}
