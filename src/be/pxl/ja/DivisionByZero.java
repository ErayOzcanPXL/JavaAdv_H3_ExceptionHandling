package be.pxl.ja;

public class DivisionByZero {

	public static void main(String[] args) {
		int a = (1 + 1) % 2;
		int b = 5;
        try {
            int c = b / a;
            System.out.println("Het resultaat is " + c);
        } catch (ArithmeticException exception) {
            System.out.println("Kan niet delen door 0");
        }
	}
}
