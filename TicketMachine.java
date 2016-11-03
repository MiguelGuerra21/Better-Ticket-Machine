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
    // The chance of getting a prize
    private int prize;
    //Maximum number of tickets that the machine is allowed to sell before error
    private int maxbilletes;
    //Contador de cosonas
    private int contador;
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, int premium,int billetesmaximos)
    {
        price = cost;
        balance = 0;
        total = 0;
        prize = premium;
        maxbilletes = billetesmaximos;
        contador = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
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
        if(amount > 0) {
            balance = balance + amount;
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
        if (prize == 1) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            
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
        }
        else if (prize == 0) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
        }
        else {
            System.out.println ("Error , premium can only be 1(if activated) or 0 (if desactivated)");
        }
        if (contador >= maxbilletes) {
            System.out.println("Billetes ya vendidos,vuelva mas tarde");
        }
    contador= contador + 1;
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
    /**
     * Metodo que vacia la maquina y devuelve la cantidad de dinero que había en la máquina.
     */
    public int emptyMachine()
    {
        int amountToRefund;
        amountToRefund = total;
        total = 0;
        return amountToRefund;
    }
    /**
     * Método que vacia la maquina solo si no hay nadie metiendo dinero, sino devuelve -1
     */
    public int emptyMachine2()  {
        if (balance == 0) {
             int amountToRefund;
             amountToRefund = balance;
             balance = 0;
             return amountToRefund;
            }
        else {
            return -1;
        }
}
}
