package libms;

import userobjects.Staff;

/**
 * 
 * @author Grant Swift
 */
public class Consts {
    static final Staff admin = new Staff(000000000, "admin", null, "admin", "admin");
    static final int NULL_SCREEN = 0;
    static final int MAIN_MENU = 1;
    static final int STUDENT_LOGIN = 2;
    static final int STAFF_LOGIN = 3;
    static final int ADMIN_PANEL = 4;
    static final int STUDENT_PANEL = 5;
    static final int STUDENT_SEARCH = 6;
    static final int RENTAL_SEARCH = 7;
    static final int BOOK_SEARCH = 8;
    static final int MOVIE_SEARCH = 9;
}
