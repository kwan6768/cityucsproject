public class Addition{
	public static void main(String args[])
	{
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);		


		System.out.println("Enter first integer: " + number1);
		//number1 = input.nextInt();

		System.out.println("Enter second integer: " + number2);
		//number2 = input.nextInt();

		System.out.println("The sum is " + (number1+number2) + ".");

		System.exit( 0 );
	}
}