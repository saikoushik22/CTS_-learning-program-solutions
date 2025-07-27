package factory;

public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory  = new WordDocumentFactory();
        DocumentFactory pdfFactory   = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document w = wordFactory.createDocument();
        Document p = pdfFactory.createDocument();
        Document e = excelFactory.createDocument();

        w.open(); w.save();
        p.open(); p.save();
        e.open(); e.save();

        Document doc2 = DocumentFactory.of("pdf").createDocument();
        doc2.open();
        doc2.save();
    }
}