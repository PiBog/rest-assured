/*Bohdan Pysarenko © All right reserved.
 *
 */
package com.castilleresources.springdemo;

import com.castilleresources.springdemo.sql.DbInitializer;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin={"pretty", "html:report/cucumber-reports"})
public class CucumberTestRunner {

    private DbInitializer dbInitializer = new DbInitializer();

    @Before
    public void initDB(){
        dbInitializer.initDb();
    }

    @After
    public void cleanDb(){
        dbInitializer.cleanDb();
    }

}
