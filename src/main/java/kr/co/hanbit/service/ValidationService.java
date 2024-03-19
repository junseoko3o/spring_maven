package kr.co.hanbit.service;

import jakarta.validation.Valid;
import kr.co.hanbit.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {
    public void checkValid(@Valid Product validationTarget) {

    }
}
