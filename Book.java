public class Book {
    private int bookId;
    private String bookName;
    private Author bookAuthor;

    public int getBookId(){
        return bookId;
    }
    public void setBookId(int bookIdIn){
        bookId = bookIdIn;
    }   

    public String getBookName(){
        return bookName;
    }
    public void setBookName(String bookNameIn){
        bookName = bookNameIn;
    }

    public Author getBookAuthor(){
        return bookAuthor;
    }
    public void setBookAuthor(Author author){
        bookAuthor = author;
    }
}
