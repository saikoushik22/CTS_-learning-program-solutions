package factory;

public class PdfDocument implements Document {
    @Override
    public void open() { System.out.println("Opening a PDF document…"); }

    @Override
    public void save() { System.out.println("Saving the PDF document."); }
}