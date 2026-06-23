package Module_1_Design_Patterns_and_Principles.Exercise_2;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory d1 = new WordDocFactory();
        Document wordDoc = d1.createDocument();
        wordDoc.readDoc();

        DocumentFactory d2 = new PdfDocFactory();
        Document pdfDoc = d2.createDocument();
        pdfDoc.readDoc();

        DocumentFactory d3 = new ExcelDocFactory();
        Document excelDoc = d3.createDocument();
        excelDoc.readDoc();
    }
}

// Product Interface
interface Document{
    void readDoc();
}

// Concrete Products
class WordDocument implements Document{
    @Override
    public void readDoc(){
        System.out.println("Word Document");
    }
}

class PdfDocument implements Document{
    @Override
    public void readDoc(){
        System.out.println("PDF Document");
    }
}

class ExcelDocument implements Document{
    @Override
    public void readDoc(){
        System.out.println("Excel Document");
    }
}

// Abstract Factory
abstract class DocumentFactory{
    public abstract Document createDocument();
}

// Concrete Factories
class WordDocFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new WordDocument();
    }
}

class PdfDocFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new PdfDocument();
    }
}

class ExcelDocFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new ExcelDocument();
    }
}
