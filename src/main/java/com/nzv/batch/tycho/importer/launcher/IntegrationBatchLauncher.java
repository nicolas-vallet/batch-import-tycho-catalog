package com.nzv.batch.tycho.importer.launcher;

import static org.apache.commons.lang.time.DurationFormatUtils.formatDurationHMS;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegrationBatchLauncher {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:contexts/application-context.xml");
		
		JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
		Job job = applicationContext.getBean(Job.class);
		
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		
		log.info("Catalog import termintated : {}, exit status : {}, exit exception : {}", 
			formatDurationHMS(jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime()), jobExecution.getExitStatus(), jobExecution.getAllFailureExceptions());
	}
	
}
