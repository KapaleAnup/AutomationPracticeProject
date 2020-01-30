package com.practice.listner;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListner implements ITestListener {


    public void onTestFailure(ITestResult result){

        if(result.getThrowable() !=null){

            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            result.getThrowable().printStackTrace(printWriter);
            System.out.println(stringWriter.toString());

        }

    }

}
