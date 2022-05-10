package ru.vsu.cs.lachugin.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.vsu.cs.lachugin.models.Button;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonDAOTest {
    private final IDAO<Button> dao = new ButtonDAO(jdbcTemplate());

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

    public IDAO<Button> getDao() {
        return dao;
    }

    @BeforeEach
    @AfterEach
    public void cleanTest() {
        dao.clean();
    }

    public List<Button> createModels(int count) {
        List<Button> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Button button = new Button();
            button.setChallenge_id(i);
            button.setName("Button: " + i);
            button.setNum(i * 10);
            list.add(button);
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
        List<Button> actual = getDao().index();
        //assert
        assertFalse(actual.isEmpty());
        assertEquals(count, actual.size());
    }

    @Test
    public void show() {
        //given
        int count = 5;
        List<Button> list = createModels(count);
        getDao().saveAll(list);
        Button f = list.get(4);
        //when
        list = getDao().index();
        Button actual = getDao().show(list.get(4).getId());
        //assert
        assertNotNull(actual);
        f.setId(actual.getId());
        assertEquals(actual, f);
    }

    @Test
    public void save() {
        //given
        int count = 1;
        List<Button> list = createModels(count);
        getDao().save(list.get(0));
        //when
        List<Button> actual = getDao().index();
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
        List<Button> actual = getDao().index();
        int id = actual.get(5).getId();
        Button b1 = actual.get(1);
        //when
        getDao().update(id, b1);
        Button b2 = getDao().show(id);
        b1.setId(b2.getId());
        //assert
        assertEquals(b1, b2);
    }

    @Test
    public void delete() {
        //given
        int count = 5;
        List<Button> list = createModels(count);
        getDao().saveAll(list);
        //when
        list = getDao().index();
        int deletedId = list.get(4).getId();
        getDao().delete(deletedId);
        Button actual = getDao().show(deletedId);
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
        List<Button> actual = getDao().index();
        //assert
        assertTrue(actual.isEmpty());
    }

    @Test
    public void saveAll() {
        //given
        int count = 5;
        List<Button> list = createModels(count);

        //when
        List<Button> actual = getDao().saveAll(list);
        //assert
        assertFalse(actual.isEmpty());
        assertEquals(count, actual.size());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(actual.get(i).getId());
            assertEquals(list.get(i), actual.get(i));
        }
    }
}