package OOPs;
/*
 *  Create any application using all oops concept
 *  
 */
import java.util.Scanner;

// Bank Interface defining the methods for banking operations
interface Bank
{
	public void create_acc() ;
	public void show_detail();
	public void deposit();
	public void withdraw() ;
	public void Balance();
	public void roi();
	public void display();	
}

//Abstract class providing default implementations for methods in the Bank interface
	abstract class BankProcess implements Bank
	{
		
		// Default implementations for methods, to be overridden in subclasses
		
		//method to create an account
		@Override
		public void create_acc() 
		{
			// TODO Auto-generated method stub
		}

		//method to show details of an account
		@Override
		public void show_detail() 
		{
			// TODO Auto-generated method stub	
		}

		//method to Deposit money 
		@Override
		public void deposit() 
		{
			// TODO Auto-generated method stub
		}

		//method to withdraw money
		@Override
		public void withdraw() 
		{
			// TODO Auto-generated method stub
		}

		//method to check balance
		@Override
		public void Balance() 
		{
			// TODO Auto-generated method stub
		}
		
		//method to check rate of interest
		@Override
		public void roi()
		{
			// TODO Auto-generated method stub
			
		}
		
		//method to display rate of interest
		@Override
		public void display()
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	//Haveacc class has methods and data member for person having an account in our bank
	class HaveAcc extends BankProcess
	{
		
		String Name;
		private long Acc_no;
		int Age;
		private long Aadhar_no;
		private int Pin;
		private double Balance;
		long Phn_no;
		String Address;
		int roi=3;//rate of interest will be 3 if they have account in our bank
		int years;//for how many years u want loan
		int savingacc_interest;
		int invested_amount;
		char ans;
		Scanner sc = new Scanner(System.in);
		 
		//Getter  and setter for private fields
		public long getAcc_no() {
			return Acc_no;
		}

		public void setAcc_no(long acc_no) {
			Acc_no = acc_no;
		}

		public long getAadhar_no() {
			return Aadhar_no;
		}

		public void setAadhar_no(long aadhar_no) {
			Aadhar_no = aadhar_no;
		}

		public Double getBalance() {
			return Balance;
		}

		public void setBalance(Double balance) {
			Balance = balance;
		}
		
		public int getPin() {
			return Pin;
		}

		public void setPin(int pin) {
			Pin = pin;
		}
		
		//method for banking operation
		public void bankfunction() 
		{
			//create acc method
			create_acc();
			//do-while used to repeat the process if wanted
			do
			{
			System.out.println("\n1:Show Details of User");
			System.out.println("2:Deposit");
			System.out.println("3:Withdraw");
			System.out.println("4: Balance Check");
			System.out.println("5:Loan process");
			System.out.println("6:Display Total Amount Of loan With the rate of interest");
			System.out.println("\nSelect your choice from above list");
			int ch=sc.nextInt();
			switch (ch) //switch case to perform specific operation at a time
			{
			case 1:
				show_detail();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				Balance();
				break;
			case 5:
				roi();
				break;
			case 6:
				display();
				break;
			default:
				System.out.println("You Have Enter Wrong Input :");
				break;
			}
			System.out.println("\nDo you want to do more process : (yes/no)");
			ans=sc.next().charAt(0);
			}
			while(ans=='y' || ans=='Y');
			
		}
		
	
	}
	
	
	// Class representing an account with an existing account, extending HaveAcc
	//it has all the function for the people having account in our bank
	class HaveAcc_F extends HaveAcc implements Bank
	{
		 // Overriding the create_acc method for additional functionality
		@Override
		public void create_acc() //creating an acc
		{
			System.out.println("\nEnter your Name :");
			Name=sc.next();
			System.out.println("Enter Your Account no : ");
			setAcc_no(sc.nextLong());
			System.out.println("Enter Your Age : ");
			Age=sc.nextInt();
			System.out.println("Enter your aadhar no :");
			setAadhar_no(sc.nextLong());	
			System.out.println("Enter your Address no :");
			Address=sc.next();
			System.out.println("Enter your phone no :");
			Phn_no=sc.nextLong();
			System.out.println("Enter the amount at which u want to open acc  : ");
			setBalance(sc.nextDouble());
			System.out.println("ENter your pin : ");
			setPin(sc.nextInt());
		}

		@Override
		public void show_detail() //showing details
		{
			System.out.println("\nAccountholder Name :" +Name);
			System.out.println("Account no : "+getAcc_no());
			System.out.println("AccountHolder Age : "+Age);
			System.out.println("AccountHolder aadhar no :"+getAadhar_no());
			System.out.println("AccountHolder Address  :"+Address);
			System.out.println("AccountHolder phone no :"+Phn_no);
			System.out.println("AccountHolder Balance  : "+getBalance());
			System.out.println("AccountHolder pin : "+getPin());
			
		}
		
		public void deposit() //Deposit money
		{
			System.out.println("\nEnter Your Pin for Verifaication :");
			int N_pin=sc.nextInt();
			int Pin=getPin();
			if(Pin==N_pin)
			{
				System.out.println("\nEnter the amount u want to  deposite :");
				Double Amount=sc.nextDouble();
				double final_amount=getBalance();
				setBalance(final_amount+Amount);
				System.out.println("Your amount has Deposited ");
				System.out.println("\nYour total Balance is :"+getBalance());
			}
			else
			{
				System.out.println("\nYou have enter Wrong pin:");
			}
		}
		
		@Override
		public void withdraw() //withdraw money
		{
			System.out.println("Enter Your Pin for Verifaication :");
			int N_pin=sc.nextInt();
			int Pin=getPin();
			if(Pin==N_pin)
			{
				System.out.println("Enter the amount u want to  Withdraw :");
				Double Amount=sc.nextDouble();
				double final_amount=getBalance();
				if(final_amount>=Amount)
				{
					setBalance(final_amount-Amount);
					System.out.println("Your amount has Withdraw : "+Amount);
					System.out.println("\nYour total Balance is :"+getBalance());
				}
				else
				{
					System.out.println("You have insufficient balance " +final_amount);
					return;
				}
			}
			else
			{
				System.out.println("\nYou have enter Wrong pin:");
			}
			
		}
		
		@Override
		public void Balance() //check balance
		{
			System.out.println("Enter Your Pin for Verifaication :");
			int N_pin=sc.nextInt();
			int Pin=getPin();
			if(Pin==N_pin)
			{
				System.out.println("\nYour Total Balance is :"+getBalance());
			}
			else
			{
				System.out.println("\nInvalid Pin ");
			}
			
		}
		
		@Override
		public void roi() //checking for loan
		{
			if(Age>=21)
			{
				System.out.println("\nEnter the amount That you want as a loan : ");
				invested_amount=sc.nextInt();
				System.out.println("\nEnter how many years of time u want Loan : ");
				years=sc.nextInt();
				savingacc_interest= (invested_amount*roi*years/100);
				System.out.println("Your loan has succesfully passed ");
			}
			else
			{
				System.out.println("You are not eligible to get loan because your age is less than 21 ");
				return;
			}
			
		}
		
		public void display()// displaying loan details
		{
			System.out.println("\nAccountholder Name :" +Name);
			System.out.println("Account no : "+getAcc_no());
			System.out.println("AccountHolder Age : "+Age);
			System.out.println("AccountHolder aadhar no :"+getAadhar_no());
			System.out.println("AccountHolder Address  :"+Address);
			System.out.println("AccountHolder phone no :"+Phn_no); 
			System.out.println("\n*******Your Rate of interest will be**********");
			System.out.println("The  Amount  "+savingacc_interest+" is the extra amount that you have to pay as Rate Of Interest ");
			System.out.println("The total amount you have to pay after "+years+" years is : "+(savingacc_interest+invested_amount));
		}
	
	}
	

	// Class representing an account without an existing account, extending BankProcess
	class NoAcc extends BankProcess
	{
		
		String Name;
		int Age;
		String Address;
		long Aadhar_no;
		String Pan_no;
		Long Phone_no;
		
		int roi=7;//rate of interest will be 7 if they don't have account in our bank
		int years;
		int Noacc_interest;
		int invested_amount;
		Scanner sc = new Scanner(System.in);
		
		 // Constructor for initializing fields
		public NoAcc(String Name,int Age,String Address,Long Aadhar_no,String Pan_no,Long Phone_no) 
		{
			this.Name=Name;
			this.Age=Age;
			this.Address=Address;
			this.Aadhar_no=Aadhar_no;
			this.Pan_no=Pan_no;
			this.Phone_no=Phone_no;
		}
		
		@Override
		public void roi() //check rate of interest
		{
			
			if(Age>=21)
			{
				System.out.println("Enter the amount that u want as a loan : ");
				invested_amount=sc.nextInt();
				System.out.println("Enter how many years of time u want Loan : ");
				years=sc.nextInt();
				Noacc_interest= (invested_amount*roi*years/100);
			}
			else
			{
				System.out.println("You are not eligible to get loan because your age is less than 21 ");
				return;
			}
			
			display();
		}
		
		public void display() //display rate of interest
		{
			
			System.out.println("\nYour Name : "+Name);
			System.out.println("Your Age : "+Age);
			System.out.println("Your Address : "+Address);
			System.out.println("Your Aadhar no : "+Aadhar_no);  
			System.out.println("Your Pan no : "+Pan_no);
			System.out.println("Your phone no : "+Phone_no);
			System.out.println("\n*******Your Rate of interest will be**********");
			System.out.println("The Amount "+Noacc_interest+" is the extra amount that you have to pay as Rate Of Interest ");
			System.out.println("The total amount you have to pay after "+years+" years is : "+(Noacc_interest+invested_amount));
		}
	
	}
	

	// Main class for the Banking Application
	public class BankingApplication 
	{
	
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in);
			char answer;
			//do-while is used if we want to continue the process
			do 
			{
			System.out.println("DO you Want to Create an account in our Bank (y/n)");
			char ch=sc.next().charAt(0);
			switch (ch) //Switch case to make a choice
			{
			case 'y':
				HaveAcc_F ha = new HaveAcc_F();
				ha.bankfunction();
				break;
			case 'Y':
				HaveAcc_F ha1 = new HaveAcc_F();
				ha1.bankfunction();
				break;
				
			default:
				System.out.println("Do you want loan from our bank  (Yes/No):");//process if they dont exit account in our bank
				char ans=sc.next().charAt(0);
				switch (ans) //nested Switch case
				{
				case 'y':
					System.out.println("Enter your name :");
					String Name=sc.next();
					System.out.println("Enter Your Age :");
					int Age=sc.nextInt();
					System.out.println("Enter Your Address :");
					String Address=sc.next();
					System.out.println("Enter Your Aadhar No :");
					long Aadhar_no=sc.nextLong();
					System.out.println("Enter Your Pan No :");
					String Pan_no=sc.next();
					System.out.println("Enter Your Phone No :");
					long phone_no=sc.nextLong();
					NoAcc na = new NoAcc(Name, Age, Address, Aadhar_no,Pan_no, phone_no);
					na.roi();
					
					
					break;
				case 'Y':
					System.out.println("Enter your name :");
					 Name=sc.next();
					System.out.println("Enter Your Age :");
					 Age=sc.nextInt();
					System.out.println("Enter Your Address :");
					 Address=sc.next();
					System.out.println("Enter Your Aadhar No :");
					 Aadhar_no=sc.nextLong();
					System.out.println("Enter Your Pan No :");
					 Pan_no=sc.next();
					System.out.println("Enter Your Phone No :");
					 phone_no=sc.nextLong();
					NoAcc na1 = new NoAcc(Name, Age, Address, Aadhar_no,Pan_no, phone_no);
					na1.roi();
					
					
					break;
					

				default:
					
					break;
				}
				
				break;
			}
			System.out.println("\nDo you want to do more process : (yes/no)");
			answer=sc.next().charAt(0);
			}
			while(answer=='y' || answer=='Y');
			System.out.println("***********Thank you***********");
			System.out.println("***********Visit Again*********");
		}
	
	}
