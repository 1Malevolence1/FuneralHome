package org.example.validator;

import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;

public interface Validator<T, E extends Contract> {
    T check(E e) throws VadilatorMenException;
}
