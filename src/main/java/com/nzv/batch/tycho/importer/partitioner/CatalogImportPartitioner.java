package com.nzv.batch.tycho.importer.partitioner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CatalogImportPartitioner implements Partitioner {

	@Value("${catalog_imoprt_directory}")
	private String catalogImoprtDirectory;
	
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		
		final Map<String, ExecutionContext> partitions = new HashMap<>();
		File importDirectory = new File(catalogImoprtDirectory);
		
		if (importDirectory != null && importDirectory.exists()) {
			
			ExecutionContext partitionExecutionContext;
			
			for (String importFile : importDirectory.list()) {
				partitionExecutionContext = new ExecutionContext();
				partitionExecutionContext.put("importFile", catalogImoprtDirectory + importFile);
				partitions.put(importFile + "_partition", partitionExecutionContext);
			}
		}
		
		return partitions;
	}

}
