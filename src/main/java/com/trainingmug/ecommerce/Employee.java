package com.trainingmug.ecommerce;

public class Employee {

    public long empId;
    public String name;
    public String designation;
    public float grossSalary;
    public float travellingAllowances;
    public float federalTax;
    public float stateTax;
    public float incrementPercentage;

    public static String companyName = "Training Mug";
    public static String companyContactNo = "9034568900";
    public static long employeeCount = 0;

    public Employee() {
        this.empId = 1111;
        this.name = "Andrew Fuller";
        this.designation = "Senior Software Engineer";
        this.grossSalary = 5208.33f;
        this.travellingAllowances = 300.0f;
        this.federalTax = 611.86f;
        this.stateTax = 359.24f;
        this.incrementPercentage = 15.3f;
    }

    public Employee(long empId, String name, String designation, float grossSalary, float travellingAllowances, float federalTax, float stateTax, float incrementPercentage) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.grossSalary = grossSalary;
        this.travellingAllowances = travellingAllowances;
        this.federalTax = federalTax;
        this.stateTax = stateTax;
        this.incrementPercentage = incrementPercentage;
    }

    public void incrementSalary(float percentage) {
        this.grossSalary += this.grossSalary * percentage / 100;
    }

    public void displayProfile() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Travelling Allowances: " + travellingAllowances);
        System.out.println("Federal Tax: " + federalTax);
        System.out.println("State Tax: " + stateTax);
        System.out.println("Net Salary Increment Percentage: " + incrementPercentage);
    }

//    public static Employee createEmployee(long empId, String name, String designation, float grossSalary, float travellingAllowances, float federalTax, float stateTax, float incrementPercentage) {
//        return new Employee(empId, name, designation, grossSalary, travellingAllowances, federalTax, stateTax, incrementPercentage);
//    }

    public static void displayCompanyInfo() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Company Contact No: " + companyContactNo);
        System.out.println("Employee Count: " + employeeCount);
    }

}