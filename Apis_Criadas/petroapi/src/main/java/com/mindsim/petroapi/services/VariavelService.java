package com.mindsim.petroapi.services;

import com.mindsim.petroapi.repositories.VariavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VariavelService {
    @Autowired
    private VariavelRepository variavelRepository;
}
