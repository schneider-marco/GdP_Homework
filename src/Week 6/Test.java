public class Test {

    public static void main(String[] args) {
        Book book1 = new Book("Buch1", "Author1", 1);
        Book book2 = new Book("Buch2", "Author2", 2);
        Bookshelf bookshelf1 = new Bookshelf(new Book[]{book1, book2});

//        bookshelf1.printBooks();
        System.out.println(bookshelf1.containsBook("bucch1"));
        bookshelf1.addBook(new Book("Buch3", "Author3", 3));
        bookshelf1.printBooks();
    }
}