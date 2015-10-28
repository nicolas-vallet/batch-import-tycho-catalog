package com.nzv.batch.importer.tycho;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchImportTycho {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpt = new ClassPathXmlApplicationContext(
				"batch-import-tycho-context.xml");
		cpt.start();
		JobLauncher jobLauncher = (JobLauncher) cpt.getBean("jobLauncher");
		Job job = (Job) cpt.getBean("importTychoCatalog");
		JobParameters parameter = new JobParametersBuilder().addString("INPUT_FILE",
				"C:\\Users\\Nico\\astro_atlas\\tycho2\\CATALOG.DAT").toJobParameters();
		jobLauncher.run(job, parameter);
		cpt.close();
	}
}
