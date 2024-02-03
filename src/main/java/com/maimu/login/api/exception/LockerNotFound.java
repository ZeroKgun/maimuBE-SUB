package com.maimu.login.api.exception;

public class LockerNotFound extends MaimuException{

    private static final String MESSAGE = "CANNOT FIND LOCKER";

    public LockerNotFound(){
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
