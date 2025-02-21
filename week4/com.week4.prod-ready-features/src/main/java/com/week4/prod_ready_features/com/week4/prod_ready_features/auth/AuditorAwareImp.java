package com.week4.prod_ready_features.com.week4.prod_ready_features.auth;


import org.springframework.data.domain.AuditorAware;

import java.util.Optional;



public class AuditorAwareImp implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        security context
        return Optional.of("Nagendra Reddy");
    }


}
