import java.util.Scanner;
public class Temperature_converter {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("\n\t******Welcome to Temperature Converter*****\n");
    System.out.println("-------------------------------------------------------");
	System.out.print("Enter value which you want to convert🖊️: ");
	float value = sc.nextFloat();
    System.out.println("========================================================");
	System.out.println("  Enter 1 for Celsius to Fahrenheit converter....");
    System.out.println("-------------------------------------------------------");
	System.out.println("  Enter 2 for Fahrenheit to Celsius converter....");
    System.out.println("========================================================");
	System.out.print("\nEnter your value here:  ");

	int ans = sc.nextInt();
	if (ans == 1) {
		float value1 = (float) ((value*(1.8))+32);
		System.out.print("Your conversion is here.. "+value1+"°F");
		}
	if (ans == 2) {
			float value2 = (float) (value-32);
			float value3 = (float) (value2*(5)/9);
			System.out.print("Your conversion is here.. "+value3+"°C");
		}

    if(ans>=3)   {
        System.out.println("📍Please Enter the Valid Number📍");
    } 
	System.out.println("\n\tThank You!!..");
	}
}