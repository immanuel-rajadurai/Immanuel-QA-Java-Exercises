import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private List<Order> orders;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}

class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Order {
    private int orderId;
    private Product product;
    private Customer customer;

    public Order(int orderId, Product product, Customer customer) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", customer=" + customer.getName() +
                '}';
    }
}

public class InventoryManagementSystem {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static int customerIdCounter = 1;
    private static int productIdCounter = 1;
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Enter command (addCustomer, addProduct, addOrder, listCustomers, listProducts, listOrders, exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "addCustomer":
                    addCustomer(scanner);
                    break;
                case "addProduct":
                    addProduct(scanner);
                    break;
                case "addOrder":
                    addOrder(scanner);
                    break;
                case "listCustomers":
                    listCustomers();
                    break;
                case "listProducts":
                    listProducts();
                    break;
                case "listOrders":
                    listOrders();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Unknown command");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(customerIdCounter++, name);
        customers.add(customer);
        System.out.println("Added: " + customer);
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        Product product = new Product(productIdCounter++, name);
        products.add(product);
        System.out.println("Added: " + product);
    }

    private static void addOrder(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Customer customer = findCustomerById(customerId);
        Product product = findProductById(productId);

        if (customer != null && product != null) {
            Order order = new Order(orderIdCounter++, product, customer);
            orders.add(order);
            customer.addOrder(order);
            System.out.println("Added: " + order);
        } else {
            System.out.println("Invalid customer or product ID.");
        }
    }

    private static Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    private static Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private static void listCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void listProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void listOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
