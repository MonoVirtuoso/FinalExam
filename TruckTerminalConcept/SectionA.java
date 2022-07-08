package Life.FinalExamJava;

import java.util.Scanner;
import java.util.ArrayList;


public class SectionA {


    public static void main (String[]args)
	{
        SectionA method = new SectionA();
        
        String userInput = "", password, adminPassword = "1EE7"; 
        int userChoice = 1, userAnswer1 = 10, userAnswer2 = 10, userAnswer3 = 10, a = 0, b=0, c = 0, d = 0, e = 0, userAnswer, nameFlag = 0, userAnswer4 = 10, count = 0, branch1 = 0, branch2 = 0, branch3 = 0, branch4 = 0, branch5 = 0;
        ArrayList<String> VehicleData = new ArrayList<String>(); //User to store specific parts of user data; names, age, email, etc.
        ArrayList<String> VehicleLogs = new ArrayList<String>(); //Used in order to store entirety of user data
        ArrayList<String> ManagerData = new ArrayList<String>(); //User to store specific parts of user data; names, age, email, etc.
        ArrayList<String> ManagerLogs = new ArrayList<String>(); //Used in order to store entirety of user data
        ArrayList<String> ManagerContactLogs = new ArrayList<String>();
        ArrayList<String> VisitorData = new ArrayList<String>();
        ArrayList<String> VisitorLogs = new ArrayList<String>();
        ArrayList<String> VisitorContactLogs = new ArrayList<String>();
        String[] Array = {}, Array2;
        userAnswer1 = 1;

        Scanner ue = new Scanner (System.in);
        while (userAnswer1 != 0) 
        {
            clearTerminal();
            userAnswer2 = 1;
            System.out.println("Welcome to ABC Transportation Vehicle Registry!\n\n");
            System.out.println("1. Log in as Admin\n2. Log in as Manager\n3. Log in as Visitor\n0. Exit");
            userAnswer1 = method.verifyInputInt(0, 3);

            switch (userAnswer1) 
            {
                case 1:      
                clearTerminal();
                System.out.println("Password: ");
                password = ue.next();
                if (!password.equals(adminPassword)){
                    while (password.equals(adminPassword) == false)
                    {
                        System.out.println("Invalid password, please try again or enter 0 to return to main menu: ");
                        password = ue.next();
                        if (password.equals("0")) 
                        {
                            break;
                        };
                    }
                }   
                if (password.equals("0")) 
                    {
                        break;
                    };
                while (userAnswer2 != 0)
                {
                    clearTerminal();
                    userChoice = 1;
                    System.out.println("\n1. Create Manager\n2. New Truck\n3. Search Truck\n4. Deactivate Truck Status\n5. Reactivate Truck Status\n6. Contact Requests\n7. View Managers\n0. Return to log in menu\n");
                    userAnswer2 = method.verifyInputInt(0, 7);
                    switch (userAnswer2) 
                    {
                        case 1:
                        clearTerminal();
                        String[] ManagerOutput = {"Date of Joining: ", "Salary: ", "First Name: ", "Last Name: ", "Age: ", "Email: ", 
                        "Address: ", "Contact No. :", "Username: ", "Branch Number: "};

                        while (userChoice != 0)
                        {
                            String aString = Integer.toString(a);
                            ManagerData.add(0,  aString);
                            for (int i = 0; i < 10; i++)
                            {
                                System.out.println(ManagerOutput[i]);
                                if (i == 1 || i == 4 || i == 7) 
                                {
                                    userInput = method.verifyInput();
                                }
                                else if (i == 10)
                                {
                                    while (Integer.parseInt(userInput) < 0 || Integer.parseInt(userInput) > 5)
                                    {
                                        userInput = method.verifyInput();
                                    }
                                }
                                else
                                {
                                    userInput = ue.next();
                                }
                                ManagerData.add(userInput);
                            }
                            StringBuffer stuff = new StringBuffer();
                            for (String s : ManagerData) {
                                stuff.append(s);
                                stuff.append(" ");
                            }
                            String str = stuff.toString();
                            ManagerLogs.add(str);
                            System.out.println("Is the following information correct?");
                            System.out.println(ManagerLogs.get(a)); 
                            System.out.print("\n\nEnter 1 if you would like to restart and change any wrong information or enter 0 to continue: ");
                            userChoice = method.verifyInputInt(0, 1);
                            if (userChoice == 1)
                            {
                                ManagerLogs.remove(a);
                                ManagerData.clear();
                            }
                            ManagerData.clear();

                        }
                        method.exit();
                        a++;
                        break;

                        case 2:
                        clearTerminal();
                        System.out.println("Please enter the the necessary information regarding your vehicle.\n\n");
                        String[] VehicleOutput = {"Truck Owner First Name:", "Truck Owner Last Name:", "Age:", "Email:", "Address:", "Contact No:", "Name of Insurance:", "Branch Number"}; //Used in order to create preset questions to be printed out

                        while (userChoice != 0) 
                        {
                            String bString = Integer.toString(b);
                            VehicleData.add(0,  bString);
                            for (int i = 0; i < 8; i++){
                                System.out.println(VehicleOutput[i]);
                                if (i == 5 || i == 2) 
                                {
                                    userInput = method.verifyInput();
                                }
                                else
                                {
                                    userInput = ue.next();
                                }
                                VehicleData.add(userInput);
                            }
                            VehicleData.add("Active");
                            StringBuffer stuff = new StringBuffer();
                            for (String s : VehicleData) {
                                stuff.append(s);
                                stuff.append(" ");
                                }
                                String str = stuff.toString();
                            VehicleLogs.add(str);
                            System.out.println("Is the following information correct?");
                            System.out.println(VehicleLogs.get(b)); //Think just need to screenshot dy 
                            System.out.print("\n\nEnter 1 if you would like to restart and change any wrong information or enter 0 to continue: ");
                            userChoice = method.verifyInputInt(0, 1);
                            if (userChoice == 1)
                            {
                                VehicleLogs.remove(b);
                                VehicleData.clear();
                            }
                            VehicleData.clear();

                        }
                        method.exit();
                        b++;
                        break;

                        case 3:
                        clearTerminal();
                        if(b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                        }
                        break;

                        case 4:
                        clearTerminal();
                        if (b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            System.out.println("Which truck do you wish to declare inactive?");
                            userAnswer = method.verifyInputInt(0, b - 1);
                            Array = VehicleLogs.get(userAnswer).split(" ");
                            System.out.println(Array);
                            VehicleData.clear();
                            for (int i = 0; i < 9; i++)
                            {
                                VehicleData.add(Array[i]);
                            }
                            VehicleData.add("Inactive");
                            StringBuffer stuff = new StringBuffer();
                            for (String s : VehicleData) {
                                stuff.append(s);
                                stuff.append(" ");
                                }
                                String str = stuff.toString();
                            VehicleLogs.set(userAnswer, str);
                            
                            System.out.println("Status has been changed successfully.");
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                        }
                        break;

                        case 5:
                        clearTerminal();
                        if (b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            System.out.println("Which truck do you wish to declare active?");
                            userAnswer = method.verifyInputInt(0, b - 1);
                            Array = VehicleLogs.get(userAnswer).split(" ");
                            System.out.println(Array);
                            VehicleData.clear();
                            for (int i = 0; i < 9; i++)
                            {
                                VehicleData.add(Array[i]);
                            }
                            VehicleData.add("Active");
                            StringBuffer stuff = new StringBuffer();
                            for (String s : VehicleData) {
                                stuff.append(s);
                                stuff.append(" ");
                                }
                                String str = stuff.toString();
                            VehicleLogs.set(userAnswer, str);
                            
                            System.out.println("Status has been changed successfully.");
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                        }
                        break;

                        case 6:
                        clearTerminal();
                        if (c > 0)
                        {
                            System.out.println("Manager Contact Logs:");
                            for (int i = 0; i < c; i++)
                            {
                            System.out.println(ManagerContactLogs.get(i));   
                            }
                        }
                        if (d > 0)
                        {
                            System.out.println("Visitor Contact Logs:");
                            for (int i = 0; i < d; i++)
                            {
                            System.out.println(VisitorContactLogs.get(i));   
                            }
                        }
                        if (c == 0)
                        {
                            System.out.println("No manager has attempted to contact the administrator at this time.\n");
                        }
                        if (d == 0)
                        {
                            System.out.println("No visitor has attempted to contact the administrator at this time.\n");
                        }
                        method.exit();
                        break;

                        case 7:
                        clearTerminal();
                        if(a > 0)
                        {
                            for (int i = 0; i < a; i++) 
                            {
                                System.out.println(ManagerLogs.get(i));
                            }
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No managers have been registered in the system yet.");
                            method.exit();
                        }
                        break;


                    }
                }
                break;

                case 2:
                nameFlag = 0;
                if (a == 0)
                {
                    clearTerminal();
                    System.out.println("No manager has been created yet, please contact the administrator for assistance.");
                    method.exit();
                    break;
                }
                System.out.println("Please enter your username: ");
                String userEntry = ue.next();
                if (0 < a)
                {

                    while (nameFlag != 1)
                    {
                        for (int i = 0; i < a; i++)
                            {
                            Array = ManagerLogs.get(i).split(" ");
                            System.out.println(Array [9]);
                            if (userEntry.equals(Array [9]))
                            {
                                nameFlag = 1;
                            }
                            e = i;
                        }
                        if (nameFlag != 1)
                        {
                            System.out.println("Please enter a correct username.");
                            break;
                        }
                    }
                }
                while (userAnswer3 != 0)
                {
                    clearTerminal();
                    System.out.println("1. Search truck\n2. Deactivate truck\n3. Reactivate truck\n4. Number of trucks in branch\n5. Output comparisons\n6. Contact administrator\n0. Exit");

                    userAnswer3 = method.verifyInputInt(0, 6);

                    switch (userAnswer3)
                    {
                        case 1:
                        clearTerminal();
                        if(b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                        }
                        break;

                        case 2:
                        clearTerminal();
                        if (b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            System.out.println("Which truck do you wish to declare inactive?");
                            userAnswer = method.verifyInputInt(0, b - 1);
                            Array = VehicleLogs.get(userAnswer).split(" ");
                            VehicleData.clear();
                            for (int i = 0; i < 9; i++)
                            {
                                VehicleData.add(Array[i]);
                            }
                            VehicleData.add("Inactive");
                            StringBuffer stuff = new StringBuffer();
                            for (String s : VehicleData) {
                                stuff.append(s);
                                stuff.append(" ");
                                }
                                String str = stuff.toString();
                            VehicleLogs.set(userAnswer, str);
                            
                            System.out.println("Status has been changed successfully.");
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                        }
                        break;

                        case 3:
                        clearTerminal();
                        if (b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            System.out.println("Which truck do you wish to declare active?");
                            userAnswer = method.verifyInputInt(0, b - 1);
                            Array = VehicleLogs.get(userAnswer).split(" ");
                            VehicleData.clear();
                            for (int i = 0; i < 9; i++)
                            {
                                VehicleData.add(Array[i]);
                            }
                            VehicleData.add("Active");
                            StringBuffer stuff = new StringBuffer();
                            for (String s : VehicleData) {
                                stuff.append(s);
                                stuff.append(" ");
                                }
                                String str = stuff.toString();
                            VehicleLogs.set(userAnswer, str);
                            
                            System.out.println("Status has been changed successfully.");
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                        }
                        break;

                        case 4:
                        clearTerminal();
                        for (int i = 0; i < b; i++)
                        {
                            Array = ManagerLogs.get(e).split(" ");
                            Array2 = VehicleLogs.get(i).split(" ");
                            if (Array2[8].equals(Array [10]))
                            {
                                count++;
                            }
                        }
                        System.out.println("The number of trucks in your branch is " + count);
                        method.exit();
                        break;


                        case 5:
                        clearTerminal();
                        for (int i = 0; i < b; i++)
                        {
                            Array2 = VehicleLogs.get(i).split(" ");
                            if (Array2[8].equals("1"))
                            {
                                branch1++;
                            }
                        }
                        for (int i = 0; i < b; i++)
                        {
                            Array2 = VehicleLogs.get(i).split(" ");
                            if (Array2[8].equals("2"))
                            {
                                branch2++;
                            }
                        }
                        for (int i = 0; i < b; i++)
                        {
                            Array2 = VehicleLogs.get(i).split(" ");
                            if (Array2[8].equals("3"))
                            {
                                branch3++;
                            }
                        }
                        for (int i = 0; i < b; i++)
                        {
                            Array2 = VehicleLogs.get(i).split(" ");
                            if (Array2[8].equals("4"))
                            {
                                branch4++;
                            }
                        }
                        for (int i = 0; i < b; i++)
                        {
                            Array2 = VehicleLogs.get(i).split(" ");
                            if (Array2[8].equals("5"))
                            {
                                branch5++;
                            }
                        }

                        System.out.println ("Branch 1: " + branch1 + "\nBranch 2: " + branch2 + "\nBranch 3: " + branch3 + "\nBranch 4: " + branch4 + "\nBranch 5: " + branch5);
                        method.exit();
                        break;
                        

                        case 6:
                        clearTerminal();
                        System.out.println("Your attempt to contact the administrator has been saved and the administrator has been notified.");
                        String loggingData = ManagerLogs.get(e);
                        ManagerContactLogs.add(loggingData);
                        c++;
                        method.exit();
                        break;

                        case 0:
                            break;
                        


                    }
                }
                break;

                case 3:
                clearTerminal();
                VisitorData.clear();
                System.out.println("Please enter your first name:");
                userInput = ue.next();
                VisitorData.add(userInput);
                System.out.println("Please enter your last name:");
                userInput = ue.next();
                VisitorData.add(userInput);
                System.out.println("Please enter your phone number:");
                userInput = method.verifyInput();
                VisitorData.add(userInput);
                StringBuffer stuff = new StringBuffer();
                for (String s : VisitorData) 
                {
                    stuff.append(s);
                    stuff.append(" ");
                }
                String str = stuff.toString();
                VisitorLogs.add(str);

                userAnswer4 = 1;

                while (userAnswer4!=0)
                    {
                    clearTerminal();    
                    System.out.println("1. View trucks\n2. View services\n3. Contact administrator\n0. Exit");

                    userAnswer4 = method.verifyInputInt(0, 3);

                    switch (userAnswer4)
                    {
                        case 1:
                        clearTerminal();
                        if(b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                            break;
                        }

                        case 2:
                        clearTerminal();
                        if(b > 0)
                        {
                            for (int i = 0; i < b; i++) 
                            {
                                System.out.println(VehicleLogs.get(i));
                            }
                            method.exit();
                            break;
                        }
                        else 
                        {
                            System.out.println("No trucks have been registered in the system yet.");
                            method.exit();
                            break;
                        }

                        case 3:
                        clearTerminal();
                        System.out.println("Your attempt to contact the administrator has been saved and the administrator has been notified.");
                        String loggingData = VisitorLogs.get(d);
                        VisitorContactLogs.add(loggingData);
                        d++;
                        method.exit();
                        break;


                        case 0:
                        clearTerminal();
                        break;

                    }
                }
                break;
                    


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

    public void exit()
    {
        int userInput;
        System.out.println("Enter 0 to return to the main menu: ");
        userInput = verifyInputInt(0, 0);
    }

    static void clearTerminal(){        
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    
    
}


