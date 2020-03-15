/*Bohdan Pysarenko © All right reserved.
 *
 */
package com.castilleresources.springdemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
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
@CucumberOptions(features = "src/test/resources/features", plugin={"pretty", "html:report/cucumber-reports"}, glue = {"com.castilleresources.springdemo.stepdefs"})
public class CucumberTestRunner {

}
