package com.eventHive.controllers;

/**
 * @author vmikolyuk
 * @since 27.06.2023
 */
public class Exception
{
    private String message;

    private Exception(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public static Exception create(Throwable e)
    {
        return new Exception(e.getMessage());
    }
}
