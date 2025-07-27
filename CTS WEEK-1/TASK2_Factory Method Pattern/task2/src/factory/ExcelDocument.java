package factory;

public class ExcelDocument implements Document {
    @Override
    public void open() { System.out.println("Opening an Excel spreadsheet…"); }

    @Override
    public void save() { System.out.println("Saving the Excel spreadsheet."); }
}