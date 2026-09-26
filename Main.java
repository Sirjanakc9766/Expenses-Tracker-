package Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpensesTracker tracker = new ExpensesTracker();

        int choice;
        int id = 1;

        do {
            System.out.println("=====================================");
            System.out.println("Expenses Tracker Management System");
            System.out.println("=====================================");
            System.out.println("1. ADD EXPENSES");
            System.out.println("2. VIEW EXPENSES");
            System.out.println("3. EDIT EXPENSES");
            System.out.println("4. VIEW TOTAL EXPENSES");
            System.out.println("5. EXIT");
            System.out.println("=====================================");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("Enter expenses amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Enter category: ");
                    String category = sc.nextLine();

                    System.out.println("Enter description: ");
                    String description = sc.nextLine();

                    LocalDateTime now = LocalDateTime.now();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    String date = now.format(formatter);

                    Expenses expense = new Expenses(id, amount, category, description, date);

                    tracker.addExpense(expense);

                    System.out.println("\nExpense added successfully!");

                    id++;
                    break;

                case 2:

                    System.out.println("\n============== ALL EXPENSES ================");

                    tracker.viewExpenses();

                    break;

                case 3:
                    System.out.println("Enter expenses ID to edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine();

                    if (!tracker.expenseExists(editId)) {
                        System.out.println("Expense ID not found.");
                        break;
                    }
                    System.out.println("What you want to change? :");
                    System.out.println("1. Amount");
                    System.out.println("2. Category");
                    System.out.println("3. Description");
                    System.out.println("4. Cancel");

                    System.out.println("Enter your choice: ");
                    int editchoice = sc.nextInt();
                    sc.nextLine();

                    switch (editchoice) {
                        case 1:
                            System.out.println("Enter new  amount: ");
                            double editAmount = sc.nextDouble();
                            sc.nextLine();

                            tracker.editExpenseAmount(editId, editAmount);
                            System.out.println("Amount updated successfully! ");
                            break;
                        case 2:
                            System.out.println("Enter new category: ");
                            String editCategory = sc.nextLine();

                            tracker.editExpenseCategory(editId, editCategory);

                            System.out.println("Category updated successfully! ");
                            break;
                        case 3:
                            System.out.println("Enter new description: ");
                            String newDescription = sc.nextLine();

                            tracker.editExpenseDescription(editId, newDescription);

                            System.out.println("Description updated successfully!");
                            break;
                        case 4:
                            System.out.println("Edit cancelled.");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 4:

                    double totalExpenses = tracker.getTotalExpenses();

                    System.out.println("\n=====================================");
                    System.out.println("TOTAL EXPENSES: " + totalExpenses);
                    System.out.println("=====================================");

                    break;

            case 5:

                System.out.println("Thank you for using Expenses Tracker!");
                break;

            default:

                System.out.println("Invalid choice. Please try again.");
        }

        } while (choice != 5);

        sc.close();
    }
}