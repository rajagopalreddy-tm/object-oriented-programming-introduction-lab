package com.trainingmug.ecommerce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    @Order(1)
    @DisplayName("Should Create Employee class in com.trainingmug.ecommerce package")
    public void testEmployeeClassExists() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Should create the fields in Employee class with the appropriate Type")
    void testVariablesInEmployeeShouldBePresent() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            assertFieldIsPublic(employeeClass, "empId", long.class);
            assertFieldIsPublic(employeeClass, "name", String.class);
            assertFieldIsPublic(employeeClass, "designation", String.class);
            assertFieldIsPublic(employeeClass, "grossSalary", float.class);
            assertFieldIsPublic(employeeClass, "travellingAllowances", float.class);
            assertFieldIsPublic(employeeClass, "federalTax", float.class);
            assertFieldIsPublic(employeeClass, "stateTax", float.class);
            assertFieldIsPublic(employeeClass, "incrementPercentage", float.class);

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        }
    }

    private void assertFieldIsPublic(Class<?> clazz, String fieldName, Class<?> fieldType) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertEquals(fieldType, field.getType(), "Field " + fieldName + " should be of type " + fieldType.getSimpleName());
            assertTrue(Modifier.isPublic(field.getModifiers()), "Field " + fieldName + " should be public");
        } catch (NoSuchFieldException e) {
            fail("Field " + fieldName + " should be present in the class " + clazz.getSimpleName());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should have Employee() no-arg constructor")
    public void testEmployeeConstructor() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
            assertNotNull(noArgConstructor, "Employee() No-arg constructor should be present");
            assertTrue(Modifier.isPublic(noArgConstructor.getModifiers()), "No-arg constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee() No-arg constructor not found in class " + className);
        }
    }

    @Test
    @Order(4)
    @DisplayName("Should be able to create Employee Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeConstructorAndInitializeProperties() {
        Employee employee = new Employee();
        float delta = 0.01f;

        assertEquals(1111, employee.empId, "Employee id should be 111");
        assertEquals("Andrew Fuller", employee.name, "Employee name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Employee designation should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary,delta, "Employee grossSalary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances,delta, "Employee travellingAllowances should be 300.0f");
        assertEquals(611.86, employee.federalTax,delta, "Employee federalTax should be 611.86");
        assertEquals(359.24, employee.stateTax,delta, "Employee stateTax should be 359.24");
        assertEquals(15.3, employee.incrementPercentage,delta, "Employee incrementPercentage should be 15.3");
    }

    @Test
    @Order(5)
    @DisplayName("Should create Employee All Args Constructor")
    public void testEmployeeAllArgsConstructor() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(long.class, String.class, String.class, float.class, float.class, float.class, float.class,float.class);

            assertNotNull(constructor, "Employee All Args Constructor should be present");
            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {

            fail("Employee All Args Constructor is not found in class  " + className);
        }
    }

    @Test
    @Order(6)
    @DisplayName("Should be able to create Employee Arg Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeArgConstructorAndInitializeProperties() {
        float delta = 0.01f;
        Employee employee = new Employee(1111,"Andrew Fuller","Senior Software Engineer",5208.33f,300.0f,611.86f,359.24f,15.3f);
        assertEquals(1111, employee.empId, "Id value should be 111");
        assertEquals("Andrew Fuller", employee.name, "Name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Department should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary, delta,"Gross Salary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances, delta,"Gross Salary should be 5208.33");
        assertEquals(611.86, employee.federalTax, delta, "TravellingAllowances should be 300.0");
        assertEquals(359.24, employee.stateTax, delta,"StateTax should be 611.86");
        assertEquals(15.3, employee.incrementPercentage,delta, "Increment Percentage should be 15.3");
    }

    @Test
    @Order(7)
    @DisplayName("Test method IncrementSalary Should be present")
    public void testIncrementSalaryMethodExists() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            employeeClass.getMethod("incrementSalary", float.class);
        } catch (NoSuchMethodException e) {
            fail("Method incrementSalary(float) should be present in Employee class");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(8)
    @DisplayName("Test IncrementSalary method parameter Should be present")
    public void testIncrementSalaryMethodParameters() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getMethod("incrementSalary", float.class);
            Parameter[] parameters = method.getParameters();
            assertEquals(1, parameters.length, "Method incrementSalary should take exactly one parameter");
            assertEquals(float.class, parameters[0].getType(), "Parameter type should be float");
        } catch (NoSuchMethodException e) {
            fail("Method incrementSalary(float) should be present in Employee class");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test IncrementSalary Logic should incremented gross salary")
    public void testIncrementSalaryLogic() {
        Employee employee = new Employee();
        float delta = 0.01f;
        float initialSalary = employee.grossSalary;
        float percentage = employee.incrementPercentage;
        employee.incrementSalary(percentage);
        float expectedSalary = initialSalary + (initialSalary * percentage / 100);
        assertEquals(expectedSalary, employee.grossSalary, delta, "The grossSalary should be incremented correctly");
    }

    @Test
    @Order(10)
    @DisplayName("Test DisplayProfile method should exist")
    public void testDisplayProfileMethodExists() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getMethod("displayProfile");
            Parameter[] parameters = method.getParameters();
            assertEquals(0,parameters.length,"Method displayProfile should not take parameter");
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Method displayProfile() should be present in Employee class");
        }
    }

    @Test
    @Order(11)
    @DisplayName("Test DisplayProfile Output ")
    public void testDisplayProfileOutput() {
        Employee employee = new Employee();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        employee.displayProfile();

        System.setOut(originalOut);

        // Expected output with platform-specific newlines
        String expectedOutput = "Employee ID: 1111" + System.lineSeparator() +
                "Name: Andrew Fuller" + System.lineSeparator() +
                "Designation: Senior Software Engineer" + System.lineSeparator() +
                "Gross Salary: 5208.33" + System.lineSeparator() +
                "Travelling Allowances: 300.0" + System.lineSeparator() +
                "Federal Tax: 611.86" + System.lineSeparator() +
                "State Tax: 359.24" + System.lineSeparator() +
                "Net Salary Increment Percentage: 15.3" + System.lineSeparator();

        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput, "The displayProfile method should print the correct output");
    }

    @Test
    @Order(12)
    @DisplayName("Should create the static fields in Employee class with the appropriate Type and Initialization")
    void testStaticVariablesInEmployeeShouldBePresentAndInitialized() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");

            assertStaticFieldIsPublic(employeeClass, "companyName", String.class);
            assertStaticFieldIsPublic(employeeClass, "companyContactNo", String.class);
            assertStaticFieldIsPublic(employeeClass, "employeeCount", long.class);

            assertStaticFieldIsInitialized(employeeClass, "companyName", "Training Mug");
            assertStaticFieldIsInitialized(employeeClass, "companyContactNo", "9034568900");
            assertStaticFieldIsInitialized(employeeClass, "employeeCount", 0L);

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        }
    }

    private void assertStaticFieldIsPublic(Class<?> clazz, String fieldName, Class<?> fieldType) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertEquals(fieldType, field.getType(), "Field " + fieldName + " should be of type " + fieldType.getSimpleName());
            assertTrue(Modifier.isPublic(field.getModifiers()), "Field " + fieldName + " should be public");
            assertTrue(Modifier.isStatic(field.getModifiers()), "Field " + fieldName + " should be static");
        } catch (NoSuchFieldException e) {
            fail("Field " + fieldName + " should be present in the class " + clazz.getSimpleName());
        }
    }

    private void assertStaticFieldIsInitialized(Class<?> clazz, String fieldName, Object expectedValue) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(null); // null because it's a static field
            assertEquals(expectedValue, value, "Field " + fieldName + " should be initialized to " + expectedValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Field " + fieldName + " should be present and accessible in the class " + clazz.getSimpleName());
        }
    }

    @Test
    @Order(13)
    @DisplayName("Should create the displayCompanyInfo method in Employee class with the appropriate signature")
    void testDisplayCompanyInfoMethodSignature() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getDeclaredMethod("displayCompanyInfo");

            assertTrue(Modifier.isPublic(method.getModifiers()), "Method displayCompanyInfo should be public");
            assertTrue(Modifier.isStatic(method.getModifiers()), "Method displayCompanyInfo should be static");
            assertEquals(void.class, method.getReturnType(), "Method displayCompanyInfo should return void");
            assertEquals(0, method.getParameterCount(), "Method displayCompanyInfo should take no arguments");

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        } catch (NoSuchMethodException e) {
            fail("Method displayCompanyInfo should be present in the Employee class");
        }
    }

    @Test
    @Order(14)
    @DisplayName("Should print the correct company information when displayCompanyInfo is called")
    void testDisplayCompanyInfoOutput() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            Method method = employeeClass.getDeclaredMethod("displayCompanyInfo");
            method.invoke(null);

            System.setOut(originalOut);

            String expectedOutput = "Company Name: Training Mug" + System.lineSeparator() +
                    "Company Contact No: 9034568900" + System.lineSeparator() +
                    "Employee Count: 0"+ System.lineSeparator() ;

            assertEquals(expectedOutput, outContent.toString(), "The displayCompanyInfo method should print the correct output");

        } catch (Exception e) {
            fail("Exception occurred while testing displayCompanyInfo method: " + e.getMessage());
        }
    }

}
