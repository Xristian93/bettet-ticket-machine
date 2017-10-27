/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The gift ticket
    private boolean gift;
    // The amount of tickets you want
    private int maxTicket;

    /**
     * Create a machine that issues tickets of the given price and also a gift ticket.
     */
    public TicketMachine(int cost, boolean machineGift, int numTicket)
    {
        price = cost;
        balance = 0;
        total = 0;
        gift = machineGift;
        maxTicket = numTicket;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Empty the money of the ticket machine
     */
    public int emptyMachine()
    {
        int actualMoney = -1;
        if (balance == 0) {
            actualMoney = balance + total;
            balance = 0;
            total = 0;
        }
        else {
            System.out.println ("No se puede vaciar la maquina porque hay una operación en curso.");
        }
        return actualMoney;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0 & maxTicket > 0) {
            balance = balance + amount;
        }
        else if (maxTicket == 0){
            System.out.println("You cannot insert money because you have sell all the tickets");
        }
        else {

            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price & maxTicket > 0){
            if(gift == false) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
                // Reduce the number of tickets allowed
                maxTicket -= 1;
            }
            else if (gift == true) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
                
                System.out.println("##################");
                // Simulate the printing of a gift ticket
                System.out.println("This ticket is a special gift ticket!!");
                System.out.println("##################");

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            }
        }

        else {
            System.out.println("You must insert at least: " +
                (price - balance) + " more cents.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
