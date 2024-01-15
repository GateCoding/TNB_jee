package emsi.cg.terrain.rmq;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter@Getter
public class ReponseDemande implements Serializable {
    private boolean traitementReussi;
    private String message;
}
