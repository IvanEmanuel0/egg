/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteleria.exception;

/**
 *
 * @author alaga
 */
public class HotelException extends Exception {

    /**
     * Creates a new instance of <code>HotelException</code> without detail
     * message.
     */
    public HotelException() {
    }

    /**
     * Constructs an instance of <code>HotelException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public HotelException(String msg) {
        super(msg);
    }
}
