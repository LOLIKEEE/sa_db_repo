package org.example;

import tables.Employee;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Scanner cin = new Scanner(System.in);
    private static final DatabaseOperation dbo = new DatabaseOperation();
    private static final Logger logger = new LoggerLibrary().getConfiguredLogger();

    public static void printMenu() {
        System.out.println("\nPLEASE SELECT THE OPERATIONS YOU WONT TO PERFORM:");
        System.out.println("1) PRINT ALL EMPLOYEES");
        System.out.println("2) ADD NEW EMPLOYEE");
        System.out.println("3) DELETE AN EMPLOYEE BY ID");
        System.out.println("4) UPDATE EMPLOYEES PHONE NUMBER");
        System.out.println("0) EXIT:");
        System.out.print("\nYOUR CHOICE - ");
    }

    public static void main(String[] args) {
        int userChoice;
        RUNNING : while(true) {
            printMenu(); // SHOW UP THE MENU
            try {
                if(cin.hasNext()) {
                    userChoice = Integer.parseInt(cin.next());
                    switch(userChoice) {
                        case 1 : {
                            logger.log(Level.INFO, "USER SELECTED OPTION 1");
                            dbo.printAllEmployees();
                            break;
                        }
                        case 2 : {
                            logger.log(Level.INFO, "USER SELECTED OPTION 2");
                            Employee newEmployee = new Employee();
                            newEmployee = newEmployee.createEmployee();
                            dbo.addNewEmployee(newEmployee);
                            break;
                        }
                        case 3 : {
                            logger.log(Level.INFO, "USER SELECTED OPTION 3");
                            System.out.print("\nENTER EMPLOYEE ID WHICH YOU WONT TO DELETE - ");
                            int employeeId = cin.nextInt();
                            dbo.deleteEmployee(employeeId);
                            break;
                        }
                        case 4 : {
                            logger.log(Level.INFO, "USER SELECTED OPTION 4");
                            System.out.print("\nENTER EMPLOYEE ID TO UPDATE HIS PHONE NUMBER- ");
                            int employeeId = cin.nextInt();

                            System.out.print("\nENTER NEW EMPLOYEES PHONE NUMBER: ");
                            String phoneNumber = cin.next();
                            dbo.updateEmployee(employeeId, phoneNumber);
                            break;
                        }
                        case 0 : {
                            logger.log(Level.INFO, "EXIT RUNNING");
                            break RUNNING;
                        }
                        default : {
                            logger.log(Level.WARNING, "USER SEND AN INVALID REQUEST");
                            break;
                        }
                    }
                } else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "WE HANDLED AN EXCEPTION : " + e);
            }
        }
    }
}