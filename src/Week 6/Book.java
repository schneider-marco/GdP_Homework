public class Book {

    String titel;
    String author;
    int erscheinungsjahr;

    public Book(String titel, String author, int erscheinungsjahr ) {
        this.titel = titel;
        this.author = author;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public void printInfo() {
        System.out.println("Titel des Buches: " + this.titel);
        System.out.println("Author des Buches: " + this.author);
        System.out.println("Erscheinungsjahr des Buches: " + this.erscheinungsjahr);
    }

}