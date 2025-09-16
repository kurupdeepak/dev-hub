package org.veromatrix.trame.entryservice.transfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorTO {
    int errorId;
    String apiPath;
    String message;
    String status;
    Exception e ;
}
