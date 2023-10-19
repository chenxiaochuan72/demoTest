package xml解耦;

import lombok.extern.slf4j.Slf4j;

import java.io.Reader;
import java.util.List;
@Slf4j
public class CSVParser implements Parser{
    @Override
    public List parse(Reader r) {
        System.out.println("CSVParser");
        return null;
    }
}
