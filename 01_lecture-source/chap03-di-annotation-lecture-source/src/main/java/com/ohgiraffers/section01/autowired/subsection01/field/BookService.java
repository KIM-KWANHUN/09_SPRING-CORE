package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOImpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 어노테이션의 세분화 된 @Service 어노테이션
// @Service 계층에서 사용된다.
@Service("fieldService")
public class BookService {
    @Autowired // 필드위 객체 생성
    private BookDAO bookDAO;

    // 메소드 생성
    /* 전체 조회 기능 호출 */
    public List<BookDTO> selectAllBooks() {
        /* comment.
        *   Spring 에서 의존성 투입은
        *   미리 bean 으로 컨테이너에 등록해둔 객체를
        *   필요 시에 @Autowired 어노테이션으로
        *   가져다가 쓰는 개념이다.
        *   따라서 개발자는 new 키워드로 객체를 생성하는
        *   것이 아닌, 컨테이너에 존재하는 객체를 가져와야 한다. */
        // ex) 필드는 new 객체를 생성 해야함
        // 필드주입은 new 라고 하는 키워드를 막을 방법이없음
        // bookDAO = new BookDAOImpl();

        return bookDAO.selectBookList();
    }

    /* 번호로 책 한권 조회 기능 호출 */

    public BookDTO selectOneBook(int no) {

        return bookDAO.selectBookByNo(no);
    }

}
