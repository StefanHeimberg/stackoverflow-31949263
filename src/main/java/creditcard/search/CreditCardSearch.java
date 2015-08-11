package creditcard.search;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class CreditCardSearch {
    
    private final Set<File> files = new HashSet();
    
    public void addCreditCardsFile(final File file) {
        files.add(file);
    }
    
    public Set<String> searchForMatchesInAllFiles() {
        if(files.isEmpty()) {
            throw new IllegalArgumentException("no creditcard files added");
        }
        
        return null;
    }
    
}
