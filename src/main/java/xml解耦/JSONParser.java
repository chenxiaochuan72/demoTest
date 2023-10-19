package xml解耦;

import java.io.Reader;
import java.util.List;

public class JSONParser implements Parser{
    @Override
    public List parse(Reader r) {
        System.out.println("JSONParser");
        return null;
    }
}
