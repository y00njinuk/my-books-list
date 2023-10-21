package chapter7;

interface Parseable {
    // default access modifier : public abstract
    void parse(String fileName);
}

class ParserManager {
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
            Parseable p = new HTMLParser();
            return p;
        }
    }
}

class XMLParser implements Parseable {
    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " XML Parsing");
    }
}

class HTMLParser implements Parseable {
    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " HTML Parsing");
    }
}

public class ParserTest {
    public static void main(String[] args) {
        // instanceOf XMLParser.
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");

        // instanceOf HTMLParser.
        parser = ParserManager.getParser("HTML");
        parser.parse("document2.xml");
    }
}
