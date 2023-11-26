public class Book {
    String title;
    String author;
    String releasDate;

    public Book(String t, String a, String d){
        this.title = t;
        this.author = a;
        this.releasDate = d;
    }

    public void printInfo(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Release Date: " + this.releasDate);
    }
}