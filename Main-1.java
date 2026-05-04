import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayList<Inventory> inventoryList = new ArrayList<>();


        ArrayList<Inventory> userInventory = new ArrayList<>();


        inventoryList.add(new Inventory("Pencils", 2.99, 5, "Writing"));
        inventoryList.add(new Inventory("Notebooks", 4.99, 10, "Paper"));
        inventoryList.add(new Inventory("Pens", 3.49, 4, "Writing"));


        while (true) {
            System.out.println(" Touro Supply Store ");
            System.out.println("-------------------------");
            System.out.println("1. View School Inventory");
            System.out.println("2. Buy School Item");
            System.out.println("3. Delete School Item");
            System.out.println("4. Update Price");
            System.out.println("5. View by Type");
            System.out.println("6. View My Inventory");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Inventory item : inventoryList) {
                        System.out.println(item.getName() + " | $" + item.getPrice() + " | Quantity: " + item.getQuantity());
                        if (item.getQuantity() <= 3) {
                            System.out.println("  Low on stock for: " + item.getName());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Available items:");
                    for (Inventory item : inventoryList) {
                        System.out.println("- " + item.getName().toLowerCase() + " | $" + item.getPrice() + " | Qty: " + item.getQuantity());
                    }

                    System.out.print("Enter item name to purchase: ");
                    String buyName = scanner.nextLine().toLowerCase();
                    boolean itemFound = false;

                    for (Inventory item : inventoryList) {
                        if (item.getName().toLowerCase().equals(buyName)) {
                            itemFound = true;

                            System.out.print("How many to buy? ");
                            int buyQuantity = scanner.nextInt();
                            scanner.nextLine();

                            if (item.getQuantity() >= buyQuantity) {
                                item.reduceQuantity(buyQuantity);

                                boolean exists = false;
                                for (Inventory uItem : userInventory) {
                                    if (uItem.getName().equalsIgnoreCase(item.getName())) {
                                        uItem.addQuantity(buyQuantity);
                                        exists = true;
                                        break;
                                    }
                                }

                                if (!exists) {
                                    userInventory.add(new Inventory(item.getName(), item.getPrice(), buyQuantity, item.getType()));
                                }

                                System.out.println("Added to your inventory.");
                            } else {
                                System.out.println("Not enough stock available.");
                            }
                            break;
                        }
                    }

                    if (!itemFound) {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter item to delete: ");
                    String delName = scanner.nextLine().toLowerCase();
                    boolean deleted = false;

                    for (int i = 0; i < inventoryList.size(); i++) {
                        if (inventoryList.get(i).getName().toLowerCase().equals(delName)) {
                            inventoryList.remove(i);
                            System.out.println("Item deleted.");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter item to update price: ");
                    String updateName = scanner.nextLine().toLowerCase();
                    boolean updated = false;

                    for (Inventory item : inventoryList) {
                        if (item.getName().toLowerCase().equals(updateName)) {
                            System.out.print("New price: ");
                            double newPrice = scanner.nextDouble();
                            scanner.nextLine();
                            item.updatePrice(newPrice);
                            System.out.println("Price updated.");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Item not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter type to filter by: ");
                    String type = scanner.nextLine();

                    for (Inventory item : inventoryList) {
                        if (item.getType().equalsIgnoreCase(type)) {
                            System.out.println(item.getName() + " | $" + item.getPrice() + " | Qty: " + item.getQuantity());
                        }
                    }
                    break;

                case 6:
                    System.out.println("--- Your Inventory ---");
                    for (Inventory item : userInventory) {
                        System.out.println(item.getName() + " | Qty: " + item.getQuantity());
                    }
                    break;

                case 7:
                    System.out.println("Bye now!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Not a valid option.");
            }
        }
    }
}
