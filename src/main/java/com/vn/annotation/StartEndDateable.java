package com.vn.annotation;

import java.time.LocalDate;

public interface StartEndDateable {
    public LocalDate getInjectionDate();
    public LocalDate getNextInjectionDate();
}
