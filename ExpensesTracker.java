package Project;

import java.util.ArrayList;

public class ExpensesTracker {
    ArrayList<Expenses> expenses;

    public ExpensesTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expenses expense) {
        expenses.add(expense);
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found. ");
        } else {
            for (Expenses expense : expenses) {
                expense.displayExpenses();
            }
        }
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expenses expense : expenses) {
            total += expense.amount;
        }
        return total;
    }
    public boolean expenseExists(int editId){
        for(Expenses expense :expenses){
            if (expense.id==editId){
                return true;
            }
        }
        return false;
    }
    public boolean editExpenseDescription(int editId, String description){
        for (Expenses expense :expenses){
            if( expense.id==editId){
                expense.description=description;
                return true;
            }
        }
        return false;
    }
    public boolean editExpenseAmount(int editId, double amount) {
        for (Expenses expense : expenses) {
            if (expense.id == editId) {
                expense.amount = amount;
                return true;
            }
        }
        return false;
    }

    public boolean editExpenseCategory(int editId, String category) {
        for (Expenses expense : expenses) {
            if (expense.id == editId) {
                expense.category = category;
                return true;
            }
        }
        return false;
    }
}
