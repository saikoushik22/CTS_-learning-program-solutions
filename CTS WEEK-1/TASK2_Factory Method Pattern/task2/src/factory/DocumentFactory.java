package factory;

public abstract class DocumentFactory {
    public abstract Document createDocument();

    /* Optional helper that clients can call instead of “new ConcreteFactory()” */
    public static DocumentFactory of(String type) {
        return switch (type.toLowerCase()) {
            case "word"   -> new WordDocumentFactory();
            case "pdf"    -> new PdfDocumentFactory();
            case "excel"  -> new ExcelDocumentFactory();
            default       -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}