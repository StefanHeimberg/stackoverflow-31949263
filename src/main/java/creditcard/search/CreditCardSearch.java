    package creditcard.search;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.Iterator;
    import java.util.List;
    import java.util.Map;
    import java.util.Set;

    public class CreditCardSearch {

        private final Set<File> files = new HashSet();

        public void addCreditCardsFile(final File file) {
            files.add(file);
        }

        public Set<String> searchForMatchesInAllFiles() throws IOException {
            if(files.size() < 2) {
                throw new IllegalArgumentException("a minimum of 2 creditcard files required");
            }

            final Map<Path, List<String>> linesPerPath = new HashMap<>();
            for(final File file : files) {
                final Path path = file.toPath();
                linesPerPath.put(path, Files.readAllLines(path));
            }

            final Set<String> creditcards = new HashSet();

            final Iterator<Path> it = linesPerPath.keySet().iterator();

            List<String> linesA = null;

            while(it.hasNext()) {
                if(null == linesA) {
                    linesA = linesPerPath.get(it.next());
                }
                List<String> linesB = linesPerPath.get(it.next());

                if(linesA.retainAll(linesB)) {
                    creditcards.addAll(linesA);
                }
            }

            return creditcards;
        }

    }
