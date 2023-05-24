package com.cavanosa.virtual.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TioRepoTest {
    @Mock
    TioRepository tioRepository;
 
    @Test
    void isPersonExitsByIdtest() {
        //Tio person = new Tio("amiya", "amiya@gmail.com", "123456");
        //tioRepository.save(person);
        when(tioRepository.existsByNombre("amiya")).thenReturn(true);

        boolean actualResult = tioRepository.existsByNombre("amiya");
        assertThat(actualResult).isTrue();
    }
}
