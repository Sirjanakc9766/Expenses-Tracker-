package Project;

public class Expenses {
    int id;
    double amount;
    String category;
    String description;
    String date;

    public Expenses(int id, double amount, String category, String description, String date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public void displayExpenses() {
        System.out.println("Enter  ID: " + id);
        System.out.println("Enter  Amount: " + amount);
        System.out.println("Enter Category: " + category);
        System.out.println("Enter Date: " + date);
        System.out.println("--------------------------------------------");

    }
}
