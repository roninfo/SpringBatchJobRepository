package br.com.roninfo.example.util;

/**
 * Created by roninfo on 28/08/17.
 */
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyTasklet implements Tasklet{

    private DataSource dataSource;
    private String sql="select firstName,lastName,school,rollNumber from PERSON";


    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        List<Person> personList = new ArrayList();
        JdbcTemplate myTemplate = new JdbcTemplate(getDataSource());
        personList = myTemplate.query(sql, new PersonMapper());
        for(Person p: personList){
            System.out.println(p.toString());
        }
        return RepeatStatus.FINISHED;
    }
    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

