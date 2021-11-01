package ipn.upiita.polifood.commons;
import ipn.upiita.polifood.commons.CommonResponse;
import lombok.Data;

import java.io.Serializable;

/**
 * Response Data Transfer Object with variable body class.
 *
 * @param <T> The class for the body.
 */
@Data
public class GenericResponseDTO<T> extends CommonResponse implements Serializable {

    /**
     * The body of the response.
     */
    private T body;

    /**
     * Default constructor.
     *
     * @param success      The success flag.
     * @param httpStatus   The http status code.
     * @param errorCode    The error code.
     * @param errorMessage An error message.
     * @param message      A message.
     * @param body         The body of the response.
     */
    public GenericResponseDTO(boolean success, Integer httpStatus, String errorCode, String errorMessage,
                              String message, T body) {
        super(success, httpStatus, errorCode, errorMessage, message);
        this.body = body;
    }
}