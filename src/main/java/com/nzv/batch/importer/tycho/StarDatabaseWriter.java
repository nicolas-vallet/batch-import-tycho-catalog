package com.nzv.batch.importer.tycho;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StarDatabaseWriter implements ItemWriter<Star> {

	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_STAR = "INSERT INTO tycho (tyc1, tyc2, tyc3, hipparcos_number, "
			+ "right_ascension, declinaison, bt_mag, vt_mag, tycho_identifier) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STAR = "UPDATE tycho SET tyc1=?, tyc2=?, tyc3=?, hipparcos_number=?, "
			+ "right_ascension=?, declinaison=?, bt_mag=?, vt_mag=? WHERE tycho_identifier=?";

	@Override
	public void write(List<? extends Star> stars) throws Exception {
		for (Star star : stars) {
			final Object[] params = { star.getTyc1(), star.getTyc2(), star.getTyc3(),
					star.getHipparcosNumber(), star.getRightAscension(), star.getDeclinaison(),
					star.getBtMag(), star.getVtMag(),
					star.getTyc1() + "." + star.getTyc2() + "." + star.getTyc3() };

			if (jdbcTemplate.update(UPDATE_STAR, params) == 0) {
				jdbcTemplate.update(INSERT_STAR, params);
			}
		}
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
