package com.library.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Reporter;

public class ExecutionLog {

	private static FileWriter writer = null;
	private static FileWriter emailWriter = null;
	private static String lineSeparator = System.getProperty("line.separator");

	static {
		File f = new File("ExecutionLog", getFileName() + ".txt");
		File ef = new File("ExecutionLog", "ExecutionLogForEmail.txt");
		try {
			writer = new FileWriter(f, true);
			emailWriter = new FileWriter(ef, true);
		} catch (IOException e) {
		}
	}

	public static synchronized void Log(String text) {
		try {
			// Create file
			String str = getDate() + " [info]  " + text;
			System.out.println(str);

			Reporter.log(str);

			writer.write(str);
			writer.append(lineSeparator);
			writer.flush();

			/*
			 * @author Jay
			 * 
			 * Generating a duplicated log file below so that it can be used as
			 * an Attachment in Jenkins and can be deleted every time when a
			 * Jenkins started execution of a job
			 */

			emailWriter.write(str);
			emailWriter.append(lineSeparator);
			emailWriter.flush();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	private static String getAsString(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString(); // stack trace as a string
	}

	public static void Log(Throwable t) {
		String str = "  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Error message >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + lineSeparator
				+ getAsString(t);
		Log(str);
	}

	public static void LogExceptionMessage(Exception e) throws IOException {
		Log(e);
	}

	public static void LogErrorMessage(Error e) throws IOException {
		Log(e);
	}

	public static String getFileName() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String fileName = "Report-" + dateFormat.format(cal.getTime());
		return fileName;
	}

	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
		return dateTime;
	}

	public static void LogAddClass(String text) {

		Log(lineSeparator + "*****************************************************************************"
				+ lineSeparator + "Execution Started of Test Class " + text + lineSeparator
				+ "*****************************************************************************" + lineSeparator);
	}

	public static void LogEndClass(String text) {

		Log(lineSeparator + "*****************************************************************************"
				+ lineSeparator + "End Execution of Test Script " + text + lineSeparator
				+ "*****************************************************************************" + lineSeparator);
	}

	public static void main(String[] str) {
		Log("Test execution");
	}

}