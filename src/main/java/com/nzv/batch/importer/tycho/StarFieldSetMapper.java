package com.nzv.batch.importer.tycho;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class StarFieldSetMapper implements FieldSetMapper<Star> {

	@Override
	public Star mapFieldSet(FieldSet fieldSet) throws BindException {
		Star star = new Star();
		star.setSkipMarker(fieldSet.readString(3));
		star.setTyc1(fieldSet.readString(0));
		star.setTyc2(fieldSet.readString(1));
		star.setTyc3(fieldSet.readString(2));
		try {
			star.setRightAscension(fieldSet.readDouble(4));
			star.setDeclinaison(fieldSet.readDouble(5));
			star.setBtMag(fieldSet.readDouble(6));
			star.setVtMag(fieldSet.readDouble(7));
			star.setHipparcosNumber(fieldSet.readInt(8));
		} catch (NumberFormatException ex) {
		}
		return star;
	}

}
