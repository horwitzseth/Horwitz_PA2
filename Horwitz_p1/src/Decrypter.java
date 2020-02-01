/*
    Assign each digit to an integer variable

    Add three to each digit and then mod that number by 10

    Switch digit one with digit three and digit two with digit four

    Multiply each by their tens place value and then add them together to get the encrypted value

    Return the value of decrypted number
*/

public class Decrypter {
    public static int decrypt (int encrypted) {
        int digit1, digit2, digit3, digit4, sub, decrypted;

        digit1 = encrypted / 1000 % 10;
        digit2 = encrypted / 100 % 10;
        digit3 = encrypted / 10 % 10;
        digit4 = encrypted % 10;

        digit1 = (digit1 + 3) % 10;
        digit2 = (digit2 + 3) % 10;
        digit3 = (digit3 + 3) % 10;
        digit4 = (digit4 + 3) % 10;

        sub = digit1;
        digit1 = digit3;
        digit3 = sub;
        sub = digit2;
        digit2 = digit4;
        digit4 = sub;

        decrypted = (digit1 * 1000) + (digit2 * 100) + (digit3 * 10) + digit4;
        return decrypted;
    }
}
