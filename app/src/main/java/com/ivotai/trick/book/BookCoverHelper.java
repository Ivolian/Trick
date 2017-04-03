package com.ivotai.trick.book;

/**
 * The type Book cover helper.
 */
public class BookCoverHelper {

    /**
     * Cover url string.
     *
     * @param bid the bid
     * @return the string
     */
    public static String coverUrl(int bid) {
        // 239254
        String bookId = "" + bid;
        int length = bookId.length();
        // 254
        String bidLatter = bookId.substring(length - 3, length);
        if (bidLatter.startsWith("0")) {
            bidLatter = bidLatter.substring(1, 3);
        }
        // http://wfqqreader.3g.qq.com/cover/254/239254/t5_239254.jpg
        return "http://wfqqreader.3g.qq.com/cover/" + bidLatter + "/" + bid + "/t5_" + bid + ".jpg";
    }

}
