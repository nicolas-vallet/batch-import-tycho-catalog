package com.nzv.batch.tycho.importer.mapper;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.nzv.batch.tycho.importer.domain.Star;

@Component
public class StarFieldSetMapper implements FieldSetMapper<Star> {

	@Override
	public Star mapFieldSet(FieldSet fieldSet) throws BindException {

		Star star = new Star();
		
		star.setId(fieldSet.readString(0) + fieldSet.readString(1) + fieldSet.readString(2));
		star.setSkipMarker(fieldSet.readString(3));
		
		star.setTyc1(fieldSet.readString(0));
		star.setTyc2(fieldSet.readString(1));
		star.setTyc3(fieldSet.readString(2));
		
		if (isNotBlank(fieldSet.readRawString(4))) {
			star.setRightAscension(fieldSet.readDouble(4));
		}
		
		if (isNotBlank(fieldSet.readRawString(5))) {
			star.setDeclinaison(fieldSet.readDouble(5));
		}
		
		if (isNotBlank(fieldSet.readRawString(6))) {
			star.setBtMag(fieldSet.readDouble(6));
		}
		
		if (isNotBlank(fieldSet.readRawString(7))) {
			star.setVtMag(fieldSet.readDouble(7));
		}
		
		if (isNotBlank(fieldSet.readRawString(8))) {
			star.setHipparcosNumber(fieldSet.readInt(8));
		}

		return star;
	}

}
