package creditcard.search;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CreditCardSearchTest {

    private CreditCardSearch creditCardSearch;

    @Before
    public void setUp() {
        creditCardSearch = new CreditCardSearch();
        creditCardSearch.addCreditCardsFile(new File("creditCards1.txt"));
        creditCardSearch.addCreditCardsFile(new File("creditCards2.txt"));
    }

    @Test
    public void assert_creditcards_found_in_2_files() throws IOException {
        final Set<String> creditcards = creditCardSearch.searchForMatchesInAllFiles();

        assertNotNull(creditcards);
        assertEquals(3, creditcards.size());
        assertTrue("5154933849210203", creditcards.contains("5154933849210203"));
        assertTrue("5272835420269481", creditcards.contains("5272835420269481"));
        assertTrue("5572941594858518", creditcards.contains("5572941594858518"));
    }

    @Test
    public void assert_creditcards_found_in_3_files() throws IOException {
        creditCardSearch.addCreditCardsFile(new File("creditCards3a.txt"));

        final Set<String> creditcards = creditCardSearch.searchForMatchesInAllFiles();

        assertNotNull(creditcards);
        assertEquals(2, creditcards.size());
        assertTrue("5154933849210203", creditcards.contains("5154933849210203"));
        assertTrue("5272835420269481", creditcards.contains("5272835420269481"));
    }

    @Test
    public void assert_creditcards_not_found_in_3_files() throws IOException {
        creditCardSearch.addCreditCardsFile(new File("creditCards3b.txt"));

        final Set<String> creditcards = creditCardSearch.searchForMatchesInAllFiles();

        assertNotNull(creditcards);
        assertTrue(creditcards.isEmpty());
    }

    @Test
    public void assert_creditcards_found_in_4_files() throws IOException {
        creditCardSearch.addCreditCardsFile(new File("creditCards4.txt"));

        final Set<String> creditcards = creditCardSearch.searchForMatchesInAllFiles();

        assertNotNull(creditcards);
        assertEquals(1, creditcards.size());
        assertTrue("5272835420269481", creditcards.contains("5272835420269481"));
    }

}
