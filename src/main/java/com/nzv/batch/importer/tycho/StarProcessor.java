package com.nzv.batch.importer.tycho;

import org.springframework.batch.item.ItemProcessor;

public class StarProcessor implements ItemProcessor<Star, Star> {

	@Override
	public Star process(Star star) throws Exception {
		if ("X".equals(star.getSkipMarker())) {
			return null;
		} else {
			return star;
		}
	}

}
