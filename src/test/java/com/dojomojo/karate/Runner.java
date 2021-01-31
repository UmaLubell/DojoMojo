package com.dojomojo.karate;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)

@KarateOptions(features = "classpath:com/dojomojo/karate/TaskOne.feature" )


public class Runner {

}
