package xml解耦;

import java.io.Reader;
import java.util.List;

public interface Parser {
    List parse(Reader r);
}
