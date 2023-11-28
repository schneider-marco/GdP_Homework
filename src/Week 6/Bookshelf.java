public class Bookshelf {
    Book[] books = {};
    public Bookshelf(Book[] books) {
        this.books = books;
    }

    public void printBooks() {
        for (Book b : this.books){
            b.printInfo();
            System.out.println();
        }
    }

    public boolean containsBook(String title) {
        for (Book b : this.books){
            if (b.titel.equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean addBook(Book book) {
        if (this.containsBook(book.titel)) {
            return false;
        }

        Book[] books = new Book[this.books.length + 1];

        for (int i = 0; i < this.books.length; i++) {
            books[i] = this.books[i];
        }
        books[this.books.length] = book;

        this.books = books;

        return true;
    }

}