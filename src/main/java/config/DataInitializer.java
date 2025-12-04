package config;

import com.example.map_proiect_restaurant.model.*;
import com.example.map_proiect_restaurant.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final CustomerRepository customerRepository;
    private final MenuItemRepository menuItemRepository;
    private final RestaurantTableRepository tableRepository;
    private final ChefRepository chefRepository;
    private final ServerRepository serverRepository;
    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final OrderAssignmentRepository orderAssignmentRepository;
    private final BillRepository billRepository;

    public DataInitializer(CustomerRepository customerRepository,
                           MenuItemRepository menuItemRepository,
                           RestaurantTableRepository tableRepository,
                           ChefRepository chefRepository,
                           ServerRepository serverRepository,
                           OrderRepository orderRepository,
                           OrderLineRepository orderLineRepository,
                           OrderAssignmentRepository orderAssignmentRepository,
                           BillRepository billRepository) {
        this.customerRepository = customerRepository;
        this.menuItemRepository = menuItemRepository;
        this.tableRepository = tableRepository;
        this.chefRepository = chefRepository;
        this.serverRepository = serverRepository;
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.orderAssignmentRepository = orderAssignmentRepository;
        this.billRepository = billRepository;
    }

    @PostConstruct
    public void init() {
        // Check if data already exists
        if (customerRepository.count() > 0) {
            return; // Data already initialized
        }

        // 1. Initialize Customers (10+)
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", "123 Main St, Cluj", "john.doe@email.com"));
        customers.add(new Customer("Jane Smith", "456 Oak Ave, Cluj", "jane.smith@email.com"));
        customers.add(new Customer("Michael Brown", "789 Pine Rd, Cluj", "michael.brown@email.com"));
        customers.add(new Customer("Emily Davis", "321 Elm St, Cluj", "emily.davis@email.com"));
        customers.add(new Customer("David Wilson", "654 Maple Dr, Cluj", "david.wilson@email.com"));
        customers.add(new Customer("Sarah Johnson", "987 Cedar Ln, Cluj", "sarah.johnson@email.com"));
        customers.add(new Customer("James Martinez", "147 Birch Ct, Cluj", "james.martinez@email.com"));
        customers.add(new Customer("Laura Garcia", "258 Spruce Way, Cluj", "laura.garcia@email.com"));
        customers.add(new Customer("Robert Miller", "369 Willow Pl, Cluj", "robert.miller@email.com"));
        customers.add(new Customer("Maria Rodriguez", "741 Ash Blvd, Cluj", "maria.rodriguez@email.com"));
        customers.add(new Customer("William Anderson", "852 Poplar St, Cluj", "william.anderson@email.com"));
        customers.add(new Customer("Lisa Thompson", "963 Cherry Ave, Cluj", "lisa.thompson@email.com"));
        customerRepository.saveAll(customers);

        // 2. Initialize Menu Items (10+)
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Margherita Pizza", 45.0));
        menuItems.add(new MenuItem("Carbonara Pasta", 38.0));
        menuItems.add(new MenuItem("Caesar Salad", 28.0));
        menuItems.add(new MenuItem("Grilled Salmon", 65.0));
        menuItems.add(new MenuItem("Beef Steak", 78.0));
        menuItems.add(new MenuItem("Chicken Alfredo", 42.0));
        menuItems.add(new MenuItem("Vegetable Soup", 22.0));
        menuItems.add(new MenuItem("Tiramisu", 25.0));
        menuItems.add(new MenuItem("Chocolate Cake", 28.0));
        menuItems.add(new MenuItem("Espresso", 12.0));
        menuItems.add(new MenuItem("Cappuccino", 15.0));
        menuItems.add(new MenuItem("Fresh Orange Juice", 18.0));
        menuItemRepository.saveAll(menuItems);

        // 3. Initialize Restaurant Tables (10+)
        List<RestaurantTable> tables = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            TableStatusEnum status = i % 3 == 0 ? TableStatusEnum.occupied : TableStatusEnum.free;
            tables.add(new RestaurantTable(i, status));
        }
        tableRepository.saveAll(tables);

        // 4. Initialize Chefs (10+)
        List<Chef> chefs = new ArrayList<>();
        chefs.add(new Chef("Gordon Ramsay", "5.0", 45, "Italian Cuisine"));
        chefs.add(new Chef("Jamie Oliver", "4.8", 34, "British Cuisine"));
        chefs.add(new Chef("Marco Pierre", "4.9", 43, "French Cuisine"));
        chefs.add(new Chef("Wolfgang Puck", "4.7", 25, "Austrian Cuisine"));
        chefs.add(new Chef("Emeril Lagasse", "4.6", 54, "Creole Cuisine"));
        chefs.add(new Chef("Bobby Flay", "4.8", 38, "American Cuisine"));
        chefs.add(new Chef("Rachael Ray", "4.5", 36, "Comfort Food"));
        chefs.add(new Chef("Alain Ducasse", "5.0", 46, "Mediterranean Cuisine"));
        chefs.add(new Chef("Thomas Keller", "4.9", 25, "Modern Cuisine"));
        chefs.add(new Chef("Massimo Bottura", "5.0", 46, "Italian Cuisine"));
        chefs.add(new Chef("Heston Blumenthal", "4.8", 64, "Molecular Gastronomy"));
        chefRepository.saveAll(chefs);

        // 5. Initialize Servers (10+)
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("Alice Cooper", "4.7", 28, "Senior Waiter"));
        servers.add(new Server("Bob Dylan", "4.5", 25, "Waiter"));
        servers.add(new Server("Charlie Parker", "4.8", 32, "Head Waiter"));
        servers.add(new Server("Diana Ross", "4.6", 27, "Waitress"));
        servers.add(new Server("Elvis Presley", "4.9", 35, "Senior Waiter"));
        servers.add(new Server("Freddie Mercury", "4.7", 29, "Waiter"));
        servers.add(new Server("Grace Kelly", "4.8", 31, "Waitress"));
        servers.add(new Server("Harry Styles", "4.5", 23, "Junior Waiter"));
        servers.add(new Server("Iris Apfel", "4.6", 26, "Waitress"));
        servers.add(new Server("Jack Black", "4.7", 30, "Waiter"));
        servers.add(new Server("Kate Moss", "4.8", 33, "Senior Waitress"));
        serverRepository.saveAll(servers);

        // 6. Initialize Orders (10+)
        // 6. Initialize Orders (10+)
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Customer customer = customers.get(i % customers.size());
            RestaurantTable table = tables.get(i % tables.size());
            OrderStatusEnum status = i % 3 == 0 ? OrderStatusEnum.DELIVERED :
                    i % 3 == 1 ? OrderStatusEnum.PENDING :
                            OrderStatusEnum.CANCELLED;
            orders.add(new Order(customer, table, status));
        }
        orderRepository.saveAll(orders);


        // 7. Initialize Order Lines (10+)
        List<OrderLine> orderLines = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            // Add 2-3 items per order
            orderLines.add(new OrderLine(order, menuItems.get(i % menuItems.size()), 2));
            orderLines.add(new OrderLine(order, menuItems.get((i + 1) % menuItems.size()), 1));
            if (i % 2 == 0) {
                orderLines.add(new OrderLine(order, menuItems.get((i + 2) % menuItems.size()), 3));
            }
        }
        orderLineRepository.saveAll(orderLines);

        // 8. Initialize Order Assignments (10+)
        List<OrderAssignment> assignments = new ArrayList<>();
        List<Staff> allStaff = new ArrayList<>();
        allStaff.addAll(chefs);
        allStaff.addAll(servers);

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            // Assign a chef
            assignments.add(new OrderAssignment(order, chefs.get(i % chefs.size())));
            // Assign a server
            assignments.add(new OrderAssignment(order, servers.get(i % servers.size())));
        }
        orderAssignmentRepository.saveAll(assignments);

        // 9. Initialize Bills (10+)
        List<Bill> bills = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            double totalAmount = 100.0 + (i * 15.5); // Simulated total
            bills.add(new Bill(order, totalAmount));
        }
        billRepository.saveAll(bills);

        System.out.println("✅ Database initialized with sample data!");
        System.out.println("   - Customers: " + customerRepository.count());
        System.out.println("   - Menu Items: " + menuItemRepository.count());
        System.out.println("   - Tables: " + tableRepository.count());
        System.out.println("   - Chefs: " + chefRepository.count());
        System.out.println("   - Servers: " + serverRepository.count());
        System.out.println("   - Orders: " + orderRepository.count());
        System.out.println("   - Order Lines: " + orderLineRepository.count());
        System.out.println("   - Order Assignments: " + orderAssignmentRepository.count());
        System.out.println("   - Bills: " + billRepository.count());
    }
}