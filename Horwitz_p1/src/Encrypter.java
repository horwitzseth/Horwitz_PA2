/*
    Assign each digit to an integer variable

    Add seven to each digit and then mod that number by 10

    Switch digit one with digit three and digit two with digit four

    Multiply each by their tens place value and then add them together to get the encrypted value

    Return the value of encrypted number
*/

public class Encrypter {
    public static int encrypt (int num) {
        int digit1, digit2, digit3, digit4, sub, encrypted;

        digit1 = num / 1000 % 10;
        digit2 = num / 100 % 10;
        digit3 = num / 10 % 10;
        digit4 = num % 10;

        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;

        sub = digit1;
        digit1 = digit3;
        digit3 = sub;
        sub = digit2;
        digit2 = digit4;
        digit4 = sub;

        encrypted = (digit1 * 1000) + (digit2 * 100) + (digit3 * 10) + digit4;
        return encrypted;
    }
}
