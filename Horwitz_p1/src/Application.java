import java.util.Scanner;

/*
    Scan in number to encrypt and assign it to num

    Encrypt num and assign it to num

    Print num
*/

public class Application {
    public static void main (String[] args) {
        int num;
        Scanner In = new Scanner(System.in);

        System.out.print("Please input number to encrypt: ");
        num =  In.nextInt();

        num  = Encrypter.encrypt(num);

        System.out.printf("%04d\n", num);
    }
}
