package com.junlog.exception;

/**
 * status -> 404
 */
public class PostNotFound extends JunlogException {

    private static  final  String MESSAGE = "존재하지 않는 글입니다.";

    public PostNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
