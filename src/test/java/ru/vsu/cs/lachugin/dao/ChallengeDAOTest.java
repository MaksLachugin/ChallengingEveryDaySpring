package ru.vsu.cs.lachugin.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.vsu.cs.lachugin.models.Challenge;
import ru.vsu.cs.lachugin.models.Challenge;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChallengeDAOTest {
    private final IDAO<Challenge> dao = new ChallengeDAO(jdbcTemplate());

    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("psw");
        return dataSource;
    }

    protected JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public IDAO<Challenge> getDao() {
        return dao;
    }

    @BeforeEach
    @AfterEach
    public void cleanTest() {
        dao.clean();
    }

    public List<Challenge> createModels(int count) {
        List<Challenge> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Challenge challenge = new Challenge();
            challenge.setClient_id(i);
            challenge.setName("Challenge: " + i);
            challenge.setNeed(i * 10);
            challenge.setDays(i*5);
            challenge.setStart_date(new Date(2000+i,i%12, i%28));
            list.add(challenge);
        }
        return list;
    }

    //given
    //when
    //assert
    @Test
    public void index() {
        //given
        int count = 5;
        getDao().saveAll(createModels(count));
        //when
        List<Challenge> actual = getDao().index();
        //assert
        assertFalse(actual.isEmpty());
        assertEquals(count, actual.size());
    }

    @Test
    public void show() {
        //given
        int count = 5;
        List<Challenge> list = createModels(count);
        getDao().saveAll(list);
        Challenge f = list.get(4);
        //when
        list = getDao().index();
        Challenge actual = getDao().show(list.get(4).getId());
        //assert
        assertNotNull(actual);
        f.setId(actual.getId());
        assertEquals(actual, f);
    }

    @Test
    public void save() {
        //given
        int count = 1;
        List<Challenge> list = createModels(count);
        getDao().save(list.get(0));
        //when
        List<Challenge> actual = getDao().index();
        //assert
        assertFalse(actual.isEmpty());
        assertEquals(count, actual.size());
        list.get(0).setId(actual.get(0).getId());
        assertEquals(list.get(0), actual.get(0));

    }

    @Test
    public void update() {
        //given
        int count = 10;
        getDao().saveAll(createModels(count));
        List<Challenge> actual = getDao().index();
        int id = actual.get(5).getId();
        Challenge b1 = actual.get(1);
        //when
        getDao().update(id, b1);
        Challenge b2 = getDao().show(id);
        b1.setId(b2.getId());
        //assert
        assertEquals(b1, b2);
    }

    @Test
    public void delete() {
        //given
        int count = 5;
        List<Challenge> list = createModels(count);
        getDao().saveAll(list);
        //when
        list = getDao().index();
        int deletedId = list.get(4).getId();
        getDao().delete(deletedId);
        Challenge actual = getDao().show(deletedId);
        //assert
        assertNull(actual);
    }

    @Test
    public void clean() {
        //given
        int count = 5;
        getDao().saveAll(createModels(count));
        //when
        getDao().clean();
        List<Challenge> actual = getDao().index();
        //assert
        assertTrue(actual.isEmpty());
    }

    @Test
    public void saveAll() {
        //given
        int count = 5;
        List<Challenge> list = createModels(count);

        //when
        List<Challenge> actual = getDao().saveAll(list);
        //assert
        assertFalse(actual.isEmpty());
        assertEquals(count, actual.size());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(actual.get(i).getId());
            assertEquals(list.get(i), actual.get(i));
        }
    }
}
