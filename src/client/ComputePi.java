package client;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.math.BigDecimal;
import compute.Compute;

public class ComputePi {
    public static void main(String args[]) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
        	String name = "Compute";
        	int exit = -1;
        	while (exit == -1) {
	        	System.out.println("1) Compute Pi,    2) Compute Primes,     3) Exit");
	        	System.out.print("Select one: ");
	        	Scanner input1 = new Scanner(System.in);
	        	int selectTask = input1.nextInt();
        		if (selectTask == 1) {
            		Scanner s = new Scanner(System.in);
            		System.out.print("Number of Decimal Places: ");
                	int digits = s.nextInt();
                    Registry registry = LocateRegistry.getRegistry("localhost");
                    Compute comp = (Compute) registry.lookup(name);
                    Pi task = new Pi(digits);
                    BigDecimal pi = comp.executeTask(task);
                    System.out.println(pi);
            	}
        		else if (selectTask == 2) {
            		Scanner s1 = new Scanner(System.in);
        			System.out.print("Minimum Value: ");
        			int min = s1.nextInt();
        			Scanner s2 = new Scanner(System.in);
        			System.out.print("Maximum Value: ");
        			int max = s2.nextInt();
        			Registry registry = LocateRegistry.getRegistry("localhost");
        			Compute comp1 = (Compute) registry.lookup(name);
        			Prime task1 = new Prime(min, max);
        			String prime = comp1.executeTask(task1);
        			System.out.println(prime);
            	}
        		else if (selectTask == 3) {
            		exit = 1;
            	}
        		else {
        			System.out.println("Please enter a valid number.");
        		}
        	}
        	System.out.println("Have a nive day!");
        }
        catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}