package com.SemicolonLibrarySystem.SemicolonLibrary.services.user;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Desk;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.User;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.UserRemoveBookRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCreationException;
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
public class UserRemoveBookService {
    private final UserService userService;
    private final DeskService deskService;
    private final BookService bookService;
    public ApiResponse removeBook(UserRemoveBookRequest userRemoveBookRequest) throws RegistrationException, BookCreationException {

        User user = userService.findByStudentNumber(userRemoveBookRequest.getStudentNumber());
        if (user == null) throw new RegistrationException(GenerateApiResponse.INVALID_STUDENT_NUMBER);
        Desk studentDesk = user.getDesk();
        if (studentDesk == null) throw new BookCreationException(GenerateApiResponse.STUDENT_DESK_NOT_FOUND);
        Book bookInDesk = bookService.findByBookName(userRemoveBookRequest.getBookName());
        if (bookInDesk == null)throw new BookCreationException(GenerateApiResponse.BOOK_NOT_FOUND_ON_DESK);

        List<Book> listOfBook = studentDesk.getListOfBooks();
       listOfBook.remove(bookInDesk);

       studentDesk.setListOfBooks(new ArrayList<>(listOfBook));
       Desk updatedDesk = deskService.save(studentDesk);

       user.setDesk(updatedDesk);
       userService.save(user);

       return GenerateApiResponse.removed(GenerateApiResponse.BOOK_SUCCESSFULLY_REMOVED_FROM_STUDENT_DESK);



    }
}
