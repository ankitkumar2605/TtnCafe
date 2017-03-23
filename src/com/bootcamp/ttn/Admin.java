package com.bootcamp.ttn;


import java.util.*;

public class Admin extends User {


    private int balance;
    private List<Employee> employeeList;
    private HashMap<String, Product> inventory;

    public Admin() {
        id = "1000001";
        email = "admin@tothenew.com";
        password = "adminpasswrd";
        employeeList = new ArrayList<Employee>();
        inventory = new HashMap<String, Product>();
    }

    public Admin(String id, String name, String email, String password) {

        super(id, name, email, password);
    }

    public void setBalance() {
        balance = employeeList.size() * 800;
    }

    public int getBalance() {
        return balance;
    }

    public boolean addUser(Employee employee) {
        if (employeeList.size() < 10) {
            for (Employee emp : employeeList) {
                if (emp.getId().equals(employee.getId())) {
                    System.out.println("User ID already exists!!!!");
                    return false;
                }
            }
            employeeList.add(employee);
            setBalance();
            return true;
        } else {
            System.out.println("Number of employee limit exceeds!!!!!");
        }
        return false;

    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee getEmployee(String email, String passwd) {
        for (Employee emp : employeeList) {
            if (emp.getEmail().equals(email)) {
                if (emp.getPassword().equals(passwd)) {
                    return emp;
                }
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        Product prod = inventory.put(product.getProductId(), product);
        if (prod != null)
            System.out.println("Product id already exists");
    }

    public void removeProduct(String productid) {
        if ((inventory.get(productid)) != null)
            inventory.remove(productid);
        else
            System.out.println("Please enter correct product id");
    }

    public void updateInventory(String productid){
        Product product = inventory.get(productid);
        if (product != null){
            if(product.getQuantity()!=0) {
                product.setQuantity(product.getQuantity() - 1);
                inventory.put(productid, product);
            }
            else
                System.out.println("Product not available");
        }
        else
            System.out.println("Please enter correct pid");
    }

    public void printInventory(){
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            String key = entry.getKey();
            Product product = (Product) entry.getValue();
            System.out.println("Product id:"+key + " Product Quantity:" + product.getQuantity());
        }
    }
}
