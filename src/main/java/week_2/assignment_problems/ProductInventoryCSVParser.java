package week_2.assignment_problems;

public class ProductInventoryCSVParser {

    public static void main(String[] args) {

        String csvData =
                "101,Laptop,50\n" +
                "102,Keyboard,30\n" +
                "103,Mouse,45";

        String[] rows = csvData.split("\\n");

        System.out.println("Product Inventory:");

        for (String row : rows) {
            String[] data = row.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int quantity = Integer.parseInt(data[2]);

            System.out.println(
                    "ID: " + id +
                    " | Product: " + name +
                    " | Quantity: " + quantity
            );
        }
    }
}