import javax.swing.*;
import java.util.ArrayList;

public class Start {
    static ArrayList<Author> authorsArr = new ArrayList<Author>();
    private static int it = 0;

    public static void createAuthor(){
        authorsArr.add(new Author());

        String authorId = JOptionPane.showInputDialog(null, "Type the author's Id...");
        int idInteger = Integer.parseInt(authorId);
        authorsArr.get(it).setAuthorId(idInteger);

        String authorName = JOptionPane.showInputDialog(null, "Type the author's name...");
        authorsArr.get(it).setAuthorName(authorName);

        it++;
        menu();
    }

    public static void listAuthors(){
        for(Author author : authorsArr){
            JOptionPane.showMessageDialog(null, "Author's id: " + author.getAuthorId() + "\nAuthor's name: " + author.getAuthorName());
        }

        menu();
    }

    public static void updateAuthor(){
        String authorId = JOptionPane.showInputDialog(null, "Type the author's id you want to update...");
        int idInteger = Integer.parseInt(authorId);

        for(Author author : authorsArr){
            if(author.getAuthorId() == idInteger){

                String toUpdate = JOptionPane.showInputDialog(null, "What do you want to update \n1) Author's Id \n2) Author's name");
                int toUpdateInt = Integer.parseInt(toUpdate);
    
                String newValue = JOptionPane.showInputDialog(null, "Type the new value...");
    
                switch(toUpdateInt){
                    case 1:
                        author.setAuthorId(Integer.parseInt(newValue));
                            break;
                    case 2:
                        author.setAuthorName(newValue);
                }
            } 
        }

        menu();
    }

    public static void deleteAuthor(){
        String authorId = JOptionPane.showInputDialog(null, "Type the author's id you want to delete...");
        int idInteger = Integer.parseInt(authorId);

        for(Author author : authorsArr){
            if(author.getAuthorId() == idInteger){
                authorsArr.remove(author);

                JOptionPane.showMessageDialog(null, "Author successfully deleted.");

                //Break used to exit the for loop and avoid "ConcurrentModificationException"
                break;
            } 
        }

        //Subtracting 1 from the "it" so that it can correctly ident for the next call of createAuthor()
        //Pushing the new author instance at it's correct position 
        it--;
        menu();
    }

    //----------------------------BOOK-----------------------------------

    static ArrayList<Book> booksArr = new ArrayList<Book>();
    private static int iterator = 0;

    private static void createBook() {
        booksArr.add(new Book());

        String idIn = JOptionPane.showInputDialog(null, "Type the book's Id...");
        int bookId = Integer.parseInt(idIn);

        String bookName = JOptionPane.showInputDialog(null, "Type the book's name...");

        String bookAuthor = JOptionPane.showInputDialog(null, "Type the book's author id...");
        int bookAuthorId = Integer.parseInt(bookAuthor);

        booksArr.get(iterator).setBookId(bookId);
        booksArr.get(iterator).setBookName(bookName);

        for(Author author : authorsArr){
            if(author.getAuthorId() == bookAuthorId){
                booksArr.get(iterator).setBookAuthor(author);
            } 
        }

        iterator++;
        menu();
    }

    private static void listBooks() {
        for(Book book : booksArr){
            JOptionPane.showMessageDialog(null, "\nBook's id: " + book.getBookId() + "\nBook's name: " + book.getBookName() + "\nBook's author: " + book.getBookAuthor());
        }

        menu();
    }

    private static void updateBook() {
        String idIn = JOptionPane.showInputDialog(null, "Type the book's id to updated...");
        int bookId = Integer.parseInt(idIn);

        for(Book book : booksArr){
            if(book.getBookId() == bookId){
                String toUpdate = JOptionPane.showInputDialog(null, "What do you want to update: \n1) Book's id \n2) Book's name \n3) Book's author");
                int toUpdateInt = Integer.parseInt(toUpdate);

                String newValue = JOptionPane.showInputDialog(null, "Type the new value...");

                switch(toUpdateInt){
                    case 1:
                        book.setBookId(Integer.parseInt(newValue));
                            break;
                    case 2:
                        book.setBookName(newValue);
                            break;
                    case 3:
                        for(Author author : authorsArr){
                            if(author.getAuthorId() == Integer.parseInt(newValue)){
                                book.setBookAuthor(author);
                            } else {
                                JOptionPane.showMessageDialog(null, "Author not found. Try again...");
                                updateBook();
                            }
                        }
                            break;
                }
            }
        }

        menu();
    }

    private static void deleteBook() {
        String idIn = JOptionPane.showInputDialog(null, "Type the book's id to deleted...");
        int bookId = Integer.parseInt(idIn);

        for(Book book : booksArr){
            if(book.getBookId() == bookId){
                booksArr.remove(book);

                JOptionPane.showMessageDialog(null, "Book successfully removed.");

                break;
            } 
        }

        menu();
    }

    public static void menu(){
        try{
            String message = "Choose the operation... \n\n 1) Create author \n 2) List authors \n 3) Update author \n 4) Delete author \n 5) Create book \n 6) List books \n 7) Update book \n 8) Delete book \n 0) Exit";
            String op = JOptionPane.showInputDialog(null, message);
            int opInt = Integer.parseInt(op);
        
            switch(opInt){
                case 1:
                    createAuthor();
                        break;
                case 2:
                    listAuthors();
                        break;
                case 3:
                    updateAuthor();
                        break;
                case 4:
                    deleteAuthor();
                        break;
                case 5:
                    createBook();
                        break;
                case 6:
                    listBooks();
                        break;
                case 7:
                    updateBook();
                        break;
                case 8:
                    deleteBook();
                        break;
                case 0:
                    System.exit(0);
                        break;
                default:
                    JOptionPane.showMessageDialog(null, "Type a number between 0 and 8...");
                    menu();
            }
        } catch (NumberFormatException e){
            menu();
        }

    }



    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome...");
        menu();
    }   
}
