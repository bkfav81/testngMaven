package test.testex;

import test.testex.ReportMailLoginTest;
import test.testex.ReportMailEmailUtility;
import test.testex.ReportMailZipUtility;

public class ReportMailCustomizedReport {

    public static void main(String[] args) {
        try {
            // Run the test and generate the report
        	ReportMailLoginTest test = new ReportMailLoginTest();
            test.setup();
            test.loginTest();
            test.teardown();

            // Zip the report
            String reportFile = "C:\\projectScreenshots\\TestReport.txt";
            String zipFile = "C:\\projectScreenshots\\TestReport.zip";
            ReportMailZipUtility.zipFile(reportFile, zipFile);

            // Send the report via email
            String from = "bhavesh.karodiwal@gmail.com";
            String to = "bhavesh.stadsolution@gmail.com";
            String subject = "Automated Test Report";
            String body = "Please find the test report attached.";
            ReportMailEmailUtility.sendEmail(from, to, subject, body, zipFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
