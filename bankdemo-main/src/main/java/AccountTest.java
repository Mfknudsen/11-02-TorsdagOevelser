import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private List<Transaction> t1;
    private Customer c1;

    @BeforeEach
    void setUp() {
        c1 = new Customer("Test");
        t1 = new ArrayList<>();
    }

    @Test
    void getBalance() {
        t1.add(new Transaction(300, new Date()));
        t1.add(new Transaction(-100, new Date()));

        int i = 0;
        for (Transaction t: t1) {
            i += t.getAmount();
        }

        assertEquals(200,i);
    }

    @Test
    void withDrawAmount() {
        t1.add(new Transaction(200, new Date()));

        assertEquals(1, t1.size());
        assertEquals(t1.get(0).getAmount(), 200);
    }

    @Test
    void depositAmount() {
        t1.add(new Transaction(-200, new Date()));

        assertEquals(1, t1.size());
        assertEquals(t1.get(0).getAmount(), -200);
    }
}