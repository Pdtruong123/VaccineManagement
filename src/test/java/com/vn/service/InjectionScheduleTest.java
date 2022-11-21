package com.vn.service;

import com.vn.model.InjectionSchedule;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.service.impl.InjectionScheduleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InjectionScheduleTest {
    @Mock
    private InjectionSchuduleRepository injectionSchuduleRepository;
    @InjectMocks
    private InjectionScheduleServiceImpl injectionScheduleServiceImpl;

    @BeforeEach
    public void setUp() {
        injectionScheduleServiceImpl = new InjectionScheduleServiceImpl(this.injectionSchuduleRepository);
    }

    @Test
    public void getAll() {
        injectionScheduleServiceImpl.findAll();
        verify(injectionSchuduleRepository).findAll();
    }

    @Test
    public void save() {
        InjectionSchedule injectionSchedule = new InjectionSchedule
                ("abc123", LocalDate.of(2022, 11, 21),
                        LocalDate.of(2022, 11, 25), "hai duong",
                        "abc", null, "abcc");
        when(injectionSchuduleRepository.save(injectionSchedule)).thenReturn(injectionSchedule);
        Assertions.assertEquals(injectionSchedule, injectionScheduleServiceImpl.save1(injectionSchedule));
    }

    @Test
    public void findById() {
        InjectionSchedule injectionSchedule = new InjectionSchedule("abc123", LocalDate.of(2022, 11, 21),
                LocalDate.of(2022, 11, 25), "hai duong",
                "abc", null, "abcc");
        when(injectionSchuduleRepository.findById("abc123")).thenReturn(Optional.of(injectionSchedule));
        Assertions.assertEquals(injectionScheduleServiceImpl.findByID("abc123"),injectionSchedule);
    }
}
