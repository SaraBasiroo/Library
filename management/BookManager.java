package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

import java.util.NoSuchElementException;

public class BookManager {
    private CustomHashMap<String, Book> books;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        books = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        if (books == null){
            throw new NoSuchElementException();
        }
        return books.get(isbn).isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        if (books != null){
            books.get(isbn).setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = books.get(isbn);
        Member member = memberManager.getMember(memberId);
        if (book != null && member != null){
            book.addToWaitlist(member);
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null){
            return book.getNextInWaitlist();
        }
        return null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = books.get(isbn);
        return book.hasWaitlist();
    }
}