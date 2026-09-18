package dao;
import java.util.List;
import model.Book;

public class LocalBookDAO {

    String ruta;
    List<Book> libros;

    public LocalBookDAO(String ruta, List<Book> libros) {
        this.ruta = ruta;
        this.libros = libros;
    }

    public void loadData()
    {

    }
    
    public void saveData()
    {

    }
    
    public void addBook(Book l)
    {
        this.libros.add(l);
    }

    public void updateBook(String isbn, String newname)
    {
        for (Book l : this.libros)
        {
            if (l.getIsbn().equals(isbn))
            {
                l.setName(newname);
                break;
            }
        }
    }

    public List<Book> getAllBooks()
    {
        return this.libros;
    }

    public Book getBooksByIsbn(String isbn)
    {

    }

    public void deleteBook(String isbn)
    {

    }
}
