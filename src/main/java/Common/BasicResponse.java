package Common;

/**
 * BasicResponse is a generic class used to encapsulate responses from the application.
 * It contains a status, a message, and the data of a specified type.
 *
 * @param <T> The type of the data included in the response.
 */
public class BasicResponse<T> {
    private String status;
    private String message;
    private T data;

    /**
     * Constructs a new BasicResponse with the specified status, message, and data.
     *
     * @param status  The status of the response (e.g., "success" or "error").
     * @param message A message providing additional information about the response.
     * @param data    The data included in the response.
     */
    public BasicResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and setters

    /**
     * Gets the status of the response.
     *
     * @return The status of the response.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the response.
     *
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the message of the response.
     *
     * @return The message of the response.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the response.
     *
     * @param message The message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the data of the response.
     *
     * @return The data of the response.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data of the response.
     *
     * @param data The data to set.
     */
    public void setData(T data) {
        this.data = data;
    }
}
