package week_1.assigment_problems;

public class WarehouseInventoryBalancer {

    public static void main(String[] args) {

        int[] inventory = {10, 25, 15, 40, 20};

        int total = 0;

        for (int quantity : inventory) {
            total += quantity;
        }

        double average = (double) total / inventory.length;

        System.out.println("Total inventory: " + total);
        System.out.println("Average inventory: " + average);

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] > average) {
                System.out.println(
                    "Warehouse " + (i + 1) + " is above average."
                );
            }
        }
    }
}
