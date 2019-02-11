package org.duckdns.owly.bugs.myfaces_4282;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

@Log4j
@Model
public class JustSomeOtherModel {

    @Getter @Setter
    private Long key;

    @PostConstruct
    public void load() {
        log.error("#######################################");
        log.error("#######################################");
        log.error("#######################################");
        log.error("### PostConstruct");
        log.error("#######################################");
        log.error("#######################################");
        log.error("#######################################");
    }
}
