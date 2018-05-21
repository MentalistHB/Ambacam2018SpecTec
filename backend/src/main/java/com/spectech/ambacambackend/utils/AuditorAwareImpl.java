package com.spectech.ambacambackend.utils;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String > {

    @Override
    public Optional<String> getCurrentAuditor() {


        // Update this with name coming from security
        return Optional.of("Logged User");
    }
}
