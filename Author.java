public class Author {
    private int authorId;
    private String authorName;

    //Constructor
    public Author(int authorId, String authorName){
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorId(int idIn){
        authorId = idIn;
    }

    public String getAuthorName(){
        return authorName;
    }
    public void setAuthorName(String nameIn){
        authorName = nameIn;
    }
}
