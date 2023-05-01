package com.cavanosa.virtual.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TioRepoTest {
    @Mock
    TioRepository tioRepository;
 
    @Test
    void isPersonExitsById() {
        //Tio person = new Tio("amiya", "amiya@gmail.com", "123456");
        //tioRepository.save(person);
        when(tioRepository.existsByNombre("amiya")).thenReturn(true);

        boolean actualResult = tioRepository.existsByNombre("amiya");
        assertThat(actualResult).isTrue();
    }
}
