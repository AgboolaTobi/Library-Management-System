package com.SemicolonLibrarySystem.SemicolonLibrary.services.user;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Desk;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.User;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.UserBorrowBookRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.book.BookService;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.desk.DeskService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class UserBorrowBookService {

    private final UserService userService;
    private final BookService bookService;
    private final DeskService deskService;

    public ApiResponse userBorrowBook(UserBorrowBookRequest userBorrowBookRequest) throws RegistrationException, BookCatalogException {
        User user = userService.findByStudentNumber(userBorrowBookRequest.getStudentNumber());
        if (user == null) throw new RegistrationException(GenerateApiResponse.INVALID_STUDENT_NUMBER);

        Desk existingDesk = user.getDesk();
        Book bookOnCatalog = bookService.findByBookName(userBorrowBookRequest.getBookName());

        if (bookOnCatalog == null) throw new BookCatalogException(GenerateApiResponse.BOOK_NOT_AVAILABLE_AT_THE_MOMENT);

        List<Book> listOfBook = existingDesk.getListOfBooks();

        if (listOfBook == null) {
            listOfBook = new ArrayList<>();
        }
        listOfBook.add(bookOnCatalog);

        existingDesk.setListOfBooks(new ArrayList<>(listOfBook));

        Desk updatedDesk = deskService.save(existingDesk);

        user.setDesk(updatedDesk);
        userService.save(user);


        return GenerateApiResponse.added(bookService.findByBookName(userBorrowBookRequest.getBookName()) + GenerateApiResponse.BOOK_SUCCESSFULLY_ADDED_TO_DESK);
    }

}
