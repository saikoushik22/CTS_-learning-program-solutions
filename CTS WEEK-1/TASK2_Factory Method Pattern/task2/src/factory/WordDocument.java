package factory;

public class WordDocument implements Document {
    @Override
    public void open() { System.out.println("Opening a Word document…"); }

    @Override
    public void save() { System.out.println("Saving the Word document."); }
}