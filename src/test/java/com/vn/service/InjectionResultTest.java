package com.vn.service;

import com.vn.model.InjectionResult;
import com.vn.repository.InjectionResultRepository;
import com.vn.service.impl.InjectionResultServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class InjectionResultTest {

    @Mock
    private InjectionResultRepository injectionResultRepository;

    @InjectMocks
    private InjectionResultServiceImpl injectionResultServiceImpl;

    @BeforeEach
    public void setUp(){
        injectionResultServiceImpl = new InjectionResultServiceImpl(this.injectionResultRepository);
    }
    @Test
    public void getAllTest(){
       injectionResultServiceImpl.findAll();
       verify(injectionResultRepository).findAll();
    }

    @Test
    public void saveTest(){
        InjectionResult injectionResult = new InjectionResult("00013",null,LocalDate.of(2022,11,18),"Ha Noi",
                LocalDate.of(2022,12,05), 3, "Chong HIV",null);
        when(injectionResultRepository.save(injectionResult)).thenReturn(injectionResult);
        Assertions.assertEquals(injectionResult, injectionResultServiceImpl.save(injectionResult));
    }

    @Test
    public void deleteTest(){
        InjectionResult injectionResult = new InjectionResult("00013",null,LocalDate.of(2022,11,18),"Ha Noi",
                LocalDate.of(2022,12,05), 3, "Chong HIV",null);
        injectionResultServiceImpl.deleteInjectionResult(injectionResult.getId());
        verify(injectionResultRepository, times(1)).deleteById(injectionResult.getId());
    }

    @Test
    public void findByIdTest(){
        InjectionResult injectionResult = new InjectionResult("00013",null,LocalDate.of(2022,11,18),"Ha Noi",
                LocalDate.of(2022,12,05), 3, "Chong HIV",null);
        when(injectionResultRepository.findById("00013")).thenReturn(Optional.of(injectionResult));
        Assertions.assertEquals(injectionResultServiceImpl.findById("00013"),injectionResult);
    }

    @Test
    public void findElementReportTest(){
        when(injectionResultRepository.findElementReport("Chong HIV", "",
                LocalDate.of(2022,05,18),
                LocalDate.of(2022,11,20))).thenReturn(Stream.of(new InjectionResult("00013",null,LocalDate.of(2022,11,18),"Ha Noi",
                LocalDate.of(2022,12,05), 3, "Chong HIV",null)).collect(Collectors.toList()));
        Assertions.assertEquals(1, injectionResultServiceImpl.findElementReport("Chong HIV", "",
                LocalDate.of(2022,05,18),
                LocalDate.of(2022,11,20)).size());

    }
}
