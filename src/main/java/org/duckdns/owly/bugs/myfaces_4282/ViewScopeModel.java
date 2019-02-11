package org.duckdns.owly.bugs.myfaces_4282;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Log4j
@Named
@ViewScoped
public class ViewScopeModel implements Serializable {

    @Getter @Setter
    private Long key;

    @PostConstruct
    public void load() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        log.error("#######################################");
        log.error("#######################################");
        log.error("#######################################");
        log.error("### PostConstruct");
        log.error("#######################################");
        log.error("#######################################");
        log.error("#######################################");
    }
}
