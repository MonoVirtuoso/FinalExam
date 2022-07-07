package FinalExamJava;

import java.util.Scanner;
import java.util.ArrayList;


public class SectionA {


    public static void main (String[]args)
	{
        SectionA method = new SectionA();
        
        String userInput, password, adminPassword = "1EE7"; 
        int userChoice = 1, userAnswer1 = 10, userAnswer2 = 10, a = 0, b=0;
        ArrayList<String> VehicleData = new ArrayList<String>(); //User to store specific parts of user data; names, age, email, etc.
        ArrayList<ArrayList<String>> VehicleLogs = new ArrayList<ArrayList<String>>(); //Used in order to store entirety of user data
        ArrayList<String> ManagerData = new ArrayList<String>(); //User to store specific parts of user data; names, age, email, etc.
        ArrayList<ArrayList<String>> ManagerLogs = new ArrayList<ArrayList<String>>(); //Used in order to store entirety of user data
        Scanner ue = new Scanner (System.in);
        System.out.println("Welcome to ABC Transportation Vehicle Registry!\n\n");
        while (userAnswer1 != 0) 
        {
            System.out.println("1. Log in as Admin\n2. Log in as Manager\n3. Log in as Visitor\n0. Exit");
            userAnswer1 = method.verifyInputInt(0, 3);

            switch (userAnswer1) {
                case 1:      
                    System.out.println("Password: ");
                    password = ue.next();
                    password.equals(adminPassword);
                    while (password.equals(adminPassword) == false)
                    {
                        System.out.println("Invalid password, please try again or enter 0 to return to main menu: ");
                        password = ue.next();
                    }
                    while (userAnswer2 != 0)
                    {
                        userChoice = 1;
                        System.out.println("\n1. Create Manager\n2. New Truck\n3. Search Truck\n4. Truck Status\n5. Contact Requests\n0. Return to log in menu\n");
                        userAnswer2 = method.verifyInputInt(0, 5);
                        switch (userAnswer2) 
                        {
                            case 1:
                            String[] ManagerOutput = {"Date of Joining", "Salary", "Name:", "Age:", "Email:", "Address", "Contact No."};
                            while (userChoice != 0)
                            {
                                String aString = Integer.toString(a);
                                ManagerData.add(0,  aString);
                                for (int i = 0; i < 7; i++)
                                {
                                    System.out.println(ManagerOutput[i]);
                                    if (i == 0)
                                    {
                                        userInput = ue.nextLine();
                                    }
                                    if (i == 1 || i == 3 || i == 6) 
                                    {
                                        userInput = method.verifyInput();
                                    }
                                    else
                                    {
                                        userInput = ue.nextLine();
                                    }
                                    ManagerData.add(userInput);
                                }
                                ManagerLogs.add(ManagerData);
                                System.out.println("Is the following information correct?");
                                System.out.println(ManagerLogs.get(a)); 
                                System.out.print("\n\nEnter 1 if you would like to restart and change any wrong information or enter 0 to continue: ");
                                userChoice = method.verifyInputInt(0, 1);
                                if (userChoice == 1)
                                {
                                    ManagerLogs.remove(a);
                                    ManagerData.clear();
                                }

                            }
                            a++;
                            break;

                            case 2:
                            System.out.println("Please enter the the necessary information regarding your vehicle.\n\n");
                            String[] VehicleOutput = {"Truck Owner Name:", "Age:", "Email:", "Address", "Contact No.", "Name of Insurance:", 
                            "Transport Services Status:"}; //Used in order to create preset questions to be printed out

                            while (userChoice != 0) 
                            {
                                String bString = Integer.toString(b);
                                VehicleData.add(0,  bString);
                                for (int i = 0; i < 5; i++){
                                    System.out.println(VehicleOutput[i]);
                                    if (i == 4 || i == 1) {
                                        userInput = method.verifyInput();
                                        VehicleData.add(userInput);
                                    }
                                    else
                                    {
                                        userInput = ue.nextLine();
                                        VehicleData.add(userInput);
                                    }
                                }
                                VehicleLogs.add(VehicleData);
                                System.out.println("Is the following information correct?");
                                System.out.println(VehicleLogs.get(b)); //Think just need to screenshot dy 
                                System.out.print("\n\nEnter 1 if you would like to restart and change any wrong information or enter 0 to continue: ");
                                userChoice = method.verifyInputInt(0, 1);
                                if (userChoice == 1)
                                {
                                    VehicleLogs.remove(b);
                                    VehicleData.clear();
                                }

                            }
                            b++;
                            break;

                            case 3:
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));


                            }

                            


                        }
                    }


                }

        }
        System.out.println("Thank you for using ABC Transport's Vehicle Registry! Have a nice day! :D");
    }

    public String verifyInput() //Used to verify answers that only require integers
	{

        Boolean checker = false;
        String usrEntry = "Empty"; //To initialize the String.
        int usrInput = 0;
        Scanner kb = new Scanner(System.in);

		while(checker == false)
		{
			try
			{
				usrEntry = kb.nextLine(); 
                usrInput = Integer.parseInt(usrEntry); //Attempts to parse the string into integer
                checker = true;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid entry. Please Try again:");
                checker = false; 
			}
		}

        return (usrEntry);

    }

    public int verifyInputInt(int x, int y)
	{
        int usrInput = -1;
        Scanner kb = new Scanner(System.in);

		while(usrInput < x || usrInput > y)
		{
			try
			{
				System.out.print("\nEnter your selection : \n");
				usrInput = Integer.parseInt(kb.nextLine()); 
                if (usrInput < x || usrInput > y)
                    {
                        System.out.println("Invalid Selection. Please Try again.");
                    }
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Selection. Please Try again.");
			}
		}

        return (usrInput);

    }


    
    
}


