package fundamental.operators.exercises.solutions;

public class ReferenceSolution {
    public static void main(String[] args) {
        int items = 29, capacity = 6;
        int full = items / capacity, remainder = items % capacity;
        boolean partial = remainder != 0;
        assert full == 4 && remainder == 5 && partial;
        assert 0 / 6 == 0 && 0 % 6 == 0 && 12 / 6 == 2 && 12 % 6 == 0 && 29 / 1 == 29;
        int attempts = 0;
        boolean a = false && ++attempts > 0;
        boolean b = true || ++attempts > 0;
        boolean c = true && ++attempts == 1;
        assert !a && b && c && attempts == 1;
        attempts = 0;
        a = false & ++attempts > 0; b = true || ++attempts > 0; c = true && ++attempts == 1;
        assert !a && b && !c && attempts == 2;
        attempts = 1;
        a = false && ++attempts > 0; b = true || ++attempts > 0; c = true && ++attempts == 1;
        assert !a && b && !c && attempts == 2;
        int age = 17;
        assert !(age >= 18 && age <= 60);
        age = 18; assert age >= 18 && age <= 60;
        age = 60; assert age >= 18 && age <= 60;
        age = 61; assert !(age >= 18 && age <= 60);
        age = -1; assert !(age >= 18 && age <= 60);
        age = 100; assert !(age >= 18 && age <= 60);
        int code = 507;
        int hundreds = code / 100, tens = code / 10 % 10, units = code % 10;
        assert hundreds == 5 && tens == 0 && units == 7 && hundreds + tens + units == 12;
        code = 7; assert code / 100 == 0 && code / 10 % 10 == 0 && code % 10 == 7;
        code = 0; assert code / 100 + code / 10 % 10 + code % 10 == 0;
        code = 999; assert code / 100 + code / 10 % 10 + code % 10 == 27;
        int unitPrice = 60_000, quantity = 2, percent = 10;
        boolean member = true;
        long subtotal = 1L * unitPrice * quantity;
        long discount = subtotal * percent / 100;
        long payable = subtotal - discount;
        boolean free = (member && payable >= 100_000) || payable >= 300_000;
        assert subtotal == 120_000 && discount == 12_000 && payable == 108_000 && free;
        payable = 99_999; assert !((true && payable >= 100_000) || payable >= 300_000);
        payable = 100_000; assert (true && payable >= 100_000) || payable >= 300_000;
        assert !((false && payable >= 100_000) || payable >= 300_000);
        payable = 299_999; assert !((false && payable >= 100_000) || payable >= 300_000);
        payable = 300_000; assert (false && payable >= 100_000) || payable >= 300_000;
        payable = 0; assert !((true && payable >= 100_000) || payable >= 300_000);
        subtotal = 1L * 1_000_000 * 10_000; discount = subtotal * 100 / 100;
        assert subtotal == 10_000_000_000L && subtotal - discount == 0;
        assert 101L * 1 / 100 == 1;
        System.out.println("OPR: OK");
    }
}
