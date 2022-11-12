package com.cavanosa.virtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TioRepoTest {
    @Autowired
    TioRepository tioRepository;
 
    @Test
    void isPersonExitsById() {
        //Tio person = new Tio("amiya", "amiya@gmail.com", "123456");
        //tioRepository.save(person);
        boolean actualResult = tioRepository.existsByNombre("amiya");
        assertThat(actualResult).isTrue();
    }
}
